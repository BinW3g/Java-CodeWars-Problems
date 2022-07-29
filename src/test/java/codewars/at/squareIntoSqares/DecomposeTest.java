package codewars.at.squareIntoSqares;

import static org.junit.Assert.*;
import org.junit.Test;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        assertEquals(null,  d.decompose(4));
        assertEquals("1 2 4 10",  d.decompose(11));
        assertEquals("1 3 5 8 49",  d.decompose(50));
        assertEquals("1 2 3 7 9",  d.decompose(12));
    }
}
