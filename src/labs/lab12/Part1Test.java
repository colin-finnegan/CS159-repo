package labs.lab12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * JUnit tests for Part 1 of the exam.
 *
 * @author CS149 Faculty
 * @version 04/29/2024
 */
public class Part1Test {

    /**
     * Tests the RegularDie class.
     */
    @Test
    public void testRegular() {

        // test a 6-sided die
        Die d6 = new RegularDie();
        assertEquals(6, d6.sides());
        assertEquals(1, d6.value());
        Die.test(1);
        assertEquals(4, d6.roll());
        assertEquals(5, d6.roll());

        // test a 20-sided die
        Die d20 = new RegularDie(20);
        assertEquals(20, d20.sides());
        assertEquals(1, d20.value());
        Die.test(2);
        assertEquals(9, d20.roll());
        assertEquals(13, d20.roll());

        // invalid number of sides
        assertThrows(IllegalArgumentException.class, () -> {
            new RegularDie(-1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new RegularDie(1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new RegularDie(101);
        });
    }

    /**
     * Tests the SpecialDie class.
     */
    @Test
    public void testSpecial() {

        // test with an array
        int[] vals1 = {4, 1, 7, 12, 10, 5, 8};
        Die d1 = new SpecialDie(vals1);
        assertEquals(7, d1.sides());
        assertEquals(4, d1.value());
        Die.test(3);
        assertEquals(5, d1.roll());
        assertEquals(5, d1.roll());

        // make sure they copied the values
        for (int i = 0; i < vals1.length; i++) {
            vals1[i] = 0;
        }
        assertEquals(5, d1.value());
        assertEquals(8, d1.roll());

        // test with a list
        Integer[] vals2 = {7, 2, 8, 13, 11};
        List<Integer> list = Arrays.asList(vals2);
        Die d2 = new SpecialDie(list);
        assertEquals(5, d2.sides());
        assertEquals(7, d2.value());
        Die.test(4);
        assertEquals(8, d2.roll());
        assertEquals(8, d2.roll());

        // make sure they copied the values
        for (int i = 0; i < list.size(); i++) {
            list.set(i, 0);
        }
        assertEquals(8, d2.value());
        assertEquals(13, d2.roll());
    }

    /**
     * Tests concrete methods of the Die class.
     */
    @Test
    public void testDie() {
        Die a = new RegularDie();
        Die b = new RegularDie();
        Die c = new SpecialDie(new int[] {1, 5, 9});

        // compare initial dice
        assertTrue(a.compareTo(b) == 0);
        assertTrue(b.compareTo(c) == 0);
        assertTrue(a.equals(b));
        assertFalse(b.equals(c));
        assertFalse(c.equals(null));

        // roll the dice
        Die.test(5);
        a.roll();
        b.roll();
        c.roll();

        // compare rolled dice
        assertTrue(a.compareTo(b) > 0);
        assertTrue(b.compareTo(c) < 0);
        assertFalse(a.equals(b));
        Comparable<Die> d = a;
        assertTrue(d.compareTo(c) < 0);

        // test string format
        assertEquals("RegularDie with 6 sides (value: 6)", a.toString());
        assertEquals("RegularDie with 6 sides (value: 5)", b.toString());
        assertEquals("SpecialDie with 3 sides (value: 9)", c.toString());
    }

}
