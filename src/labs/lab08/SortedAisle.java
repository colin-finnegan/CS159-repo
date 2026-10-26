package labs.lab08;

import java.util.Collections;
import java.util.Random;

/**
 * Creates a Sorted Aisle.
 *
 * @author Colin Finnegan
 * @version 3/28/2024
*/
public class SortedAisle extends Aisle {


    public SortedAisle(Random generator) {
        super(generator);
    }

    @Override
    public void addCustomer(Customer customer) {
        super.addCustomer(customer);
        Collections.sort(line);
    }
}
