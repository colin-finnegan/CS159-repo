package labs.lab10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WordCloudDriver {

    public static void main(String[] args) {
        String filepath = "src/labs/lab10/data/hard.txt";

        WordCloud wc = new WordCloud();
        try {
            int count = wc.addAll(filepath);
            System.out.println("Added " + count + " words from: " + filepath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filepath);
            return;
        }

        System.out.println("Total terms: " + wc.termCount());
        System.out.println("Total words: " + wc.totalWordCount());
        System.out.println("Frequency of 'the': " + wc.getFrequency("the"));
        System.out.println();

        // ****** Test removing (UNCOMMENT TO RUN) ******

        // int removed = wc.remove("the");
        // System.out.println("Removed " + removed + " instances of 'the'");
        // removed = wc.removeAllLessThan(2);
        // System.out.println("Removed " + removed + " terms with frequency less than 2");
        // System.out.println();

        // ****** Generate HTML file (UNCOMMENT TO RUN) ******

        // String html = wc.generateHTML();
        // String htmlPath = filepath.replace(".txt", ".html");
        // try {
        //     PrintWriter out = new PrintWriter(htmlPath);
        //     out.print(html);
        //     out.close();
        //     System.out.println("HTML file written to: " + htmlPath);
        // } catch (FileNotFoundException e) {
        //     System.out.println("Cannot write to file: " + htmlPath);
        //     return;
        // }
    }
}
