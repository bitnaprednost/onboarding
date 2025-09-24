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
    return findFirstStartOfThePacket();
  }

  @Override
  public Integer getPart2Solution() {
    return 0;
  }

  private int findFirstStartOfThePacket() {
    String buffer = getInputLines().get(0);
    int NEEDED_CONSECUTIVE_CHARACTERS = 4;
    Map<Character, Integer> currPreMarkerChars = new HashMap<>();

    // Prerequisiste (makes main algorithm easier to write)
    for (int i = 0; i < NEEDED_CONSECUTIVE_CHARACTERS; i++) {
      Character currChar = buffer.charAt(i);
      currPreMarkerChars.put(currChar, currPreMarkerChars.getOrDefault(currChar, 0) + 1);
    }

    // Earliest edge case
    if (currPreMarkerChars.size() == NEEDED_CONSECUTIVE_CHARACTERS)
      return NEEDED_CONSECUTIVE_CHARACTERS;

    for (int j = NEEDED_CONSECUTIVE_CHARACTERS; j < buffer.length(); j++) {
      Character charToRemove = buffer.charAt(j - NEEDED_CONSECUTIVE_CHARACTERS);
      currPreMarkerChars.put(charToRemove, currPreMarkerChars.get(charToRemove) - 1);
      if (currPreMarkerChars.get(charToRemove) == 0)
        currPreMarkerChars.remove(charToRemove);

      Character charToAdd = buffer.charAt(j);
      currPreMarkerChars.put(charToAdd, currPreMarkerChars.getOrDefault(charToAdd, 0) + 1);
      if (currPreMarkerChars.size() == NEEDED_CONSECUTIVE_CHARACTERS)
        return j + 1;
    }

    return -1;
  }
}
