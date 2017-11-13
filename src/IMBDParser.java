import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IMBDParser {
    public IMBDParser(){}

    public void parse(){
        Scanner sc = null;
        try {
            sc = new Scanner( new File(System.getProperty("user.dir") + "/src/IMDB/actors.list"));
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
