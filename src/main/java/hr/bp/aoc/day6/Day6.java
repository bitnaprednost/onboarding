package hr.bp.aoc.day6;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hr.bp.aoc.DaySolution;

public class Day6 extends DaySolution<Integer, Integer> {

  public Day6() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "subroutine.txt";
  }

  @Override
  public Integer getPart1Solution() {
    String buffer = getInputLines().get(0);
    int NEEDED_CONSECUTIVE_CHARACTERS = 4;
    Map<Character, Integer> lastViewedChars = new HashMap<>();

    for (int i = 0; i < NEEDED_CONSECUTIVE_CHARACTERS; i++) {
      Character currChar = buffer.charAt(i);
      lastViewedChars.put(currChar, lastViewedChars.getOrDefault(currChar, 0) + 1);
    }

    if (lastViewedChars.size() == NEEDED_CONSECUTIVE_CHARACTERS)
      return NEEDED_CONSECUTIVE_CHARACTERS;

    for (int j = NEEDED_CONSECUTIVE_CHARACTERS; j < buffer.length(); j++) {
      Character charToRemove = buffer.charAt(j - NEEDED_CONSECUTIVE_CHARACTERS);
      lastViewedChars.put(charToRemove, lastViewedChars.get(charToRemove) - 1);
      if (lastViewedChars.get(charToRemove) == 0)
        lastViewedChars.remove(charToRemove);

      Character charToAdd = buffer.charAt(j);
      lastViewedChars.put(charToAdd, lastViewedChars.getOrDefault(charToAdd, 0) + 1);
      if (lastViewedChars.size() == NEEDED_CONSECUTIVE_CHARACTERS)
        return j + 1;
    }

    return -1;
  }

  @Override
  public Integer getPart2Solution() {
    return 0;
  }
}
