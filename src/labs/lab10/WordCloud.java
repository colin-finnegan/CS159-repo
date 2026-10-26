package labs.lab10;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import java.io.File;


/**
 * Collection of terms (root words) to be displayed in a word cloud.
 *
 * @author Colin Finnegan
 * @version 04/16/2024
 */
public class WordCloud {

    private Map<String, Integer> map;

    /**
     * Constructs an empty word cloud.
     */
    public WordCloud() {
        map = new TreeMap<>();
    }

    /**
     * Adds or updates a term in the word cloud.
     *
     * @param word the original word
     */
    public void add(String word) {
        String term = normalize(word);
    }

    /**
     * Adds all the terms in the given file to the word cloud.
     *
     * @param path the file location
     * @return number of words added
     * @throws FileNotFoundException if path is not found
     */
    public int addAll(String path) throws FileNotFoundException {
        int count = 0;
        File file = new File(path);
        Scanner in = new Scanner(file);
        while (in.hasNext()) {
            String word = in.next();
            add(word);
            count++;
        }
        in.close();
        return count;
    }

    /**
     * Gets the frequency/word count of a term in the word cloud.
     *
     * @param term the term to look up
     * @return the frequency of the term
     */
    public int getFrequency(String term) {
        return map.get(term);
    }

    /**
     * Gets the number of unique terms in the word cloud.
     *
     * @return number of unique terms
     */
    public int termCount() {
        return map.size();
    }

    /**
     * Gets the total number of words in the word cloud.
     *
     * @return total number of words
     */
    public int totalWordCount() {
        int total = 0;
        for (int i : map.values()) {
            total += i;
        }
        return total;
    }

    /**
     * Removes a term from the word cloud.
     *
     * @param word the original word
     * @return the count of the term, or 0 if not found
     */
    public int remove(String word) {
        return 0;
    }

    /**
     * Removes all terms with a count less than the given threshold.
     *
     * @param threshold the minimum count to keep
     * @return number of terms removed
     */
    public int removeAllLessThan(int threshold) {
        return 0;
    }

    /**
     * Generates HTML code for displaying the word cloud. Each term is a span
     * with font-size based on the count. Terms must be in alphabetical order.
     *
     * @return the word cloud in HTML format
     */
    public String generateHTML() {
        return "";
    }

    /**
     * Returns a negative integer, zero, or a positive integer depending on
     * whether this object has fewer, the same, or more terms than the other.
     *
     * @param wc the other WordCloud
     * @return negative, zero, or positive
     */
    public int compareTo(WordCloud wc) {
        return this.termCount() - wc.termCount();
    }

    /**
     * Returns an Iterator of the WordCloud's terms in alphabetical order.
     *
     * @return the iterator object
     */
    public Iterator<String> iterator() {
        return null;
    }

    /**
     * Normalizes a word by removing punctuation, making it lowercase, and
     * running the Porter stemming algorithm.
     *
     * @param word the word to normalize
     * @return normal form of the word
     */
    public static String normalize(String word) {
        return word;
    }
}
