package hws.hw9;

/**
 * LowWin class.  Awards win if participant score is less than the other.
 *
 * @author Colin Finnegan
 * @version 4/21/2024
 */
public class LowWins implements Judge {

    @Override
    public int result(Matchup matchup, Participant who) {
        if (matchup.getScore(who) < matchup.getScore(who.other())) {
            return 1;
        } else if (matchup.getScore(who) > matchup.getScore(who.other())) {
            return -1;
        } else {
            return 0;
        }
    }


}
