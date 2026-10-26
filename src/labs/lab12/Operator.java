package labs.lab12;

/**
 * Supported operators for Math Dice.
 *
 * @author CS149 Faculty
 * @version 04/29/2024
 */
public enum Operator {

    PLUS('+'), MINUS('-'), TIMES('*'), DIVIDE('/'), POWER('^');

    private char symbol;

    /**
     * Constructs the operator.
     *
     * @param symbol the symbol
     */
    Operator(char symbol) {
        this.symbol = symbol;
    }

    /**
     * Evaluates the operator.
     *
     * @param x left operand
     * @param y right operand
     * @return x Operator y
     */
    public int evaluate(int x, int y) {
        int result;
        switch (symbol) {
            case '+':
                result = x + y;
                break;
            case '-':
                result = x - y;
                break;
            case '*':
                result = x * y;
                break;
            case '/':
                result = x / y;
                break;
            case '^':
                result = (int) Math.pow(x, y);
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return result;
    }

}
