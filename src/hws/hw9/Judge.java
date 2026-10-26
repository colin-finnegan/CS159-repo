package hws.hw9;

/**
 * The Judge interface.
 *
 * @author Colin Finnegan
 * @version 4/21/2023
 */
public interface Judge {

    /**
     * Result method, to be implemented by HighWins and LowWins.
     *
     *
     * @param matchup Matchup object
     * @param who Participant object
     * @return 1 if win, 0 if tie, -1 if loss.
     */
    int result(Matchup matchup, Participant who);
}
