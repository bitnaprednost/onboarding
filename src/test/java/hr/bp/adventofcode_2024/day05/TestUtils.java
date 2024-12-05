package hr.bp.adventofcode_2024.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getFirstInput() {
        return """
                47|53
                97|13
                97|61
                97|47
                75|29
                61|13
                75|53
                29|13
                97|29
                53|29
                61|53
                97|53
                61|29
                47|13
                75|47
                97|75
                47|61
                75|61
                47|29
                75|13
                53|13
                
                75,47,61,53,29
                97,61,53,29,13
                75,29,13
                75,97,47,61,53
                61,13,29
                97,13,75,29,47""";
    }

    public static HashMap<Integer, List<Integer>> getPageOrderingRules() {
        HashMap<Integer, List<Integer>> pageOrderingRules = new HashMap<>();

        pageOrderingRules.computeIfAbsent(47, k -> new ArrayList<>()).add(53);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(13);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(61);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(47);
        pageOrderingRules.computeIfAbsent(75, k -> new ArrayList<>()).add(29);
        pageOrderingRules.computeIfAbsent(61, k -> new ArrayList<>()).add(13);
        pageOrderingRules.computeIfAbsent(75, k -> new ArrayList<>()).add(53);
        pageOrderingRules.computeIfAbsent(29, k -> new ArrayList<>()).add(13);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(29);
        pageOrderingRules.computeIfAbsent(53, k -> new ArrayList<>()).add(29);
        pageOrderingRules.computeIfAbsent(61, k -> new ArrayList<>()).add(53);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(53);
        pageOrderingRules.computeIfAbsent(61, k -> new ArrayList<>()).add(29);
        pageOrderingRules.computeIfAbsent(47, k -> new ArrayList<>()).add(13);
        pageOrderingRules.computeIfAbsent(75, k -> new ArrayList<>()).add(47);
        pageOrderingRules.computeIfAbsent(97, k -> new ArrayList<>()).add(75);
        pageOrderingRules.computeIfAbsent(47, k -> new ArrayList<>()).add(61);
        pageOrderingRules.computeIfAbsent(75, k -> new ArrayList<>()).add(61);
        pageOrderingRules.computeIfAbsent(47, k -> new ArrayList<>()).add(29);
        pageOrderingRules.computeIfAbsent(75, k -> new ArrayList<>()).add(13);
        pageOrderingRules.computeIfAbsent(53, k -> new ArrayList<>()).add(13);

        return pageOrderingRules;
    }
}
