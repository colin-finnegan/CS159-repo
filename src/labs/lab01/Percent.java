package labs.lab01;

/**
 * CS 159 Lab 1: Getting Started.
 *
 * @author Colin Finnegan
 * @version 1/18/2024
 */
public class Percent {

    /**
     * The main method to demo method calls.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Percentage Demonstration");
        System.out.println(percent(1, 2));
    }

    /**
     * Calculate the percentage of num1 in num2.
     *
     * @param num1 dividend (the number to be divided)
     * @param num2 divisor (the number to divide by)
     * @return explanation of the percentage
     */
    public static String percent(double num1, double num2) {
        if (num1 == 1 && num2 == 2) {
            System.out.println(10 % 3);
        }
        double percentage;
        percentage = num1 / num2 * 100;
        String result = num1 + " is " + percentage + " percent of " + num2;
        return result;
    }

}
