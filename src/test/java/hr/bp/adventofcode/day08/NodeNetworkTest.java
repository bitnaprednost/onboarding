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
import static hr.bp.adventofcode.day08.TestUtils.getThirdInput;
import static hr.bp.adventofcode.day08.TestUtils.getFourthInput;

/**
 * @author Ivan Tomičić
 */
public class NodeNetworkTest {

    @Test
    public void testParsingOfNetwork_givenValidInputOne_correctlyParsesNetwork() {
        String input = getFirstInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        List<Direction> expectedDirections = getDirectionsFirstInput();
        Map<String, Pair<String, String>> expectedNodeMappings = getNodeMappingsFirstInput();

        List<Direction> actualDirections = nodeNetwork.getDirections();
        Map<String, Pair<String, String>> actualNodeMappings = nodeNetwork.getNodeMappings();

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

    @Test
    public void testFindingOfZZZ_givenValidInputThree_returnsCorrectNumberOfSteps() {
        String input = getThirdInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        int expectedNumberOfSteps = 12169;

        int actualNumberOfSteps = nodeNetwork.stepThroughNetwork();

        Assertions.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

    @Test
    public void testFindingOfAllNodesEndingInZ_givenValidInputFour_returnsCorrectNumberOfSteps() {
        String input = getFourthInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        long expectedNumberOfSteps = 6;

        long actualNumberOfSteps = nodeNetwork.stepThroughNetworkInParallel();

        Assertions.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

    @Test
    public void testFindingOfAllNodesEndingInZ_givenValidInputThree_returnsCorrectNumberOfSteps() {
        String input = getThirdInput();
        NodeNetwork nodeNetwork = new NodeNetwork(input);

        long expectedNumberOfSteps = 12030780859469L;

        long actualNumberOfSteps = nodeNetwork.stepThroughNetworkInParallel();

        Assertions.assertEquals(expectedNumberOfSteps, actualNumberOfSteps);
    }

}
