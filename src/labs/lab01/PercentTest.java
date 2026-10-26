package labs.lab01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Lab01 Percent.
 *
 * @author CS159 Faculty
 * @version 01/13/2024
 */
public class PercentTest {

    @Test
    public void testPercent1() {
        // test that initial percent call is numerically correct
        String actual = Percent.percent(25, 100);
        assertTrue(actual.contains("25.0") && actual.contains("100.0"));

        // test that the student added call is numerically correct
        actual = Percent.percent(6, 80);
        assertTrue(actual.contains("6.0") && actual.contains("7.5") && actual.contains("80.0"));
    }

    @Test
    public void testPercent2() {
        // test that the student added call gives correct result
        String actual = Percent.percent(6, 80);
        String expect = "6.0 is 7.5 percent of 80.0";
        assertEquals(expect, actual);
    }

    /**
     * Test the main method and all formatting.
     */
    @Test
    public void testMain() {
        // redirect system output and run main
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        Percent.main(new String[] {});
        // compare expected with actual output
        String expect = "Percentage Demonstration" + System.lineSeparator()
                + "25.0 is 25.0 percent of 100.0" + System.lineSeparator()
                + "6.0 is 7.5 percent of 80.0" + System.lineSeparator();
        String actual = output.toString();
        assertEquals(expect, actual);
    }

}
