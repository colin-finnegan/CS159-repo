package hws.hw9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {

    public static void main(String[] args) throws Exception {
        SingleEliminationTournament lacrosse;
        RoundRobinTournament robin;
        int standings;
        Analyst a = new Analyst();
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        robin = RoundRobinTournament
                .read("src/hws/hw9/data/quidditch_d1_2016.rrt");
        lacrosse = SingleEliminationTournament
                .read("src/hws/hw9/data/lacrosse-women_d3_2017.set");

        standings = Analyst.totalPointDifferential(lacrosse);

        System.out.println(standings);

    }
}
