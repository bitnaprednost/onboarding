package hr.bp.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Day2 {
  private static Path InputPath = Paths.get("src/main/resources/aoc/day2/strategy-guide.txt");
  private Stream<String> inputLines;

  public Day2() throws FileNotFoundException, IOException {
    Map<String, Integer> shapeScoreMapping = new HashMap<>();
    shapeScoreMapping.put("Rock", 1);
    shapeScoreMapping.put("Paper", 2);
    shapeScoreMapping.put("Scissors", 3);

    Map<String, Integer> gameOutcomeScoreMapping = new HashMap<>();
    gameOutcomeScoreMapping.put("Win", 6);
    gameOutcomeScoreMapping.put("Draw", 3);
    gameOutcomeScoreMapping.put("Lose", 0);

    class Pair {
      String firstShape;
      String secondShape;

      public Pair(String firstShape, String secondShape) {
        this.firstShape = firstShape;
        this.secondShape = secondShape;
      }

      @Override
      public int hashCode() {
        return firstShape.hashCode() + secondShape.hashCode();
      }
    }

    Map<Pair, String> shapePairsGameOutcomeMapping = new HashMap<>();
    shapePairsGameOutcomeMapping.put(new Pair("Rock", "Rock"), "Draw");
    shapePairsGameOutcomeMapping.put(new Pair("Rock", "Scissors"), "Win");
    shapePairsGameOutcomeMapping.put(new Pair("Rock", "Paper"), "Lose");
    shapePairsGameOutcomeMapping.put(new Pair("Paper", "Paper"), "Draw");
    shapePairsGameOutcomeMapping.put(new Pair("Paper", "Rock"), "Win");
    shapePairsGameOutcomeMapping.put(new Pair("Paper", "Scissors"), "Lose");
    shapePairsGameOutcomeMapping.put(new Pair("Scissors", "Scissors"), "Draw");
    shapePairsGameOutcomeMapping.put(new Pair("Scissors", "Paper"), "Win");
    shapePairsGameOutcomeMapping.put(new Pair("Scissors", "Rock"), "Lose");

    Map<String, String> strategyCharShapeMapping = new HashMap<>();
    strategyCharShapeMapping.put("A", "Rock");
    strategyCharShapeMapping.put("B", "Paper");
    strategyCharShapeMapping.put("C", "Scissors");
    strategyCharShapeMapping.put("X", "Rock");
    strategyCharShapeMapping.put("Y", "Paper");
    strategyCharShapeMapping.put("Z", "Scissors");

    BufferedReader reader = new BufferedReader(
        new FileReader(new File(InputPath.toString())));
    Stream<String> inputLines = reader.lines();

    reader.close();
  }
}
