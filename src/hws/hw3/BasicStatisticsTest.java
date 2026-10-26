package hws.hw3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BasicStatisticsTest {
    @Test
    public void testStandardDev() {
        double[] number = {82, 88, 97, 80, 79, 92};
        assertEquals(6.599663291074444, BasicStatistics.stdDev(number), 0.001);
    }

    @Test
    public void testMean() {
        double[] number = {82, 88, 97, 80, 79, 92};
        assertEquals(86.33333333333333, BasicStatistics.mean(number), 0.001);
    }
}
