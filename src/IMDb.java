import java.io.File;
import java.util.Scanner;

public class IMDb {

    public static void main(String[] args) {
        File file = new File("src/title2020.tsv");
        Scanner in = null;
        try {
            in = new Scanner(file);
            in.useDelimiter("\t");
        }   catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int count = 0;
        while (count < 1) {
            String tid = in.next();
            String type = in.next();
            String title = in.next();
            if (tid.equals("6723592")) {
                System.out.println(tid + " is a " + type + " named " + title);
                count++;
            }
            in.nextLine();
        }
        in.close();
    }

}
