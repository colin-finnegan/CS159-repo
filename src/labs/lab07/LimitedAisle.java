package labs.lab07;

import java.util.Random;

public class LimitedAisle extends Aisle {

    private int maxLength;
    private int leftStore;

    public LimitedAisle(Random generator, int maxLength) {
        super(generator);
        this.maxLength = maxLength;
        this.leftStore = 0;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getLeftStore() {
        return leftStore;
    }

    public void addCustomer(Customer customer) {
        if (lineLength() < maxLength) {
            super.addCustomer(customer);
        } else {
            leftStore++;
        }
    }
}
