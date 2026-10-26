package hws.hw2;

/**
 * CS 159 HW 2: YahtzeeLogic.
 *
 * @author Colin Finnegan
 * @version 1/29/2024
 */
public class YahzteeLogic {

    /**
     * Prints boolean based on if there is a full house.
     *
     * @param c1 first dice.
     * @param c2 second dice.
     * @param c3 third dice.
     * @param c4 fourth dice.
     * @param c5 fifth dice.
     * @param c6 sixth dice.
     * @return boolean.
     */
    public static boolean isFullHouse(int c1, int c2, int c3, int c4, int c5,
            int c6) {
        if (c1 == 3 || c2 == 3 || c3 == 3 || c4 == 3 || c5 == 3 || c6 == 3) {
            if (c1 == 2 || c2 == 2 || c3 == 2 || c4 == 2 || c5 == 2
                    || c6 == 2) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prints boolean based on if there is a straight.
     *
     * @param small boolean if looking for small straight.
     * @param c1 first dice.
     * @param c2 second dice.
     * @param c3 third dice.
     * @param c4 fourth dice.
     * @param c5 fifth dice.
     * @param c6 sixth dice.
     * @return boolean.
     */
    public static boolean isStraight(boolean small, int c1, int c2, int c3,
            int c4, int c5, int c6) {
        if (!small) {
            if (c1 > 0 && c2 > 0 && c3 > 0 && c4 > 0 && c5 > 0) {
                return true;
            } else if (c2 > 0 && c3 > 0 && c4 > 0 && c5 > 0 && c6 > 0) {
                return true;
            }
        } else {
            if (c1 > 0 && c2 > 0 && c3 > 0 && c4 > 0) {
                return true;
            } else if (c2 > 0 && c3 > 0 && c4 > 0 && c5 > 0) {
                return true;
            } else if (c3 > 0 && c4 > 0 && c5 > 0 && c6 > 0) {
                return true;
            }
        }
        return false;

    }
}
