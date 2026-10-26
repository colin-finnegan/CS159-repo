package hws.hw1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * CS 159 Exercise 1.4 Unit Conversion.
 *
 * @author TYPE YOUR NAME HERE
 * @version TYPE THE DATE HERE
 */
public class UnitConversionTest {

    public static final double DELTA = 0.001;

    @Test
    public void testFromCelsiusToFahrenheit() {
        assertEquals(32.0, UnitConversion.fromCelsiusToFahrenheit(0.0), DELTA);
    }

    @Test
    public void testFromFahrenheitToCelsius() {
        assertEquals(0.0, UnitConversion.fromFahrenheitToCelsius(32.0), DELTA);
    }

    @Test
    public void testFromMetersPerSecondToMilesPerHour() {
        assertEquals(0.0, UnitConversion.fromMetersPerSecondToMilesPerHour(0.0), DELTA);
    }

    @Test
    public void testFromMilesPerHourToMetersPerSecond() {
        assertEquals(0.0, UnitConversion.fromMilesPerHourToMetersPerSecond(0.0), DELTA);
    }

}
