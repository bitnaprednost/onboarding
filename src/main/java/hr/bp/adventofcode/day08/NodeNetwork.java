package hr.bp.adventofcode.day08;

import hr.bp.adventofcode.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author Ivan Tomičić
 */
public class NodeNetwork {

    private final List<Direction> directions = new ArrayList<>();
    private final Map<String, Pair<String, String>> nodeMappings = new HashMap<>();

    public NodeNetwork(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        initializeNetwork(input);
    }

    private void initializeNetwork(String input) {
        String[] inputParts = input.split("\\n\\n");

        initializeDirections(inputParts[0].strip());
        initializeNodeMappings(inputParts[1].strip());
    }

    private void initializeNodeMappings(String nodeMappingsInput) {
        String[] nodeMappingsInputLines = nodeMappingsInput.split("\\n");

        for (String nodeMappingsInputLine : nodeMappingsInputLines) {
            addNodeMapping(nodeMappingsInputLine);
        }
    }

    private void addNodeMapping(String nodeMappingsInputLine) {
        String sourceNode = nodeMappingsInputLine.split("=")[0].strip();

        String rightSide = nodeMappingsInputLine.split("=")[1].strip();

        String leftNode =rightSide.split(",")[0].substring(1,4);
        String rightNode = rightSide.split(",")[1].substring(1,4);

        nodeMappings.put(sourceNode, new Pair<>(leftNode, rightNode));
    }

    private void initializeDirections(String directionLine) {
        String[] directions = directionLine.split("");

        for (String direction : directions) {
            this.directions.add(Direction.fromSymbol(direction));
        }
    }

    public int calculateStepsToEnd() {
        int numberOfSteps = 0;
        int directionIndex = 0;

        String currentNodeLabel = "AAA";
        String endingNodeLabel = "ZZZ";

        while (!currentNodeLabel.equals(endingNodeLabel)) {
            Direction direction = directions.get(directionIndex);
            directionIndex = ++directionIndex % directions.size();

            Pair<String, String> nextNodes = nodeMappings.get(currentNodeLabel);

            if (direction.equals(Direction.RIGHT)) {
                currentNodeLabel = nextNodes.right();
            } else {
                currentNodeLabel = nextNodes.left();
            }
            numberOfSteps++;
        }

        return numberOfSteps;
    }


    public List<Direction> getDirections() {
        return this.directions;
    }

    public Map<String, Pair<String, String>> getNodeMappings() {
        return this.nodeMappings;
    }


    public long calculateParallelStepsToEnd() {
        List<Long> numberOfSteps = new ArrayList<>();

        List<String> allNodeLabelsEndingInA = getAllNodeLabelsEndingInA();

        for (String nodeLabel : allNodeLabelsEndingInA) {
            long period = calculatePeriod(nodeLabel);
            numberOfSteps.add(period);
        }

        return leastCommonMultipleOfList(numberOfSteps);
    }

    private long leastCommonMultipleOfList(List<Long> listOfNumbers) {
        long lcm = listOfNumbers.get(0);

        for (int i = 1; i < listOfNumbers.size(); i++) {
            lcm = lcm(lcm, listOfNumbers.get(i));

            if (lcm == 0) {
                break;
            }
        }

        return lcm;
    }

    private static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


    private long calculatePeriod(String nodeLabel) {
        int directionIndex = 0;
        long counter = 0;

        while (!nodeLabel.endsWith("Z")) {
            Direction direction = directions.get(directionIndex);

            directionIndex = ++directionIndex % directions.size();
            counter++;

            if (direction.equals(Direction.RIGHT)) {
                nodeLabel = nodeMappings.get(nodeLabel).right();
            } else {
                nodeLabel = nodeMappings.get(nodeLabel).left();
            }
        }
        return counter;
    }

    private List<String> getAllNodeLabelsEndingInA() {
        return new ArrayList<>(
                nodeMappings.keySet()
                .stream()
                .filter(node -> node.endsWith("A"))
                .toList());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NodeNetwork that)) return false;
        return Objects.equals(getDirections(), that.getDirections()) && Objects.equals(getNodeMappings(), that.getNodeMappings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirections(), getNodeMappings());
    }
}
