package hws.hw4;

/**
 * HW 4: Hand Class.
 *
 * @author Colin Finnegan
 * @version 2/19/2024
 */


public class Hand {
    public static final int MAX_SIZE = 8;
    private Letter[] hand;
    private int size;

    /**
     * Creates a Hand object.
     *
     * @param size Desired size of hand
     */
    public Hand(int size) {
        this.size = size;
        if (this.size < 0) {
            this.size = 0;
            this.hand = new Letter[this.size];
        } else if (this.size > MAX_SIZE) {
            this.size = MAX_SIZE;
            this.hand = new Letter[this.size];
        }
        this.hand = new Letter[this.size];
    }

    /**
     * Creates a Hand object.
     *
     */
    public Hand() {
        size = MAX_SIZE;
        this.hand = new Letter[size];
    }

    public int getSize() {
        return size;
    }

    public int getHand() {
        return hand.length;
    }

    /**
     * Returns the letter at the given index.
     *
     * @param index index to look at
     * @return letter object
     */
    public Letter getLetter(int index) {
        return hand[index];
    }

    /**
     * Inserts a letter into the hand.
     *
     * @param letter letter object to insert
     * @param index index to insert at
     * @return true if it can be, false if not
     */
    public boolean insert(Letter letter, int index) {
        if (index >= 0 && index < hand.length) {
            if (hand[index] == null) {
                hand[index] = letter;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes letter at index from the hand.
     *
     * @param index index of letter to remove
     * @return the letter removed or null
     */
    public Letter remove(int index) {
        Letter test;
        if (index >= 0 && index < hand.length) {
            if (hand[index] != null) {
                test = hand[index];
                hand[index] = null;
                return test;
            }
        }
        return null;
    }

    /**
     * Finds the first index of the given character.
     *
     * @param letter character to search for.
     * @return the first index the character appeared at
     */
    public int indexOf(char letter) {
        int indx = -1;
        for (int x = 0; x < hand.length; x++) {
            if (hand[x].getLetter() == letter) {
                indx = x;
            }
            return indx;
        }
        return indx;
    }

    @Override
    public String toString() {
        String empty = "";
        for (int x = 0; x < hand.length - 1; x++) {
            if (hand[x] != null) {
                empty += hand[x].toString() + ",";
            }
        }
        int last = hand.length - 1;
        if (hand[last] != null) {
            empty += hand[last].toString();
        } else {
            empty += "-";
        }
        return empty;
    }
}
