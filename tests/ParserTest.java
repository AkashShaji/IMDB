import org.junit.Test;

import java.nio.file.FileSystems;
import java.util.HashMap;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testParse(){
        System.out.println(System.getProperty("user.dir"));


        IMBDParser i = new IMBDParser("actors_mini.list", "actresses_mini.list");
        HashMap<String, Actor> actors = i.getActors();
        for(String k : actors.keySet()){
            //System.out.println(k + ": " + actors.get(k).movies);
            for(Movie m : actors.get(k).movies) {
                System.out.println(actors.get(k).name + ": " + m.name);
            }
        }
        assertTrue(true);
    }
}
