import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IMBDParser {

    private HashMap<String, Movie> _movieMap = new HashMap<String, Movie>();
    private HashMap<String, Actor> _ActoreMap = new HashMap<String, Actor>();

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
            sc = new Scanner( new File(System.getProperty("user.dir") + "/src/IMDB/" + _fileActorName));
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
            String line = sc.nextLine();

            if (line.length() < 1) {
                continue;
            }

            char beginningOfLine = line.charAt(0);
            String actorName = "";

            if (beginningOfLine != '\t' || actorName == "") {
                actorName = line.substring(0, line.indexOf('\t'));
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
                tempMovieList.add(tempMovie);

                Actor tempActor = new Actor(actorName, new ArrayList<Movie>());
                _ActoreMap.put(actorName, tempActor);

                _movieMap.get(movieName).addActor(tempActor);
            }
        }
    }

    private String getMovieName (String line){
        System.out.println(line);
        String movie = line.substring(line.lastIndexOf('\t'), line.indexOf(')'));
        if(movie.contains("\"") || movie.contains("(TV)")){
            return "";
        }
        return movie;
    }
}
