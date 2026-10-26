import java.util.Scanner;

public class User {

    public static void main(String[] args) {

        // read input from the user

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a rank: ");
        String rankStr = in.nextLine();
        System.out.print("Enter a suit: ");
        String suitStr = in.nextLine();

        // try to construct the card
        try {
            int rankInt = Integer.parseInt(rankStr);
            int suitInt = Integer.parseInt(suitStr);
            card = new Card(rankInt, suitInt);
        } catch (NumberFormatException exc) {
            card = new Card(rankStr, suitStr);
        } catch (IllegalArgumentException exc) {
            System.out.println(exc.getMessage());
            card = null;
        }



        System.out.println("Your card is: " + card);
    }

}
