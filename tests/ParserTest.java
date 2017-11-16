import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testParse(){
        System.out.println(System.getProperty("user.dir"));


        IMBDParser i = new IMBDParser("IMDB/actors_test.list", "IMDB/actresses_test.list");
        HashMap<String, Actor> actors = i.getActors();
        for(String k : actors.keySet()){
            //System.out.println(k + ": " + actors.get(k).movies);
            for(Movie m : actors.get(k).getNeighbors()) {
                System.out.println(actors.get(k).getName() + ": " + m.getName());
            }
        }
        assertTrue(true);
    }
}
