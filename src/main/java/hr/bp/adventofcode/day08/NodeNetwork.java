package hr.bp.adventofcode.day08;

import org.graalvm.collections.Pair;

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
        parseInput(input);
    }

    private void parseInput(String input) {
        String[] inputParts = input.split("\\n\\n");

        extractDirections(inputParts[0].strip());
        parseNodeMappings(inputParts[1].strip());
    }

    private void parseNodeMappings(String nodeMappingsInput) {
        String[] nodeMappingsInputLines = nodeMappingsInput.split("\\n");

        for (String nodeMappingsInputLine : nodeMappingsInputLines) {
            extractNodeMapping(nodeMappingsInputLine);
        }
    }

    private void extractNodeMapping(String nodeMappingsInputLine) {
        String sourceNode = nodeMappingsInputLine.split("=")[0].strip();

        String rightSide = nodeMappingsInputLine.split("=")[1].strip();

        String leftNode =rightSide.split(",")[0].substring(1,4);
        String rightNode = rightSide.split(",")[1].substring(1,4);

        nodeMappings.put(sourceNode, Pair.create(leftNode, rightNode));
    }

    private void extractDirections(String directionLine) {
        String[] directions = directionLine.split("");

        for (String direction : directions) {
            this.directions.add(Direction.fromSymbol(direction));
        }
    }

    public int stepThroughNetwork() {
        int numberOfSteps = 0;
        int directionIndex = 0;

        String currentNodeLabel = "AAA";
        String endingNodeLabel = "ZZZ";

        while (!currentNodeLabel.equals(endingNodeLabel)) {
            Direction direction = directions.get(directionIndex);
            directionIndex = ++directionIndex % directions.size();

            Pair<String, String> nextNodes = nodeMappings.get(currentNodeLabel);
            if (direction.equals(Direction.RIGHT)) {
                currentNodeLabel = nextNodes.getRight();
            } else {
                currentNodeLabel = nextNodes.getLeft();
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
