package hr.bp.aoc.day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
      int halfRucksackSize = rucksackSize / 2;
      String firstCompartment = rucksack.substring(0, halfRucksackSize);
      String secondCompartment = rucksack.substring(halfRucksackSize, rucksackSize);

      Set<Character> itemsInFirstCompartment = new HashSet<>();

      for (int i = 0; i < halfRucksackSize; i++) {
        itemsInFirstCompartment.add(firstCompartment.charAt(i));
      }

      for (int j = 0; j < halfRucksackSize; j++) {
        char secondCompartmentChar = secondCompartment.charAt(j);

        if (itemsInFirstCompartment.contains(secondCompartmentChar)) {
          prioritySum += PriorityCalculator.getPriority(secondCompartmentChar);

          itemsInFirstCompartment.remove(secondCompartmentChar);
        }
      }
    }

    return prioritySum;
  }
}
