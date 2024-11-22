package hr.bp.adventofcode.day02;

import java.util.*;

public class InputParser {

    public Map<Integer, List<Map<Color, Integer>>> parse(String input) {
        Map<Integer, List<Map<Color, Integer>>> gameInformationMap = new HashMap<>();
        List<String> inputLines = getInputLines(input);
        for (String inputLine : inputLines) {
            processInputLine(inputLine, gameInformationMap);
        }
        return gameInformationMap;
    }

    private List<String> getInputLines(String input) {
        String[] splitInput = input.split("\n");
        return Arrays.asList(splitInput);
    }

    // inputLine = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    private void processInputLine(String inputLine, Map<Integer, List<Map<Color, Integer>>> gameInformationMap) {
        Integer gameId = getGameId(inputLine);
        List<Map<Color, Integer>> listOfSubsetsRevealed = getListOfSubsetsRevealed(inputLine);
        gameInformationMap.put(gameId, listOfSubsetsRevealed);
    }

    // inputLine = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    private List<Map<Color, Integer>> getListOfSubsetsRevealed(String inputLine) {
        List<Map<Color, Integer>> listOfSubsetsRevealed = new ArrayList<>();
        List<String> inputLineSubsets = getInputLineSubsets(inputLine);
        for (String inputLineSubset : inputLineSubsets) {
            processSubset(inputLineSubset, listOfSubsetsRevealed);
        }
        return listOfSubsetsRevealed;
    }

    // inputLineSubset = "3 blue, 4 red"
    private void processSubset(String inputLineSubset, List<Map<Color, Integer>> listOfSubsetsRevealed) {
        Map<Color, Integer> subsetRevealed = new HashMap<>();
        List<String> cubeNumbers = getCubes(inputLineSubset);
        for (String cubeNumber : cubeNumbers) {                // cubeNumber = "3 blue"
            processCubeNumber(cubeNumber, subsetRevealed);
        }
        listOfSubsetsRevealed.add(subsetRevealed);
    }

    // cubeNumber = "3 blue"
    private void processCubeNumber(String cubeNumber, Map<Color, Integer> subsetRevealed) {
        Color color = getColorEnum(cubeNumber);
        Integer number = getNumber(cubeNumber);
        subsetRevealed.put(color, number);
    }

    // inputLineSubset = "3 blue, 4 red"
    private List<String> getCubes(String inputLineSubset) {
        return Arrays.asList(inputLineSubset.split(", "));
    }

    // inputLine = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    private List<String> getInputLineSubsets(String inputLine) {
        String rightPart = inputLine.split(":")[1].strip();
        return Arrays.asList(rightPart.split(";"));
    }

    // inputLine = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    private Integer getGameId(String inputLine) {
        String leftPart = inputLine.split(":")[0];
        return Integer.parseInt(leftPart.split(" ")[1]);
    }

    // cubeNumber = "3 blue"
    private Color getColorEnum(String cubeNumber) {
        String color = cubeNumber.strip().split(" ")[1];
        return Color.valueOf(color.toUpperCase());
    }

    // cubeNumber = "3 blue"
    private Integer getNumber(String cubeNumber) {
        return Integer.parseInt(cubeNumber.strip().split(" ")[0]);
    }
}
