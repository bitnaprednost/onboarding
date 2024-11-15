package adventofcode.day02;

import java.util.*;

public class InputParser {

    public Map<Integer, List<Map<ColorEnum, Integer>>> parse(String input) {
        Map<Integer, List<Map<ColorEnum, Integer>>> gameInformationMap = new HashMap<>();
        List<String> inputLines = getInputLines(input);
        for (String inputLine : inputLines) {           // inputLine = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
            processInputLine(inputLine, gameInformationMap);
        }
        return gameInformationMap;
    }

    private void processInputLine(String inputLine, Map<Integer, List<Map<ColorEnum, Integer>>> gameInformationMap) {
        Integer gameId = getGameId(inputLine);
        List<Map<ColorEnum, Integer>> listOfSubsetsRevealed = getListOfSubsetsRevealed(inputLine);
        gameInformationMap.put(gameId, listOfSubsetsRevealed);
    }

    private List<Map<ColorEnum, Integer>> getListOfSubsetsRevealed(String inputLine) {
        List<Map<ColorEnum, Integer>> listOfSubsetsRevealed = new ArrayList<>();
        List<String> inputLineSubsets = getInputLineSubsets(inputLine);
        for (String inputLineSubset : inputLineSubsets) {                // inputLineSubset = "3 blue, 4 red"
            processSubset(inputLineSubset, listOfSubsetsRevealed);
        }
        return listOfSubsetsRevealed;
    }

    private void processSubset(String inputLineSubset, List<Map<ColorEnum, Integer>> listOfSubsetsRevealed) {
        Map<ColorEnum, Integer> subsetRevealed = new HashMap<>();
        List<String> cubeNumbers = getCubes(inputLineSubset);
        for (String cubeNumber : cubeNumbers) {                // cubeNumber = "3 blue"
            processCubeNumber(cubeNumber, subsetRevealed);
        }
        listOfSubsetsRevealed.add(subsetRevealed);
    }

    private void processCubeNumber(String cubeNumber, Map<ColorEnum, Integer> subsetRevealed) {
        ColorEnum color = getColorEnum(cubeNumber);
        Integer number = getNumber(cubeNumber);
        subsetRevealed.put(color, number);
    }

    private List<String> getInputLines(String input) {
        String[] splitInput = input.split("\n");
        return Arrays.asList(splitInput);
    }

    private List<String> getCubes(String inputLineSubset) {
        return Arrays.asList(inputLineSubset.split(", "));
    }

    private List<String> getInputLineSubsets(String inputLine) {
        String rightPart = inputLine.split(":")[1].strip();
        return Arrays.asList(rightPart.split(";"));
    }

    private Integer getNumber(String cubeNumber) {
        return Integer.parseInt(cubeNumber.strip().split(" ")[0]);
    }

    private Integer getGameId(String inputLine) {
        String leftPart = inputLine.split(":")[0];
        return Integer.parseInt(leftPart.split(" ")[1]);
    }

    private ColorEnum getColorEnum(String cubeNumber) {
        String color = cubeNumber.strip().split(" ")[1];
        return ColorEnum.valueOf(color.toUpperCase());
    }
}
