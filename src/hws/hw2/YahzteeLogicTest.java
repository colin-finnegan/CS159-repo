package hws.hw2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class YahzteeLogicTest {

    @Test
    public void testFullHouse() {
        assertTrue(YahzteeLogic.isFullHouse(2, 3, 0, 0, 0, 0));
    }

    @Test
    public void testStraight() {
        assertTrue(YahzteeLogic.isStraight(true, 1, 1, 1, 1, 0, 0));
    }

}
