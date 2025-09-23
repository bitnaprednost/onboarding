package hr.bp.aoc.day2;

import java.io.IOException;

import hr.bp.aoc.DaySolution;
import hr.bp.aoc.day2.game.GameOutcome;
import hr.bp.aoc.day2.game.GamePoints;
import hr.bp.aoc.day2.game.GameReferee;
import hr.bp.aoc.day2.game.GameShape;
import hr.bp.aoc.day2.reader.InputCharDecoder;

public class Day2 extends DaySolution<Integer, Integer> {
  public Day2() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "strategy-guide.txt";
  }

  @Override
  public Integer getPart1Solution() {
    return getStrategyGuideScore();
  }

  @Override
  public Integer getPart2Solution() {
    return getRightStrategyGuideScore();
  }

  public int getStrategyGuideScore() {
    int score = 0;

    for (String line : getInputLines()) {
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

    for (String line : getInputLines()) {
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
