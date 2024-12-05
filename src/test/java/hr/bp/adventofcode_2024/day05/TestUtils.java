package hr.bp.adventofcode_2024.day05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

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
