package hws.hw2;

/**
 * CS 159 HW 2: Exact Change.
 *
 * @author Colin Finnegan
 * @version 1/29/2024
 */
public class ExactChange {
    /**
     * Prints amount of change owed.
     *
     * @param total total amount cost.
     * @param paid amount paid by customer.
     */

    public static void printCoins(double total, int paid) {
        double change = (paid / 0.01) - (total / 0.01);
        int dollar = 0;
        int quarter = 0;
        int dime = 0;
        int nickel = 0;
        int penny = 0;

        dollar = (int) (change / 100);
        change = change % 100;
        if (dollar > 1) {
            System.out.print(dollar + " dollars\n");
        } else if (dollar == 1) {
            System.out.print(dollar + " dollar\n");
        }
        quarter = (int) (change / 25);
        change = change % 25;
        if (quarter > 1) {
            System.out.print(quarter + " quarters\n");
        } else if (quarter == 1) {
            System.out.print(quarter + " quarter\n");
        }
        dime = (int) (change / 10);
        change = change % 10;
        if (dime > 1) {
            System.out.print(dime + " dimes\n");
        } else if (dime == 1) {
            System.out.print(dime + " dime\n");
        }
        nickel = (int) (change / 5);
        change = change % 5;
        if (nickel > 1) {
            System.out.print(nickel + " nickels\n");
        } else if (nickel == 1) {
            System.out.print(nickel + " nickel\n");
        }
        penny = (int) (change / 1);
        if (penny > 1) {
            System.out.print(penny + " pennies\n");
        } else if (penny == 1) {
            System.out.print(penny + " penny\n");
        }
    }
}
