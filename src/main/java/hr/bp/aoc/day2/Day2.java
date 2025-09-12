package hr.bp.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import hr.bp.aoc.day2.game.GameOutcome;
import hr.bp.aoc.day2.game.GamePoints;
import hr.bp.aoc.day2.game.GameReferee;
import hr.bp.aoc.day2.game.GameShape;
import hr.bp.aoc.day2.reader.InputCharDecoder;

public class Day2 {
  private static Path InputPath = Paths.get("src/main/resources/aoc/day2/strategy-guide.txt");
  private List<String> inputLines;

  public Day2() throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader(new File(InputPath.toString())));
    inputLines = reader.lines().toList();

    reader.close();
  }

  public int getStrategyGuideScore() {
    int score = 0;

    for (String line : inputLines) {
      char opponentChar = line.split(" ")[0].charAt(0);
      char playerChar = line.split(" ")[1].charAt(0);

      GameShape opponentGameShape = InputCharDecoder.getGameShape(opponentChar);
      GameShape playerGameShape = InputCharDecoder.getGameShape(playerChar);
      score += GamePoints.getShapePoints(playerGameShape);

      GameOutcome gameOutcome = GameReferee.getGameOutcome(playerGameShape, opponentGameShape);
      score += GamePoints.getGameOutcomePoints(gameOutcome);
    }

    return score;
  }

  public int getRightStrategyGuideScore() {
    int score = 0;

    for (String line : inputLines) {
      char opponentChar = line.split(" ")[0].charAt(0);
      char outcomeChar = line.split(" ")[1].charAt(0);

      GameShape opponentGameShape = InputCharDecoder.getGameShape(opponentChar);
      GameOutcome desiredGameOutcome = InputCharDecoder.getGameOutcome(outcomeChar);

      score += GamePoints.getGameOutcomePoints(desiredGameOutcome);

      GameShape playerGameShape = GameReferee.getShapeForDesiredOutcome(
          desiredGameOutcome, opponentGameShape);
      score += GamePoints.getShapePoints(playerGameShape);
    }

    return score;
  }
}
