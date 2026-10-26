package labs.lab12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for Part 2 of the exam.
 *
 * @author CS149 Faculty
 * @version 04/29/2024
 */
public class Part2Test {

    /**
     * Tests the constructors.
     */
    @Test
    public void testInit() {
        MathDice game1 = new MathDice();
        String expect1 = "Target dice:\n  1  1\n"
                + "Scoring dice:\n  1  1  1\n";
        assertEquals(expect1, game1.toString());

        MathDice game2 = new MathDice(1, 2);
        String expect2 = "Target dice:\n  1\n" + "Scoring dice:\n  1  1\n";
        assertEquals(expect2, game2.toString());
    }

    /**
     * Tests games without solutions.
     */
    @Test
    public void testPlay1() {
        MathDice game = new MathDice();

        Die.test(0);
        game.play();
        String expect0 = "Target dice:\n  1  5\n"
                + "Scoring dice:\n  2  6  6\n";
        assertEquals(expect0, game.toString());

        Die.test(1);
        game.play();
        String expect1 = "Target dice:\n  10  5\n"
                + "Scoring dice:\n  2  4  3\n";
        assertEquals(expect1, game.toString());
    }

    /**
     * Tests games with solutions.
     */
    @Test
    public void testPlay2() {
        MathDice game = new MathDice();

        Die.test(2);
        game.play();
        String expect2 = "Target dice:\n  5  1\n" + "Scoring dice:\n  3  2  4\n"
                + "Result:\n  MINUS  PLUS\n";
        assertEquals(expect2, game.toString());

        Die.test(8);
        game.play();
        String expect8 = "Target dice:\n  5  5\n" + "Scoring dice:\n  5  2  1\n"
                + "Result:\n  POWER  TIMES\n";
        assertEquals(expect8, game.toString());
    }

    /**
     * Tests games with more dice.
     */
    @Test
    public void testPlay3() {
        MathDice game = new MathDice(3, 4);

        Die.test(10);
        game.play();
        String expect10 = "Target dice:\n  10  1  10\n"
                + "Scoring dice:\n  1  5  5  2\n"
                + "Result:\n  TIMES  PLUS  POWER\n";
        assertEquals(expect10, game.toString());

        Die.test(17);
        game.play();
        String expect17 = "Target dice:\n" + "  1  1  11\n"
                + "Scoring dice:\n  3  5  4  5\n"
                + "Result:\n  MINUS  POWER  MINUS\n";
        assertEquals(expect17, game.toString());
    }

}
