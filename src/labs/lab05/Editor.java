package labs.lab05;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A simple editor application designed to exercise the Document class.
 *
 * @author YOUR NAME
 * @version THE DATE
 */
public class Editor {

    private Document document;
    private Scanner scanner;

    /**
     * Initialize the document and scanner.
     */
    public Editor() {
        document = new Document();
        scanner = new Scanner(System.in);
    }

    /**
     * The run method handles the main user interaction loop.
     *
     * @throws FileNotFoundException TODO NEED TO REMOVE
     */
    public void run() throws FileNotFoundException {
        System.out.print("\nNanovimacs, ");
        System.out.println("the worlds greatest command-line text editor!\n");
        printPrompt();
        while (scanner.hasNextLine()) {
            String cmd = scanner.nextLine();
            switch (cmd.trim().toLowerCase()) {
                case "a":
                    readText();
                    break;
                case "d":
                    deleteLine();
                    break;
                case "l":
                    System.out.println("\nThe longest line is:");
                    System.out.println("\n" + document.longestLine());
                    break;
                case "c":
                    System.out.println("\nThe character count is:");
                    System.out.println("\n" + document.characterCount());
                    break;
                case "p":
                    System.out.println("\n" + document);
                    break;
                case "s":
                    saveFile();
                    break;
                case "r":
                    loadFile();
                    break;
                default:
                    System.out.println("Unrecognized command.");
            }
            printPrompt();
        }
        System.out.println();
    }

    /**
     * Read lines of text until the user enters a empty line.
     */
    private void readText() {
        System.out.println("Enter text. Enter a blank line to finish.");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                break;
            }
            document.appendLine(line);
        }
    }

    /**
     * Deletes a line of text provided by the user.
     */
    private void deleteLine() {
        System.out.println("Which line number should be deleted?");
        if (scanner.hasNextInt()) {
            int lineNumber = scanner.nextInt();
            document.deleteLine(lineNumber);
        } else {
            System.out.println("Bad line number.");
        }
        scanner.nextLine();
    }

    /**
     * Loads a new document from a user-provided file name.
     *
     * @throws FileNotFoundException TODO NEED TO REMOVE
     */
    private void loadFile() {
        System.out.print("Enter a file name: ");
        String name = scanner.nextLine();
        try {
            document = new Document(name);
        } catch (FileNotFoundException e) {
            System.out.println("\n ***Error opening the file: " + name + "***");
            // catch if file is not found
        }
    }

    /**
     * Saves the document using the user-provided file name.
     *
     * @throws FileNotFoundException TODO NEED TO REMOVE
     */
    private void saveFile() {
        System.out.print("Enter a file name: ");
        String name = scanner.nextLine();
        try {
            document.save(name);
        } catch (FileNotFoundException e) {
            System.out.println("\n ***Error saving the file: " + name + "***");
        }
    }

    /**
     * Print the instruction prompt.
     */
    public static void printPrompt() {
        System.out.println();
        System.out.println("\"a\" to enter text");
        System.out.println("\"d\" to delete a line");
        System.out.println("\"l\" to print the longest line");
        System.out.println("\"c\" to print the character count");
        System.out.println("\"p\" to display the entire document");
        System.out.println("\"r\" to load");
        System.out.println("\"s\" to save");
        System.out.println("CTRL-D to exit");
        System.out.print("Command: ");
    }

    /**
     * Start the application.
     *
     * @param args not used
     * @throws FileNotFoundException TODO NEED TO REMOVE
     */
    public static void main(String[] args) throws FileNotFoundException {
        Editor editor = new Editor();
        editor.run();
    }

}
