package hws.hw5;

import hws.hw4.Letter;

/**
 * Represents a hand of Shortcut Scrabble.
 *
 * @author Colin Finnegan
 * @version 02/26/2024
 */
public class EnhancedHand {

    public static final int MAX_SIZE = 8;

    private Letter[] hand;

    /**
     * Construct a hand with default size (MAX_SIZE).
     */
    public EnhancedHand() {
        this(MAX_SIZE);
    }

    /**
     * Construct a hand with size.
     *
     * @param size number of Letters in Hand
     */
    public EnhancedHand(int size) {
        if (size < 0) {
            hand = new Letter[0];
        } else if (size > MAX_SIZE) {
            hand = new Letter[MAX_SIZE];
        } else {
            hand = new Letter[size];
        }
    }

    /**
     * Construct a copy of other.
     *
     * @param otherHand Hand to copy
     */

    public EnhancedHand(EnhancedHand otherHand) {
        this(otherHand.hand.length);
        for (int i = 0; i < hand.length; i++) {
            Letter letter = otherHand.hand[i];
            if (letter != null) {
                Letter copy = new Letter(letter.getLetter(),
                        letter.getPoints());
                this.insert(copy, i);
            }
        }
    }

    public int getSize() {
        return hand.length;
    }

    /**
     * Gets the letter from the hand.
     *
     * @param index from which to get the Letter
     * @return Letter at that index
     */
    public Letter getLetter(int index) {
        return hand[index];
    }

    /**
     * Inserts letter at index.
     *
     * @param letter to insert
     * @param index at which to insert
     */
    public void insert(Letter letter, int index) {
        if (index < 0 || index >= hand.length || hand[index] != null
                || this.hand == null) {
            throw new IllegalArgumentException("index is: " + index);
        }
        hand[index] = letter;
    }

    /**
     * Remove letter at index.
     *
     * @param index at which to remove
     * @return Letter removed
     */
    public Letter remove(int index) {
        Letter returnVal = null;
        if (index >= 0 && index < hand.length) {
            returnVal = hand[index];
            hand[index] = null;
        } else {
            throw new IllegalArgumentException("index is " + index);
        }
        return returnVal;
    }

    /**
     * Find the position of letter in the hand.
     *
     * @param letter to find in hand
     * @return index of the letter
     */
    public int indexOf(char letter) {
        for (int i = 0; i < hand.length; i++) {
            if (hand[i] != null && hand[i].getLetter() == letter) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Represents the Hand as a String.
     *
     * @return string representation of the hand
     */
    public String toString() {
        String returnVal = "";
        for (int i = 0; i < hand.length; i++) {
            String letter = "-,";
            if (hand[i] != null) {
                letter = hand[i].toString() + ",";
            }
            returnVal += letter;
        }
        return returnVal.substring(0, returnVal.length() - 1);
    }

}
