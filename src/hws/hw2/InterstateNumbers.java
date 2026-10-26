package hws.hw2;

/**
 * CS 159 HW 2: Interstate Numbers.
 *
 * @author Colin Finnegan
 * @version 1/29/2024
 */
public class InterstateNumbers {

    /**
     * The main method to demo method calls.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println(getInfo(734));
    }
    /**
     * The main method to demo method calls.
     *
     * @param number command-line arguments
     * @return route to follow
     */

    public static String getInfo(int number) {
        if (number < 1 || number > 999) {
            return "invalid";
        }
        String route = Integer.toString(number);
        for (int i = 0; i < route.length(); i++) {
            if (route.length() > 2) {
                int first = (int) route.charAt(0);
                if (first % 2 == 0) {
                    return "beltway for I-" + route.charAt(1) + route.charAt(2);
                } else {
                    return "spur for I-" + route.charAt(1) + route.charAt(2);
                }
            } else {
                int last = (int) route.charAt(route.length() - 1);
                if (last % 2 == 0) {
                    return "primary east-west";
                } else {
                    return "primary north-south";
                }
            }
        }
        return " hallo";
    }

}
