import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class IMBDParser {

    private HashMap<String, Movie> movieMap = new HashMap<String, Movie>();

    private String _fileActorName;
    private String _fileActressName;

    public IMBDParser(String fileActorName, String fileActressName){
        _fileActorName = fileActorName;
        _fileActressName = fileActressName;
    }

    public void parse(){
        Scanner sc = null;
        try {
            sc = new Scanner( new File(System.getProperty("user.dir") + "/src/IMDB/" + _fileActorName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int lineNumber = 0;


        while (sc.hasNext()) {
            String word = sc.nextLine();

            if(lineNumber >= 239) {
                System.out.println(word);
            }

            lineNumber++;
        }
    }
}
