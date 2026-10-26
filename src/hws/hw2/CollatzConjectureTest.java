package hws.hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CollatzConjectureTest {

    @Test
    public void testInvalid() {
        assertEquals(-1, CollatzConjecture.countSteps(0));
    }

    @Test
    public void testEven() {
        assertEquals(1, CollatzConjecture.countSteps(2));
    }

    @Test
    public void testOdd() {
        assertEquals(0, CollatzConjecture.countSteps(1));
    }

}
