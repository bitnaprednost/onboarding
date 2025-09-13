package hr.bp.aoc.day3;

import java.util.HashSet;
import java.util.Set;

public class CharacterDistinguisher {
  public static Set<Character> getDuplicateCharacters(char[]... charLists) {
    Set<Character> duplicates = getAllCharSet();

    for (char[] charList : charLists) {
      Set<Character> previousCommonChars = duplicates;
      duplicates = new HashSet<>();

      for (char c : charList) {
        if (previousCommonChars.contains(c))
          duplicates.add(c);
      }
    }

    return duplicates;
  }

  private static Set<Character> getAllCharSet() {
    Set<Character> allCharSet = new HashSet<>();

    for (char lowercase = 'a'; lowercase <= 'z'; lowercase++) {
      allCharSet.add(lowercase);
    }

    for (char lowercase = 'A'; lowercase <= 'Z'; lowercase++) {
      allCharSet.add(lowercase);
    }

    return allCharSet;
  }
}
