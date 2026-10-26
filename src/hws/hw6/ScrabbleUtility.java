package hws.hw6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import hws.hw4.Letter;
import hws.hw5.Board;
import hws.hw5.EnhancedHand;


/**
 * Utility class for saving and loading Scrabble games.
 *
 * @author Colin Finnegan
 * @version 3/1/2024
 */
public class ScrabbleUtility {


    /**
     * Saves the Scrabble game by writing to a file.
     *
     * @param fileName name of file to write to and save
     * @param board Board object to play on
     * @param hand EnhancedHand object to play with
     */
    public void saveScrabble(String fileName, Board board, EnhancedHand hand)
        throws FileNotFoundException {
        PrintWriter in = new PrintWriter(fileName);
        in.println("board:");
        in.println(board.toString());
        in.println("hand:");
        in.print(hand.toString());
        in.close();
    }

    /**
     * Read file written by saveScrabble, and sets up Board
     * and EnhancedHand object attributes.
     *
     * @param fileName name of file to read
     * @param board Board object to play on
     * @param hand EnhancedHand object to play with
     */
    public void readScrabble(String fileName, Board board, EnhancedHand hand)
        throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        Letter[] lo = new Letter[3];
        String bd = in.nextLine();
        in.useDelimiter(",");
        String sg = in.next();
        int gum = 0;
        Letter l = new Letter(sg.charAt(0), sg.charAt(2));
        lo[gum] = l;
        int[] z = {0, 0, 0, 0};
        Board bob = new Board(lo, z, "words.txt");
        in.close();
    }
}
