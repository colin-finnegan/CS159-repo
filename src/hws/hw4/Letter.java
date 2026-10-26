package hws.hw4;

/**
 * HW 4: Letter Class.
 *
 * @author Colin Finnegan
 * @version 2/19/2024
 */

public class Letter {
    private char letter;
    private int points;

    /**
     * Constructs a Letter object.
     *
     * @param letter the Letter's character
     * @param points the Letter's points
     */

    public Letter(char letter, int points) {
        this.letter = letter;
        this.points = points;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public char getLetter() {
        return letter;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Letter) {
            Letter other = (Letter) obj;
            return letter == other.letter && points == other.points;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%c:%d", letter, points);
    }
}
