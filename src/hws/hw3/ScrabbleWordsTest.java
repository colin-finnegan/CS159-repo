package hws.hw3;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ScrabbleWordsTest {
    @Test
    public void testDoubloon() {
        assertTrue(ScrabbleWords.doubloon("Hannah"));
        assertFalse(ScrabbleWords.doubloon("Banana"));
        assertTrue(ScrabbleWords.doubloon("Toot"));
        assertFalse(ScrabbleWords.doubloon("Apple"));
        assertTrue(ScrabbleWords.doubloon("Chooch"));
        assertFalse(ScrabbleWords.doubloon("Hurry"));
    }
}
