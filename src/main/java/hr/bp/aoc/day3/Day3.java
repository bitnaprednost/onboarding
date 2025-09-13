package hr.bp.aoc.day3;

import java.io.FileNotFoundException;
import java.io.IOException;

import hr.bp.aoc.DaySolution;

public class Day3 extends DaySolution {
  public Day3() throws FileNotFoundException, IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "rucksacks.txt";
  }

  @Override
  public int getPart1Solution() {
    return getBothCompartmentsPrioritySum();
  }

  @Override
  public int getPart2Solution() {
    return getBadgesPrioritySum();
  }

  public int getBothCompartmentsPrioritySum() {
    int prioritySum = 0;

    for (String rucksack : getInputLines()) {
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

    for (int g = 0; g < getInputLines().size(); g += 3) {
      String firstRucksack = getInputLines().get(g);
      String secondRucksack = getInputLines().get(g + 1);
      String thirdRucksack = getInputLines().get(g + 2);

      prioritySum += PriorityCalculator.getPriority(
          CharacterDistinguisher.getDuplicateCharacters(
              firstRucksack.toCharArray(),
              secondRucksack.toCharArray(),
              thirdRucksack.toCharArray()).toArray(new Character[1])[0]);
    }

    return prioritySum;
  }
}
