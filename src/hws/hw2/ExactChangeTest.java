package hws.hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class ExactChangeTest {

    /**
     * Helper method that captures the output.
     *
     * @param total the total charge for the purchase
     * @param paid the amount paid (in whole dollars)
     * @param coins expected output (via System.out)
     */
    private void test(double total, int paid, String coins) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        ExactChange.printCoins(total, paid);
        String actual = output.toString().replace("\r", "");
        assertEquals(coins, actual);
    }

    /**
     * One coin should be singular.
     */
    @Test
    public void testOne() {
        test(19.99, 20, "1 penny\n");
    }

    /**
     * Two coins should be plural.
     */
    @Test
    public void testTwo() {
        test(18.01, 20, "1 dollar\n3 quarters\n2 dimes\n4 pennies\n");
    }

    /**
     * General cases: zero or many coins.
     */
    @Test
    public void testMany() {
        test(19.81, 20, "1 dime\n1 nickel\n4 pennies\n");
    }

}
