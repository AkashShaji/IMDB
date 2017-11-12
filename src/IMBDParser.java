import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IMBDParser {
    public IMBDParser(){}

    public void parse(){
        Scanner sc = null;
        try {
            sc = new Scanner( new File("actors_test.list"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        while (sc.hasNext()) {
            String word = sc.next();
            System.out.println(word);
            count++;
            if(count > 100){
                break;
            }
        }
    }
}
