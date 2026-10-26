package labs.lab12;

/**
 * A regular Die, an extension of the abstract Die class.
 *
 * @author Colin Finnegan
 * @version 04/30/2024
 *
 */
public class RegularDie extends Die {

    private int sides;

    /**
     * Default constructor, makes a Regular Die.
     */
    public RegularDie() {
        this.sides = 6;
    }

    /**
     * Value constructor for Regular Die, throws IllegalArgumentException if
     * sides is less than 2 or greater than 100.
     *
     * @param sides number of sides the die has.
     */
    public RegularDie(int sides) {
        if (sides < 2 || sides > 100) {
            throw new IllegalArgumentException();
        }
        this.sides = sides;
    }

    @Override
    public int sides() {
        return sides;
    }

    @Override
    public int value() {
        return index + 1;
    }

}
