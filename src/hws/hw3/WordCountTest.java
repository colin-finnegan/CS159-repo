package hws.hw3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class WordCountTest {

    @Test
    public void testWordCount() {
        String number = "This is the first line.\nThis is the second.";
        assertArrayEquals(new int[] {1, 9, 43}, WordCount.analyze(number));
    }
    @Test
    public void testWord() {
        String number = "First line.\nThis is the\nsecond.";
        assertArrayEquals(new int[] {2, 6, 31}, WordCount.analyze(number));
    }
    @Test
    public void testWod() {
        String number = "";
        assertArrayEquals(new int[] {0, 0, 0}, WordCount.analyze(number));
    }
}
