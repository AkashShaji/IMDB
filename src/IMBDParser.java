import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IMBDParser {

    private HashMap<String, Movie> _movieMap = new HashMap<String, Movie>();
    private HashMap<String, Actor> _actorMap = new HashMap<String, Actor>();

    private String _fileActorName;
    private String _fileActressName;

    public IMBDParser(String fileActorName, String fileActressName){
        _fileActorName = fileActorName;
        _fileActressName = fileActressName;
        parse(fileActorName);
        parse(fileActressName);
    }

    private void parse(String fileName){
        Scanner sc = null;

        try {
            sc = new Scanner( new File(System.getProperty("user.dir") + "/src/IMDB/" + fileName), "ISO-8859-1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;
        String actorName = "";

        while (sc.hasNext()) {
            if (lineNumber < 239) {
                sc.nextLine();
                lineNumber++;
                continue;
            }

            String line = sc.nextLine();
            if (line.length() < 1  || line.equals("Name\t\t\tTitles ") || line.equals("----\t\t\t------")) {
                continue;
            }else if(line.equals("-----------------------------------------------------------------------------")){
                break;
            }

            char beginningOfLine = line.charAt(0);

            if (beginningOfLine != '\t' || actorName == "") {
                actorName = line.substring(0, line.indexOf('\t'));

                //System.out.println(actorName);
            }

            final String movieName = getMovieName(line);
            final List<Movie> tempMovieList = new ArrayList<Movie>();

            if (movieName != "") {
                Movie tempMovie;

                if (_movieMap.containsKey(movieName)) {
                    tempMovie = _movieMap.get(movieName);
                } else {
                    tempMovie = new Movie(movieName, new ArrayList<Actor>());
                    _movieMap.put(movieName, tempMovie);
                }

                if(!_actorMap.containsKey(actorName)){
                    Actor tempActor = new Actor(actorName, new ArrayList<Movie>());
                    _actorMap.put(actorName, tempActor);
                }

                Actor a = _actorMap.get(actorName);
                a.addMovie(tempMovie);
                _movieMap.get(movieName).addActor(a);
            }
        }
    }

    private String getMovieName (String line){
        String movie = "";
        int tabIndex = line.lastIndexOf('\t');
        int closePar = line.indexOf(')');
        if(closePar < tabIndex){
            closePar = line.indexOf(')', line.indexOf(')') + 1);
        }
        movie = line.substring(tabIndex, closePar + 1);
        if(movie.contains("\"") || movie.contains("(TV)")){
            return "";
        }
        return movie;
    }

    public HashMap<String, Movie> getMovies(){
        return _movieMap;
    }

    public HashMap<String, Actor> getActors() {
        return _actorMap;
    }
}
