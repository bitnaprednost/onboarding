package hr.bp.aoc.day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import hr.bp.aoc.day2.reader.CharShapeDecoder;

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
    int result = 0;

    for (String line : inputLines) {
      char opponentChar = line.split(" ")[0].charAt(0);
      char playerChar = line.split(" ")[1].charAt(0);
      GameShape opponentShape = CharShapeDecoder.getGameShape(opponentChar);
      GameShape playerShape = CharShapeDecoder.getGameShape(playerChar);
      result += GamePoints.getShapePoints(playerShape);

      GameOutcome gameOutcome = GameReferee.getGameOutcome(playerShape, opponentShape);
      result += GamePoints.getGameOutcomePoints(gameOutcome);
    }

    return result;
  }
}
