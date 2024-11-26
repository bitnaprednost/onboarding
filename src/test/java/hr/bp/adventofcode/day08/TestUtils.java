package hr.bp.adventofcode.day08;

import org.graalvm.collections.Pair;

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
        return List.of(Direction.R, Direction.L);
    }

    public static Map<Node, Pair<Node, Node>>  getNodeMappingsFirstInput() {
        return Map.of(
                new Node("AAA"), Pair.create(new Node("BBB"), new Node("CCC")),
                new Node("BBB"), Pair.create(new Node("DDD"), new Node("EEE")),
                new Node("CCC"), Pair.create(new Node("ZZZ"), new Node("GGG")),
                new Node("DDD"), Pair.create(new Node("DDD"), new Node("DDD")),
                new Node("EEE"), Pair.create(new Node("EEE"), new Node("EEE")),
                new Node("GGG"), Pair.create(new Node("GGG"), new Node("GGG")),
                new Node("ZZZ"), Pair.create(new Node("ZZZ"), new Node("ZZZ"))
        );
    }

    public static String getSecondInput() {
        return """
            LLR
            
            AAA = (BBB, BBB)
            BBB = (AAA, ZZZ)
            ZZZ = (ZZZ, ZZZ)""";
    }

}
