package hr.bp.adventofcode.day08;

import org.graalvm.collections.Pair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hr.bp.adventofcode.day08.TestUtils.getDirectionsFirstInput;
import static hr.bp.adventofcode.day08.TestUtils.getFirstInput;
import static hr.bp.adventofcode.day08.TestUtils.getNodeMappingsFirstInput;
import static hr.bp.adventofcode.day08.TestUtils.getSecondInput;

/**
 * @author Ivan Tomičić
 */
public class NodeNetworkTest {

    @Test
    public void testParsingOfNetwork_givenValidInputOne_correctlyParsesNetwork() {
        String input = getFirstInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        List<Direction> expectedDirections = getDirectionsFirstInput();
        Map<Node, Pair<Node, Node>> expectedNodeMappings = getNodeMappingsFirstInput();

        List<Direction> actualDirections = nodeNetwork.getDirections();
        Map<Node, Pair<Node, Node>> actualNodeMappings = nodeNetwork.getNodeMappings();

        Assertions.assertEquals(expectedDirections, actualDirections);
        Assertions.assertEquals(expectedNodeMappings, actualNodeMappings);
    }

    @Test
    public void testFindingOfZZZ_givenValidInputOne_returnsCorrectNumberOfSteps() {
        String input = getFirstInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        int expectedNumberOfSteps = 2;

        int actualNumberOfSteps = nodeNetwork.stepThroughNetwork();

        Assertions.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

    @Test
    public void testFindingOfZZZ_givenValidInputTwo_returnsCorrectNumberOfSteps() {
        String input = getSecondInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        int expectedNumberOfSteps = 6;

        int actualNumberOfSteps = nodeNetwork.stepThroughNetwork();

        Assertions.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

}
