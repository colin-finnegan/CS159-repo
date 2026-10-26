package hws.hw9;

import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Utility class for performing various operations on Tournament objects.
 *
 * @author Colin Finnegan
 * @version 4/22/2024
 */
public class Analyst {

    // ------------------------------------------------------------------------
    // Method #1 (10 pts)
    // ------------------------------------------------------------------------

    /**
     * Calculate the total point differential for a particular team, ending with
     * a particular Matchup.
     *
     * @param t The Tournament of interest
     * @param endingWith The Matchup to work backward from
     * @param team The team of interest
     * @return The total point differential
     */
    public static int totalPointDifferential(Tournament t, Matchup endingWith,
            String team) {
        int pointDiff = 0;
        Iterator<Matchup> m = t.iterator(endingWith, team);
        while (m.hasNext()) {
            Matchup mm = m.next();
            pointDiff += Math.abs(mm.getScore(Participant.HOME)
                    - mm.getScore(Participant.VISITOR));
        }

        return pointDiff;
    }

    // ------------------------------------------------------------------------
    // Method #2 (15 pts)
    // ------------------------------------------------------------------------

    /**
     * Build the Schedule for a RoundRobinTournament.
     *
     * @param t The RoundRobinTournament
     * @return The schedules for each Participant (ordered by round)
     */
    public static Map<String, List<String>> buildSchedule(
            RoundRobinTournament t) {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Matchup[] matchup = t.getFinalMatchups();
        for (Matchup m : matchup) {
            map.put(m.getName(Participant.HOME),
                    opponents(m.getName(Participant.HOME), t, m));
            map.put(m.getName(Participant.VISITOR),
                    opponents(m.getName(Participant.VISITOR), t, m));
        }

        return map;
    }

    /**
     * Helper method to sort all opponents that a team plays.
     *
     * @param team team to get opponents of
     * @param t Tournament every team is in.
     * @param m Matchup's of each team
     * @return List of Strings, which is each opponent the team faces.
     */
    public static List<String> opponents(String team, RoundRobinTournament t,
            Matchup m) {
        List<String> lls = new ArrayList<>();
        Iterator<Matchup> teams = t.iterator(m, team);
        while (teams.hasNext()) {
            Matchup match = teams.next();
            if (match.getName(Participant.HOME).equals(team)) {
                lls.add(match.getName(Participant.VISITOR));
            } else if (match.getName(Participant.VISITOR).equals(team)) {
                lls.add(match.getName(Participant.HOME));
            }
        }
        return lls;
    }

    // ------------------------------------------------------------------------
    // Method #3 (20 pts)
    // ------------------------------------------------------------------------

    /**
     * Calculate the total point differential for all Matchup objects in a
     * SingleEliminationTournament.
     *
     * @param t The SingleEliminationTournament
     * @return The total point differential
     */
    public static int totalPointDifferential(SingleEliminationTournament t) {
        return totalPD(t, t.getFinalMatchup());
    }

    /**
     * Helper method to calculate point differential.
     *
     * @param t tournament to look in
     * @param m matchup to start at
     * @return point differential for that matchup.
     */
    private static int totalPD(SingleEliminationTournament t, Matchup m) {
        if (m == null) {
            return 0;
        }
        int tpd = 0;
        tpd += Math.abs(
                m.getScore(Participant.HOME) - m.getScore(Participant.VISITOR));
        return tpd + (totalPD(t, t.previous(m, m.getName(Participant.HOME)))
                + totalPD(t, t.previous(m, m.getName(Participant.VISITOR))));
    }

    // ------------------------------------------------------------------------
    // Method #4 (20 pts)
    // ------------------------------------------------------------------------

    /**
     * Build the Schedule for a SingleEliminationTournament.
     *
     * @param t The SingleEliminationTournament
     * @return The schedules for each Participant (ordered by round)
     */
    public static Map<String, List<String>> buildSchedule(
            SingleEliminationTournament t) {
        Map<String, List<String>> map = new HashMap<>();
        buildSchedule(t, t.getFinalMatchup(), map);
        return map;
    }

    /**
     * Helper method to build schedule.
     *
     * @param t tournament to look in.
     * @param m Final matchup to work backward from
     * @param map map to add team and list of opponents to
     */
    private static void buildSchedule(SingleEliminationTournament t, Matchup m,
            Map<String, List<String>> map) {
        if (m == null) {
            return;
        }

        List<String> homeList = new ArrayList<>();
        List<String> visList = new ArrayList<>();
        String home = m.getName(Participant.HOME);
        String visitor = m.getName(Participant.VISITOR);

        if (m.getName(Participant.HOME).equals(home)) {
            homeList.add(0, visitor);
            visList.add(0, home);
        } else {
            homeList.add(0, home);
            visList.add(0, visitor);
        }

        if (map.containsKey(home)) {
            List<String> hList = map.get(home);
            for (String s : homeList) {
                hList.add(0, s);
            }
        } else {
            map.put(home, homeList);
        }

        if (map.containsKey(visitor)) {
            List<String> vList = map.get(visitor);
            for (String s : visList) {
                vList.add(0, s);
            }
        } else {
            map.put(visitor, visList);
        }
        buildSchedule(t, t.previous(m, m.getName(Participant.HOME)), map);
        buildSchedule(t, t.previous(m, m.getName(Participant.VISITOR)), map);

    }

    // ------------------------------------------------------------------------
    // Method #5 (20 pts)
    // ------------------------------------------------------------------------

    /**
     * Calculate all of the standings for a given Tournament.
     *
     * @param t The Tournament of interest
     * @param j The Judge to use to determine outcomes
     * @return The Standing objects for every participant
     */
    public static Map<String, Standing> calculateStandings(Tournament t,
            Judge j) {
        // make sure to keep track of the matchups youve seen so you dont add
        // them twice
        HashSet hs = new HashSet<>();
        standings(t, j, t.getFinalMatchups()[0]);
        return null;
    }

    /**
     * Helper method that creates standings for given team.
     *
     * @param t type of tournament being played
     * @param j type of judge, determines high or low score
     * @param m map where team is key and their standing is the value
     */
    private static void standings(Tournament t, Judge j,
            Matchup m) {
        Map<String, Standing> mm = new HashMap<String, Standing>();
        if (t instanceof RoundRobinTournament) {
            if (j instanceof HighWins) {
                for (Matchup game : t.getFinalMatchups()) {
                    Standing hStand = new Standing();
                    Standing vStand = new Standing();
                    mm.put(game.getName(Participant.HOME), hStand);
                    mm.put(game.getName(Participant.VISITOR), vStand);
                    if (game.getScore(Participant.HOME) > game.
                            getScore(Participant.VISITOR)) {
                        hStand.increaseWins();
                        vStand.increaseLosses();
                    } else if (game.getScore(Participant.HOME) == game.
                            getScore(Participant.VISITOR)) {
                        hStand.increaseTies();
                        vStand.increaseTies();
                    } else {
                        hStand.increaseLosses();
                        vStand.increaseWins();
                    }
                }
            } else {
                for (Matchup game : t.getFinalMatchups()) {
                    Standing hStand = new Standing();
                    Standing vStand = new Standing();
                    mm.put(game.getName(Participant.HOME), hStand);
                    mm.put(game.getName(Participant.VISITOR), vStand);
                    if (game.getScore(Participant.HOME) < game.
                            getScore(Participant.VISITOR)) {
                        hStand.increaseLosses();
                        vStand.increaseWins();
                    } else if (game.getScore(Participant.HOME) == game.
                            getScore(Participant.VISITOR)) {
                        hStand.increaseTies();
                        vStand.increaseTies();
                    } else {
                        hStand.increaseWins();
                        vStand.increaseLosses();
                    }
                }
            }
        } else {
            if (j instanceof HighWins) {
                Standing hStand = new Standing();
                Standing vStand = new Standing();
                mm.put(t.getFinalMatchups()[0].getName(Participant.HOME),
                        hStand);
                mm.put(t.getFinalMatchups()[0].getName(Participant.VISITOR),
                        vStand);
                if (t.getFinalMatchups()[0].
                        getScore(Participant.HOME) > t.getFinalMatchups()[0].
                                getScore(Participant.VISITOR)) {
                    hStand.increaseWins();
                    vStand.increaseLosses();
                } else if (t.getFinalMatchups()[0].
                        getScore(Participant.HOME) == t.getFinalMatchups()[0].
                                getScore(Participant.VISITOR)) {
                    hStand.increaseTies();
                    vStand.increaseTies();
                } else {
                    hStand.increaseLosses();
                    vStand.increaseWins();
                }
            } else {
                Standing hStand = new Standing();
                Standing vStand = new Standing();
                mm.put(t.getFinalMatchups()[0].getName(Participant.HOME),
                        hStand);
                mm.put(t.getFinalMatchups()[0].getName(Participant.VISITOR),
                        vStand);
                if (t.getFinalMatchups()[0].
                        getScore(Participant.HOME) < t.getFinalMatchups()[0].
                                getScore(Participant.VISITOR)) {
                    hStand.increaseLosses();
                    vStand.increaseWins();
                } else if (t.getFinalMatchups()[0].
                        getScore(Participant.HOME) == t.getFinalMatchups()[0].
                                getScore(Participant.VISITOR)) {
                    hStand.increaseTies();
                    vStand.increaseTies();
                } else {
                    hStand.increaseWins();
                    vStand.increaseLosses();
                }
            }
        }
        standings(t, j, t.getFinalMatchups()[0]);
    }

}
