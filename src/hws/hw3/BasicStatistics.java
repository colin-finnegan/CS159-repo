package hws.hw3;

/**
 * CS 159 HW 3: Basic Statistics.
 *
 * @author Colin Finnegan
 * @version 2/5/2024
 */

public class BasicStatistics {

    /**
    * Calculates the mean of an array of numbers.
    *
    * @param numbers array of numbers
    * @return mean of those numbers
    */

    public static double mean(double[] numbers) {
        double total = 0;
        double length = numbers.length;
        for (double value : numbers) {
            total += value;
        }
        return total / length;
    }

    /**
    * Calculates the standard deviation of an array of numbers.
    *
    * @param numbers array of numbers
    * @return standard deviation of those numbers
    */

    public static double stdDev(double[] numbers) {
        double bean = mean(numbers);
        double diff = 0;
        double sqrRt = numbers.length;
        for (double value : numbers) {
            diff += Math.pow((value - bean), 2);
        }
        double mean2 = diff / sqrRt;
        return Math.sqrt(mean2);
    }
}
