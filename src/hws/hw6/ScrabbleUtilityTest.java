package hws.hw6;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileWriter;

import org.junit.jupiter.api.Test;

import hws.hw5.Board;
import hws.hw5.EnhancedHand;
import hws.hw4.Letter;



/**
 * Unit test for ScrabbleUtility.
 * @author Colin Finnegan
 * @version 3/4/2024
 */

public class ScrabbleUtilityTest {

    @Test
    public void testSave() throws FileNotFoundException {
        ScrabbleUtility su = new ScrabbleUtility();
        int[] zero = {0, 0};
        Letter[] lt = new Letter[3];
        Letter L = new Letter('c', 4);
        Letter Ll = new Letter('d', 3);
        lt[0] = L;
        lt[1] = Ll;
        File file = new File("p.txt");
        Board b = new Board(lt, zero, "words.txt");
        EnhancedHand eh = new EnhancedHand(3);
        Letter T = new Letter('t', 1);
        Letter Tt = new Letter('z', 5);
        eh.insert(T, 0);
        eh.insert(Tt, 1);
        su.saveScrabble("p.txt", b, eh);
        String stuff = "board:";
        String c = "c:4, d:3, -, ";
        Scanner sc = new Scanner(file);
        assertEquals(stuff, sc.nextLine());
        sc.useDelimiter(", ");
        assertEquals("c:4", sc.next());
        assertEquals("d:3", sc.next());
        assertEquals("-", sc.next());
        Board bb;
        EnhancedHand ee;
        PrintWriter jonez = new PrintWriter("pyy.txt");
        jonez.print("board:\nc:4, d:3, s:1\nhand:\ne:4, t:4");
        jonez.close();
        su.readScrabble("pyy.txt", b, eh);
        assertEquals(L, b.getLetter(0));
        sc.close();
    }

}
