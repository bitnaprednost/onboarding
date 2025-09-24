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
    return findFirstStartOfTheMessage();
  }

  private int findFirstStartOfThePacket() {
    int CONSECUTIVE_CHARACTERS_FOR_THE_PACKET = 4;
    return findFirstStartOfTheMarker(CONSECUTIVE_CHARACTERS_FOR_THE_PACKET);
  }

  private int findFirstStartOfTheMessage() {
    int CONSECUTIVE_CHARACTERS_FOR_THE_MESSAGE = 14;
    return findFirstStartOfTheMarker(CONSECUTIVE_CHARACTERS_FOR_THE_MESSAGE);
  }

  private int findFirstStartOfTheMarker(int neededConsecutiveCharacters) {
    String buffer = getInputLines().get(0);
    Map<Character, Integer> currPreMarkerChars = new HashMap<>();

    // Prerequisiste (makes main algorithm easier to write)
    for (int i = 0; i < neededConsecutiveCharacters; i++) {
      Character currChar = buffer.charAt(i);
      currPreMarkerChars.put(currChar, currPreMarkerChars.getOrDefault(currChar, 0) + 1);
    }

    // Earliest edge case
    if (currPreMarkerChars.size() == neededConsecutiveCharacters)
      return neededConsecutiveCharacters;

    for (int j = neededConsecutiveCharacters; j < buffer.length(); j++) {
      Character charToRemove = buffer.charAt(j - neededConsecutiveCharacters);
      currPreMarkerChars.put(charToRemove, currPreMarkerChars.get(charToRemove) - 1);
      if (currPreMarkerChars.get(charToRemove) == 0)
        currPreMarkerChars.remove(charToRemove);

      Character charToAdd = buffer.charAt(j);
      currPreMarkerChars.put(charToAdd, currPreMarkerChars.getOrDefault(charToAdd, 0) + 1);
      if (currPreMarkerChars.size() == neededConsecutiveCharacters)
        return j + 1;
    }

    return -1;
  }
}
