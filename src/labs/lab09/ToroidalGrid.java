package labs.lab09;

public class ToroidalGrid extends GridCanvas {

    public ToroidalGrid() {
        super(10, 2, 20);
        turnOn(1, 2);
        turnOn(2, 3);
        turnOn(3, 1);
        turnOn(3, 2);
        turnOn(3, 3);
    }

    public int countOn() {
        int on = 0;
        for (int x = 0; x < this.numRows(); x++) {
            for (int y = 0; y < this.numCols(); y++) {
                if (test(x, y) == 1) {
                    on++;
                }
            }
        }
        return on;
    }

    @Override
    public int test(int r, int c) {
        int rr = r;
        int cc = c;
        if (r > this.numRows()) {
            rr = 0;
        } else if (r < this.numRows()) {
            rr = numRows() - 1;
        }
        if (c > this.numCols()) {
            cc = 0;
        } else if (c < this.numCols()) {
            cc = numCols() - 1;
        }
        return super.test(rr, cc);
    }
}
