package hws.hw1;

/**
 * CS 159 Exercise 1.4 Unit Conversion.
 *
 * @author Colin Finnegan
 * @version 1/22/2024
 */
public class UnitConversion {

    /**
     * Convert from Celsius to Fahrenheit.
     *
     * @param c temperature in Celsius
     * @return temperature in Fahrenheit
     */
    public static double fromCelsiusToFahrenheit(double c) {
        return 1.8 * c + 32;
    }

    /**
     * Convert from Fahrenheit to Celsius.
     *
     * @param f temperature in Fahrenheit
     * @return temperature in Celsius
     */
    public static double fromFahrenheitToCelsius(double f) {
        return ((f - 32) * 5) / 9;
    }

    /**
     * Convert from meters per second to miles per hour.
     *
     * @param mps speed in meters per second
     * @return speed in miles per hour
     */
    public static double fromMetersPerSecondToMilesPerHour(double mps) {
        return ((mps / 1000) / 1.60934) * 3600;
    }

    /**
     * Convert from miles per hour to meters per second.
     *
     * @param mph speed in miles per hour
     * @return speed in meters per second
     */
    public static double fromMilesPerHourToMetersPerSecond(double mph) {
        return ((mph / 3600) * 1.60934) * 1000;
    }

}
