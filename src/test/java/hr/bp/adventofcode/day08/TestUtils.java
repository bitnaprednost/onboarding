package hr.bp.adventofcode.day08;

import hr.bp.adventofcode.Pair;

import java.util.List;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getFirstInput() {
        return """
            RL
            
            AAA = (BBB, CCC)
            BBB = (DDD, EEE)
            CCC = (ZZZ, GGG)
            DDD = (DDD, DDD)
            EEE = (EEE, EEE)
            GGG = (GGG, GGG)
            ZZZ = (ZZZ, ZZZ)""";
    }

    public static List<Direction> getDirectionsFirstInput() {
        return List.of(Direction.RIGHT, Direction.LEFT);
    }

    public static Map<String, Pair<String, String>>  getNodeMappingsFirstInput() {
        return Map.of(
                "AAA", new Pair<>("BBB", "CCC"),
                "BBB", new Pair<>("DDD", "EEE"),
                "CCC", new Pair<>("ZZZ", "GGG"),
                "DDD", new Pair<>("DDD", "DDD"),
                "EEE", new Pair<>("EEE", "EEE"),
                "GGG", new Pair<>("GGG", "GGG"),
                "ZZZ", new Pair<>("ZZZ", "ZZZ")
        );
    }

    public static String getSecondInput() {
        return """
            LLR
            
            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)""";
    }

    public static String getFourthInput() {
        return """
            LR
            
            11A = (11B, XXX)
            11B = (XXX, 11Z)
            11Z = (11B, XXX)
            22A = (22B, XXX)
            22B = (22C, 22C)
            22C = (22Z, 22Z)
            22Z = (22B, 22B)
            XXX = (XXX, XXX)""";
    }
}
