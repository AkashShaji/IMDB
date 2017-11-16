import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * A class that takes in two file names and builds
 * a hash map of the actor nodes and movie nodes
 */

public class IMBDParser {

    private HashMap<String, Movie> _movieMap = new HashMap<String, Movie>();
    private HashMap<String, Actor> _actorMap = new HashMap<String, Actor>();

    public IMBDParser(String fileActorName, String fileActressName){
        parse(fileActorName);
        parse(fileActressName);
    }

    /**
     * Takes a file and adds actors and movies to the hash map.
     * @param fileName The name of file to be parsed
     */
    private void parse(String fileName){
        Scanner sc = null;
        try {
            sc = new Scanner( new File(fileName), "ISO-8859-1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;
        String actorName = "";
        Boolean prelude = true;
        while (sc.hasNext()) {
            //Checks to see if scanner is still in prelude
            if (prelude) {
                String preludeLine = sc.nextLine();
                //Line that states that the prelude has ended so set prelude to false.
                if(preludeLine.equals("----\t\t\t------")){
                    prelude = false;
                }
                continue;
            }
            String line = sc.nextLine();
            //Check to see if line is blank or still part of intro, if it is skip checking it
            if (line.length() < 1) {
                continue;
            //Checks for end of actor list
            }else if(line.equals("-----------------------------------------------------------------------------")){
                break;
            }
            //Gets the first character in line; if it is not a tab or no actor is selected yet, update current actor name
            final char beginningOfLine = line.charAt(0);
            if (beginningOfLine != '\t' || actorName == "") {
                actorName = line.substring(0, line.indexOf('\t'));
            }
            //Get the name of the movie on the line
            final String movieName = getMovieName(line);
            //If line contains movie
            if (movieName != "") {
                //Will either return a new movie object or if movie has already been added to hash map that object
                final Movie tempMovie = checkIfMovieExists(movieName);
                //Checks to see if actor is already in hash map, if not add it.
                if(!_actorMap.containsKey(actorName)){
                    final Actor tempActor = new Actor(actorName, new ArrayList<Movie>());
                    _actorMap.put(actorName, tempActor);
                }
                //Gets the actor and adds the movie and adds the actor to movie.
                final Actor a = _actorMap.get(actorName);
                a.addMovie(tempMovie);
                _movieMap.get(movieName).addActor(a);
            }
        }
    }

    /**
     * Returns a movie object to be added to the hash map.
     * @param movieName The name of the movie
     * @return a new movie object or an existing one the represent the given movie name
     */
    private Movie checkIfMovieExists(String movieName){
        Movie tempMovie;
        //Checks to see if movie exists within the hash map, if it does return the movie, if not create a new movie and return that
        if (_movieMap.containsKey(movieName)) {
            tempMovie = _movieMap.get(movieName);
        } else {
            tempMovie = new Movie(movieName, new ArrayList<Actor>());
            _movieMap.put(movieName, tempMovie);
        }
        return tempMovie;
    }

    /**
     *  Returns the name of the movie in the given line
     * @param line Line to get the name out ot
     * @return the name of the movie from the line
     */
    private String getMovieName (String line){
        String movie = "";
        //Collects index's
        int tabIndex = line.lastIndexOf('\t');
        int closePar = line.indexOf(')');
        //If the close parentheses comes before tab (there is a parentheses in the actor name) get the second occurrence of parentheses.
        if(closePar < tabIndex){
            closePar = line.indexOf(')', line.indexOf(')') + 1);
        }
        //Get movie name and throw out if is TV or TV movie
        movie = line.substring(tabIndex, closePar + 1);
        if(movie.contains("\"") || movie.contains("(TV)")){
            return "";
        }
        return movie;
    }

    /**
     *  Returns hash map
     * @return the hash map of movies
     */
    public HashMap<String, Movie> getMovies(){
        return _movieMap;
    }

    /**
     *  Returns hash map
     * @return the hash map of actors
     */
    public HashMap<String, Actor> getActors() {
        return _actorMap;
    }
}
