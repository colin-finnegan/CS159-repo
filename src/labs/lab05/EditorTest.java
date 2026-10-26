package labs.lab05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Minimal tests of the file I/O functionality of the Editor class.
 *
 * @author CS159 Faculty
 * @version 02/28/2024
 */
public class EditorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayInputStream inputStream;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() throws Exception {
        originalIn = System.in;
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        File n = new File("tmp2.txt");
        n.delete();
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.setIn(originalIn);
        System.setOut(originalOut);
        File n = new File("tmp2.txt");
        n.delete();
    }

    @Test
    public void testSaveWorks() throws Exception {
        // "Hijack" standard in so that it is read from a string.
        String input = "a\n" + "One fish\ntwo fish\nred fish\n\n" + "s\n"
                + "tmp2.txt\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Tell the editor to create and save the file.
        Editor ed = new Editor();
        ed.run();

        // Check to see that the contents of the file are correct.
        Path path = FileSystems.getDefault().getPath("tmp2.txt");
        String content = Files.readString(path, StandardCharsets.US_ASCII);
        assertEquals("One fish\ntwo fish\nred fish\n", content);
    }

    @Test
    public void testSaveHandlesExceptions() throws Exception {
        String input = "a\n" + "One fish\ntwo fish\nred fish\n\n" + "s\n"
                + "\n"; // Empty file names are not allowed!
        inputStream = new ByteArrayInputStream(input.getBytes());

        System.setIn(inputStream);
        Editor ed = new Editor();
        ed.run();
    }

    @Test
    public void testLoadWorks() throws Exception {
        // Save some content to a file
        PrintWriter pw = new PrintWriter(new File("tmp2.txt"));
        pw.print("supercalafragilisticexpialidocious\nhello!\n");
        pw.close();

        // Load and print the file using the editor
        String input = "r\n" + "tmp2.txt\n" + "p\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Editor ed = new Editor();
        ed.run();

        // Make sure that the content was displayed correctly by the editor
        Path path = FileSystems.getDefault().getPath("tmp2.txt");
        String content = Files.readString(path, StandardCharsets.US_ASCII);
        assertTrue(content.contains(
                "supercalafragilisticexpialidocious\nhello!\n"));
    }

    @Test
    public void testLoadHandlesExceptions() throws Exception {
        String input = "r\n" + "NONEXISTENTFILE.txt\n" + "p\n";
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Editor ed = new Editor();
        ed.run();
    }

}
