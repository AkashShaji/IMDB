import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IMBDParser {

    private HashMap<String, Movie> _movieMap = new HashMap<String, Movie>();
    private HashMap<String, Actor> _actoreMap = new HashMap<String, Actor>();

    private String _fileActorName;
    private String _fileActressName;

    public IMBDParser(String fileActorName, String fileActressName){
        _fileActorName = fileActorName;
        _fileActressName = fileActressName;
    }

    public void parse(){
        Scanner sc = null;
        String currentActor;

        try {
            sc = new Scanner( new File(System.getProperty("user.dir") + "/src/IMDB/" + _fileActorName), "ISO-8859-1");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;

        while (sc.hasNext()) {
            if (lineNumber < 239) {
                sc.nextLine();
                lineNumber++;
                continue;
            }
            lineNumber++;
            if(lineNumber%1000000 == 0){
                System.out.println(lineNumber/1000000);
            }
            String line = sc.nextLine();
            if (line.length() < 1) {
                continue;
            }else if(line == "-----------------------------------------------------------------------------\n"){
                break;
            }

            char beginningOfLine = line.charAt(0);
            String actorName = "";

            if (beginningOfLine != '\t' || actorName == "") {
                try {
                    actorName = line.substring(0, line.indexOf('\t'));
                }catch(StringIndexOutOfBoundsException e){
                    System.out.println(line);
                }
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

                if(!_actoreMap.containsKey(actorName)){
                    Actor tempActor = new Actor(actorName, new ArrayList<Movie>());
                    _actoreMap.put(actorName, tempActor);
                }

                Actor a = _actoreMap.get(actorName);
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
        movie = line.substring(tabIndex , closePar);
        if(movie.contains("\"") || movie.contains("(TV)")){
            return "";
        }
        return movie;
    }
}
