package hws.hw9;


/**
 * HighWin class.  Awards win if participant score is greater than the other.
 *
 * @author Colin Finnegan
 * @version 4/21/2024
 */
public class HighWins implements Judge {

    @Override
    public int result(Matchup matchup, Participant who) {
        if (matchup.getScore(who) > matchup.getScore(who.other())) {
            return 1;
        } else if (matchup.getScore(who) < matchup.getScore(who.other())) {
            return -1;
        } else {
            return 0;
        }
    }

}
