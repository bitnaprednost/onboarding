package hr.bp.aoc.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day3 {
  private static Path InputPath = Paths.get("src/main/resources/aoc/day3/rucksacks.txt");
  private List<String> inputLines;

  public Day3() throws FileNotFoundException, IOException {
    BufferedReader reader = new BufferedReader(
        new FileReader(new File(InputPath.toString())));
    inputLines = reader.lines().toList();

    reader.close();
  }

  public int getBothCompartmentsPrioritySum() {
    int prioritySum = 0;

    for (String rucksack : inputLines) {
      int rucksackSize = rucksack.length();
      int compartmentSize = rucksackSize / 2;
      String firstCompartment = rucksack.substring(0, compartmentSize);
      String secondCompartment = rucksack.substring(compartmentSize, rucksackSize);

      for (char duplicate : CharacterDistinguisher.getDuplicateCharacters(firstCompartment.toCharArray(),
          secondCompartment.toCharArray())) {
        prioritySum += PriorityCalculator.getPriority(duplicate);
      }
    }

    return prioritySum;
  }

  public int getBadgesPrioritySum() {
    int prioritySum = 0;

    for (int g = 0; g < inputLines.size(); g += 3) {
      String firstRucksack = inputLines.get(g);
      String secondRucksack = inputLines.get(g + 1);
      String thirdRucksack = inputLines.get(g + 2);

      prioritySum += PriorityCalculator.getPriority(
          CharacterDistinguisher.getDuplicateCharacters(
              firstRucksack.toCharArray(),
              secondRucksack.toCharArray(),
              thirdRucksack.toCharArray()).toArray(new Character[1])[0]);
    }

    return prioritySum;
  }
}
