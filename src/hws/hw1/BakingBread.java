package hws.hw1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * CS 159 Exercise 1.3 Baking Bread.
 *
 * @author Colin Finnegan
 * @version 1/22/2024
 */
public class BakingBread {

    /**
     * Figure out ingredients for baking (possibly many) loaves of bread.
     * https://www.kingarthurflour.com/recipes/basic-sourdough-bread-recipe
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Map<String, String> result = new HashMap<>();
        result.put("skate", "board");
        result.put("drive", "car");
        result.put("program", "computer");
        result.put("play", "computer");
        mapMystery1(result);

    }
    public static void mapMystery1(Map<String, String> map) {
        Map<String, String> result = new TreeMap<>();
        for (String key : map.keySet()) {
            if (key.compareTo(map.get(key)) < 0) {
                result.put(key, map.get(key));
                System.out.print(key + " ");
                System.out.println(key.compareTo(map.get(key)));
            } else {
                result.put(map.get(key), key);
                System.out.print(key + " ");
                System.out.println(key.compareTo(map.get(key)));
            }
        }
        System.out.println(map);
        System.out.println(result);
    }

}
