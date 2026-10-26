package labs.lab12;

/**
 * The Fast, Fun Dice Game of Mental Math. Based on
 * http://www.thinkfun.com/products/math-dice/.
 *
 * @author Colin Finnegan
 * @version 04/30/2024
 */
public class MathDice {

    private Die[] target;
    private Die[] scoring;
    private Operator[] result;

    /**
     * Construct a default game of 2 target dice and 3 scoring dice.
     */
    public MathDice() {
        this(2, 3);
    }

    /**
     * Constructs a custom game with the given number of dice.
     *
     * @param nTarget number of target dice
     * @param nScoring number of scoring dice
     */
    public MathDice(int nTarget, int nScoring) {
        this.target = new Die[nTarget];
        for (int i = 0; i < nTarget; i++) {
            target[i] = new RegularDie(12);
        }

        for (int i = 0; i < nScoring; i++) {
            scoring[i] = new RegularDie();
        }
        this.scoring = new Die[nScoring];
        this.result = null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("Target dice:\n");
        for (Die die : target) {
            str.append("  ");
            str.append(die.value());
        }
        str.append('\n');

        str.append("Scoring dice:\n");
        for (Die die : scoring) {
            str.append("  ");
            str.append(die.value());
        }
        str.append('\n');

        if (result != null) {
            str.append("Result:\n");
            for (Operator oper : result) {
                str.append("  ");
                str.append(oper);
            }
            str.append('\n');
        }

        return str.toString();
    }

    /**
     * Play one round of the game: roll the dice, find a solution.
     */
    public void play() {
        int product = 1;
        for (Die t : target) {
            product *= t.roll();
        }

        for (Die s : scoring) {
            s.roll();
        }
        result = new Operator[scoring.length - 1];
        if (!solve(product, 0)) {
            result = null;  // invalid result
        }
    }

    /**
     * Recursively tries all possible solutions using the available operators.
     * The method assigns this.result at the given index and then calls itself
     * with index + 1. When the index reaches the end of the array, the entire
     * this.result has been initialized. If this.result has a correct solution,
     * the method returns true, and the recursion ends. If not, then the next
     * operators are assigned, until every possible solution has been tested.
     *
     * @param product the target number (i.e., product of target dice)
     * @param index the current index of the result array to assign
     * @return true if result contains a solution, false otherwise
     */
    private boolean solve(int product, int index) {
        if (index == result.length) {
            return false;
        }

        this.result[index] = result[index];
            solve(product, index + 1);

        boolean b = false;

        for (Operator o : this.result) {
            System.out.print(o);
            return false;
        }
        return b;
    }

}
