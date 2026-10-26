import java.util.Scanner;

public class ScannerDemo {

    public static void main(String[] args) {

        System.out.println("==== Example 1 ====");
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
        }

        System.out.println("==== Example 2 ====");
        String text = "1 fish 2 fish red fish blue fish";
        Scanner sc = new Scanner(text);
        System.out.println(sc.nextInt());
        System.out.println(sc.next());
        System.out.println(sc.nextInt());
        System.out.println(sc.next());

    }

}
