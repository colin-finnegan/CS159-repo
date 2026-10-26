package labs.lab12;

import java.util.Random;

/**
 * A small polyhedron used to generate random numbers.
 *
 * @author Colin Finnegan
 * @version 4/30/2024
 */
public abstract class Die implements Comparable<Die> {

    private static Random random = new Random();

    protected int index;

    /**
     * Sets the random number generator seed for testing expected values.
     *
     * @param seed the initial seed
     */
    public static void test(long seed) {
        random.setSeed(seed);
    }

    /**
     * Simulates rolling the die. This method updates and returns the die's
     * current value.
     *
     * @return current value
     */
    public int roll() {
        index = random.nextInt(sides());
        return value();
    }

    /**
     * Gets the die's number of sides (i.e, how many possible values it has).
     *
     * @return number of sides
     */
    public abstract int sides();

    /**
     * Gets the die's current value (i.e., from the last time it was rolled).
     *
     * @return current value
     */
    public abstract int value();

    @Override
    public int compareTo(Die other) {
        return this.value() - other.value();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Die) {
            Die other = (Die) obj;
            return this.index == other.index
                    && this.getClass() == other.getClass();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s with %d sides (value: %d)",
                getClass().getSimpleName(), sides(), value());
    }

}
