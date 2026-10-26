package hws.hw2;

/**
 * CS 159 HW 2: YahtzeeLogic.
 *
 * @author Colin Finnegan
 * @version 1/29/2024
 */
public class CollatzConjecture {

    /**
     * Prints boolean based on if there is a full house.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        System.out.println(countSteps(0));
    }

    /**
     * Prints boolean based on if there is a full house.
     *
     * @param n integer.
     * @return number of steps to 1.
     */

    public static int countSteps(int n) {
        int x = 0;
        if (n <= 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        } else {
            do {
                if (n % 2 == 0) {
                    n = n / 2;
                    x += 1;
                } else {
                    n = (n * 3) + 1;
                    x += 1;
                }
            }
            while (n != 1);
        }
        return x;
    }

}
