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
  private Map<GameShapePair, GameOutcome> shapePairsGameOutcomeMapping = new HashMap<>();
  private Map<String, GameShape> strategyCharShapeMapping = new HashMap<>();

  public Day2() throws FileNotFoundException, IOException {
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.SCISSORS), GameOutcome.WIN);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.ROCK), GameOutcome.WIN);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.PAPER), GameOutcome.WIN);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.ROCK), GameOutcome.DRAW);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.PAPER), GameOutcome.DRAW);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.SCISSORS), GameOutcome.DRAW);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.ROCK, GameShape.PAPER), GameOutcome.LOSE);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.PAPER, GameShape.SCISSORS), GameOutcome.LOSE);
    shapePairsGameOutcomeMapping.put(new GameShapePair(GameShape.SCISSORS, GameShape.ROCK), GameOutcome.LOSE);

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
      result += GamePoints.getShapePoints(playerShape);

      GameShapePair shapePair = new GameShapePair(playerShape, opponentShape);
      GameOutcome gameOutcome = shapePairsGameOutcomeMapping.get(shapePair);
      result += GamePoints.getGameOutcomePoints(gameOutcome);
    }

    return result;
  }
}
