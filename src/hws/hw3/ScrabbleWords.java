package hws.hw3;


/**
 * CS 159 HW 3: ScrabbleWords.
 *
 * @author Colin Finnegan
 * @version 2/5/2024
 */

public class ScrabbleWords {

    /**
     * Check if every letter of the word appears exactly twice. This method
    * ignores case when comparing letters.
    *
    *
    * @param word the word to check
    * @return true if word is a doubloon
     */

    public static boolean doubloon(String word) {
        String word2 = word.toLowerCase();
        for (int x = 0; x < word2.length(); x++) {
            int ltrCount = 0;
            for (int xy = 0; xy < word2.length(); xy++) {
                if (word2.charAt(x) == word2.charAt(xy)) {
                    ltrCount += 1;
                }
            }
            if (ltrCount != 2) {
                return false;
            }
        }
        return true;
    }
}
