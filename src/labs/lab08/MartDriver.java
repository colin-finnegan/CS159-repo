package labs.lab08;

import java.util.Random;
import java.util.Scanner;

/**
 * Driver class for the grocery store simulation.
 *
 * @author CS159 Faculty
 * @version 03/25/2024
 */
public class MartDriver {

    /**
     * Run the simulation and display the results.
     *
     * @param args command-line arguments
     */
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        int totalSeconds = 8 * 60 * 60;  // 8 hours
        int numCashiers = 8;
        double customerProbability = .05;
        int maxItems = 100;
        int maxLength = 20;

        // UNCOMMENT TO COMPLETE THE LAST PART OF THE LAB
        System.out.println("What aisle type should be used?");
        System.out.println("  1 - Simple");
        System.out.println("  2 - Limited");
        System.out.println("  3 - Sorted");
        Scanner in = new Scanner(System.in);
        int type = in.nextInt();

        MartSimulation sim = new MartSimulation(totalSeconds,
                customerProbability, maxItems);
        Random gen = sim.getGenerator();
        for (int i = 0; i < numCashiers; i++) {
            if (type == 1) {
                sim.addAisle(new Aisle(gen));
            }   else if (type == 2) {
                sim.addAisle(new LimitedAisle(gen, maxLength));
            }   else {
                sim.addAisle(new SortedAisle(gen));
            }
        }
        sim.runSimulation();
        sim.printResults();
    }

}
