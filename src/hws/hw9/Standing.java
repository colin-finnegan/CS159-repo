package hws.hw9;

/**
 * The Standing Class.
 *
 * @author Colin Finnegan
 * @version 4/22/2024
 */
public class Standing {

    private int wins;
    private int losses;
    private int ties;

    /**
     * The default Standing constructor.
     */
    public Standing() {
        this.wins = 0;
        this.losses = 0;
        this.ties = 0;
    }

    /**
     * Overloaded Standing Constructor.
     *
     * @param wins amount of wins
     * @param losses amount of losses
     * @param ties amount of ties
     */
    public Standing(int wins, int losses, int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }

    public int getWins() {
        return wins;
    }

    /**
     * Increases Losses by 1.
     */
    public void increaseLosses() {
        this.losses = getLosses() + 1;
    }

    /**
     * Increases Wins by 1.
     */
    public void increaseWins() {
        this.wins = getWins() + 1;
    }

    /**
     * Increases Ties by 1.
     */
    public void increaseTies() {
        this.ties = getTies() + 1;
    }

    @Override
    public String toString() {
        return String.format("%3d - %3d - %3d", wins, losses, ties);
    }


}
