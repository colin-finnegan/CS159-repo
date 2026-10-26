package hws.hw3;

/**
 * CS 159 HW 3: Basic Statistics.
 *
 * @author Colin Finnegan
 * @version 2/5/2024
 */

public class WordCount {

    /**
    * Counts number of newlines, words, and characters in a given string.
    *
    * @param sentence String to be analyzed.
    * @return array of newline, words, and char counts.
    */

    public static int[] analyze(String sentence) {
        int newline = 0;
        int words = 0;
        int characters = 0;
        for (char c : sentence.toCharArray()) {
            characters++;
            if (Character.isWhitespace(c)) {
                newline++;
                words++;
            }
        }
        for (int x = 0; x < sentence.length() - 1; x++) {
            if (sentence.substring(x, x + 1).equals(" ")) {
                newline -= 1;
            }

        }
        words = sentence.split("\\s").length;

        if (sentence.equals("")) {
            newline = 0;
            words = 0;
            characters = 0;
        }
        int[] values = {0, 0, 0};
        values[0] = newline;
        values[1] = words;
        values[2] = characters;

        return values;
    }
}
