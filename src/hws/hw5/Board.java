package hws.hw5;

import hws.hw4.Letter;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Represents a Scrabble Board.
 *
 * @author Colin Finnegan
 * @version 02/26/2024
 */
public class Board {

    private Letter[] entries;
    private int[] pointMult;
    private ArrayList<String> words;


    /**
     * Construct a Board.
     *
     * @param multiplier multipliers for each letter in word
     * @param wordsPath list of valid words
     */
    public Board(int[] multiplier, String wordsPath) {
        this.entries = new Letter[multiplier.length];
        this.pointMult = new int[multiplier.length];
        this.pointMult = Arrays.copyOf(multiplier, multiplier.length);
        for (int x = 0; x < multiplier.length; x++) {
            this.pointMult[x] = multiplier[x];
        }
        try {
            this.words = WordsUtility.readWords(wordsPath);
        } catch (FileNotFoundException exc) {
            this.words = new ArrayList<String>();
            System.out.println("Error" + exc);
        }
    }


    /**
     * Construct a copy of board.
     *
     * @param board board to copy
     * @param multiplier multipliers for each letter in word
     * @param wordsPath list of valid words
     */
    public Board(Letter[] board, int[] multiplier, String wordsPath) {
        this(multiplier, wordsPath);
        this.entries = board;
    }


    /**
     * Sets the entries if index is in range.
     *
     * @param entries copies contents of entries
     */
    public void setEntries(Letter[] entries) {
        if (this.entries.length == entries.length) {
            for (int i = 0; i < entries.length; i++) {
                this.entries[i] = entries[i];
            }
        }
    }

    public Letter[] getEntries() {
        return entries;
    }


    /**
     * Gets the letter at specified index.
     *
     * @param index index to look at
     * @return Letter at the index
     */
    public Letter getLetter(int index) {
        if (index < 0 || index >= entries.length) {
            throw new IllegalArgumentException();
        }
        return entries[index];
    }


    /**
     * Gets the score of the letter at specified index.
     *
     * @param index index to look at
     * @return Score of Letter at index
     */
    public int getLetterScore(int index) {
        if (index >= 0 && index < entries.length && entries[index] != null) {
            return entries[index].getPoints() * pointMult[index];
        }
        return 0;
    }

    /**
     * Gets the point Multiplier.
     *
     * @param index index to look at
     * @return Point Multiplier at specified index
     */
    public int getPointMult(int index) {
        if (index < 0 || index >= pointMult.length) {
            throw new IllegalArgumentException();
        }
        return pointMult[index];
    }

    /**
     * Adds letter at index if index is in range and no letter at index.
     *
     * @param index index to look at
     * @param letter Letter object to potentially add
     * @return true if letter can be added
     */

    public boolean play(Letter letter, int index) {
        if (index >= 0 && index < entries.length && entries[index] == null) {
            entries[index] = letter;
            return true;
        }
        return false;
    }


    /**
     * Reads the letters on the board.
     *
     *
     * @return String of board letters
     */
    public String readBoardWord() {
        String word = "";
        int first = entries.length;
        int last = -1;

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                first = i;
                break;
            }
        }

        for (int j = entries.length - 1; j >= 0; j--) {
            if (entries[j] != null) {
                last = j;
                break;
            }
        }

        for (int k = first; k <= last; k++) {
            if (entries[k] != null) {
                word += entries[k].getLetter();
            } else {
                word += "-";
            }
        }

        return word;
    }


    /**
     * Checks validity of the word.
     *
     * @param word word to check
     * @return true if word is valid
     */
    public boolean wordValidation(String word) {
        for (String w : words) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Gets the score of the word if it is a valid word.
     *
     *
     * @return score of word
     */
    public int getBoardScore() {
        int total = 0;
        if (!wordValidation(this.readBoardWord())) {
            return 0;
        }
        for (int i = 0; i < entries.length; i++) {
            total += getLetterScore(i);
        }
        return total;
    }


    /**
     * Prints contents of entries array.
     *
     *
     * @return String of values in entries
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                str += entries[i].toString() + ", ";
            } else {
                str += "-, ";
            }
        }
        return str;
    }

}
