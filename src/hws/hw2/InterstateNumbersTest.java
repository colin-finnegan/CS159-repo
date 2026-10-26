package hws.hw2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InterstateNumbersTest {

    @Test
    public void testInvalid() {
        assertEquals("invalid", InterstateNumbers.getInfo(0));
    }

    @Test
    public void testPrimary() {
        assertEquals("primary north-south", InterstateNumbers.getInfo(81));
    }

    @Test
    public void testAuxiliary() {
        assertEquals("beltway for I-95", InterstateNumbers.getInfo(495));
    }

}
