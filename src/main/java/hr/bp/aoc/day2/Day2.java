package hr.bp.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
  private static Path InputPath = Paths.get("src/main/resources/aoc/day2/strategy-guide.txt");
  private List<String> inputLines;
  private Map<GameShape, Integer> shapeScoreMapping = new HashMap<>();
  private Map<String, Integer> gameOutcomeScoreMapping = new HashMap<>();
  private Map<GameShapePair, String> shapePairsGameOutcomeMapping = new HashMap<>();
  private Map<String, GameShape> strategyCharShapeMapping = new HashMap<>();

  public Day2() throws FileNotFoundException, IOException {
    shapeScoreMapping.put(GameShape.ROCK, 1);
    shapeScoreMapping.put(GameShape.PAPER, 2);
    shapeScoreMapping.put(GameShape.SCISSORS, 3);

    gameOutcomeScoreMapping.put("Win", 6);
    gameOutcomeScoreMapping.put("Draw", 3);
    gameOutcomeScoreMapping.put("Lose", 0);

    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.SCISSORS), "Win");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.ROCK), "Win");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.PAPER), "Win");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.ROCK), "Draw");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.PAPER), "Draw");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.SCISSORS), "Draw");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.PAPER), "Lose");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.SCISSORS), "Lose");
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.ROCK), "Lose");

    strategyCharShapeMapping.put("A", GameShape.ROCK);
    strategyCharShapeMapping.put("B", GameShape.PAPER);
    strategyCharShapeMapping.put("C", GameShape.SCISSORS);
    strategyCharShapeMapping.put("X", GameShape.ROCK);
    strategyCharShapeMapping.put("Y", GameShape.PAPER);
    strategyCharShapeMapping.put("Z", GameShape.SCISSORS);

    BufferedReader reader = new BufferedReader(
        new FileReader(new File(InputPath.toString())));
    inputLines = reader.lines().toList();

    reader.close();
  }

  public int getStrategyGuideScore() {
    int result = 0;

    for (String line : inputLines) {
      String opponentChar = line.split(" ")[0];
      String playerChar = line.split(" ")[1];
      GameShape opponentShape = strategyCharShapeMapping.get(opponentChar);
      GameShape playerShape = strategyCharShapeMapping.get(playerChar);
      result += shapeScoreMapping.get(playerShape);

      GameShapePair shapePair = new GameShapePair(playerShape, opponentShape);
      String gameOutcome = shapePairsGameOutcomeMapping.get(shapePair);
      result += gameOutcomeScoreMapping.get(gameOutcome);
    }

    return result;
  }
}
