package hws.hw3;

/**
 * CS 159 HW 3: Nifty Spelling.
 *
 * @author Colin Finnegan
 * @version 2/5/2024
 */
public class NiftySpelling {
    /**
     * Checks if the letters in the given word appear in alphabetical order.
     *
     *
     * @param word the word to check.
     *
     * @return true if word is abecedarian.
     */

    public static boolean abecedarian(String word) {
        String word2 = word;
        int count = 0;
        for (int x = 0; x < word2.length() - 1; x++) {
            if (word2.codePointAt(x) < word2.codePointAt(x + 1)) {
                count++;
            }

        }
        return count == word2.length() - 1;
    }
}
