package labs.lab12;

import java.util.Collection;


/**
 * Special Die, number of sides depends on length of values.
 *
 * @author Colin Finnegan
 * @version 04/30/2024
 */
public class SpecialDie extends Die {

    private int[] values;

    /**
     * Default constructor for Special Die.
     *
     * @param values values of each side of the die
     */
    public SpecialDie(int[] values) {

        this.values = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            this.values[i] = values[i];
        }
    }

    /**
     * Other constructor for SpecialDie.  Makes copy of values.
     *
     * @param values value for each side of die
     */
    public SpecialDie(Collection<Integer> values) {
        this.values = new int[values.size()];
        int index = 0;
        for (int value : values) {
            this.values[index++] = value;
        }
    }

    @Override
    public int sides() {
        return values.length;
    }

    @Override
    public int value() {
        return values[index];
    }
}
