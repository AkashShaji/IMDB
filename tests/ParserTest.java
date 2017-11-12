import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void testParse(){
        IMBDParser i = new IMBDParser();
        i.parse();
        assertTrue(true);
    }
}
