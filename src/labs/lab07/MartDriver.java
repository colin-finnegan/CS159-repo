package labs.lab07;

/**
 * Driver class for the grocery store simulation.
 *
 * @author CS159 Instructors
 * @version 03/18/2024
 */
public class MartDriver {

    /**
     * Run the simulation and display the results.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        int totalSeconds = 8 * 60 * 60; // 8 hours.
        int numCashiers = 6;
        double customerProbability = .05;
        int maxItems = 100;
        int maxLength = 10;

        MartSimulation sim = new MartSimulation(totalSeconds, numCashiers,
                customerProbability, maxItems, maxLength);

        sim.runSimulation();
        sim.printResults();

        printLabReport();
    }

    /**
     * Prints a report of simulations from the lab assignment.
     */
    public static void printLabReport() {
        int leftWhenLength1 = 0; // TODO
        int leftWhenLength5 = 0; // TODO
        int leftWhenLength20 = 0; // TODO

        System.out.println("Customers that departed when line had length:");
        System.out.printf("   1? %3d\n", leftWhenLength1);
        System.out.printf("   5? %3d\n", leftWhenLength5);
        System.out.printf("  20? %3d\n", leftWhenLength20);
    }
}
