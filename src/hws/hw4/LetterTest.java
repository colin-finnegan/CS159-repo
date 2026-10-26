package hws.hw4;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

/**
 * Test the Letter Class
 * @author Colin Finnegan
 * @version 2/19/2024
 */

public class LetterTest {

    @Test
    public void testLetter() {
        Letter l = new Letter('c', 4);
        assertEquals('c', l.getLetter());
        assertEquals(4, l.getPoints());
        assertEquals("c:4", l.toString());
        l.setLetter('c');
        l.setPoints(0);
    }

    @Test
    public void testLeter() {
        Letter lt = new Letter('e', 6);
        Letter hallo = new Letter('r', 3);
        lt.equals(lt.getPoints());
        assertEquals(false, lt.equals(lt.getPoints()));
        assertEquals(false, lt.equals(hallo));
        assertEquals(true, lt.equals(lt));
        assertEquals(6, lt.getPoints());
        assertEquals("e:6", lt.toString());
    }
}
