package hr.bp.aoc.day3;

import java.util.ArrayList;
import java.util.List;

public class PrioritiesUtil {

    static List<Character> itemsInBothCompartments(List<String> lines) {
        List<Character> inBothCompartment = new ArrayList<>();
        for (String line : lines) {
            boolean duplicate = false;
            for (int i = 0; i <= (line.length() / 2 - 1); i++) {
                for (int j = line.length() / 2; j < line.length(); j++) {
                    if (line.charAt(i) == line.charAt(j)) {
                        inBothCompartment.add(line.charAt(i));
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate) {
                    break;
                }
            }
        }
        return inBothCompartment;
    }

    static int sumOfPrioritiesFirstPart(List<String> lines) {
        List<Character> inBothCompartment = itemsInBothCompartments(lines);
        int sumOfPriorities = 0;

        for (Character character : inBothCompartment) {
            if (character >= 'a' && character <= 'z') {
                sumOfPriorities += (int) character - (int) ('a') + 1;
            } else if (character >= 'A' && character <= 'Z') {
                sumOfPriorities += (int) character - (int) ('A') + 1 + 26;
            }
        }
        return sumOfPriorities;
    }


    static List<Character> itemCarriedByThreeElves(String[] rucksack) {
        List<Character> inThreeRucksack = new ArrayList<>();
        boolean inThree = false;
        for (int i = 0; i <= rucksack.length - 1 - 2; i += 3) {
            String set1 = rucksack[i];
            String set2 = rucksack[i + 1];
            String set3 = rucksack[i + 2];

            for (int j = 0; j < set1.length(); j++) {
                for (int k = 0; k < set2.length(); k++) {
                    for (int l = 0; l < set3.length(); l++) {
                        if ((set1.charAt(j) == set2.charAt(k)) && (set2.charAt(k) == set3.charAt(l))) {
                            inThreeRucksack.add(set1.charAt(j));
                            inThree = true;
                            break;
                        }
                    }
                    if (inThree) {
                        break;
                    }
                }
                if (inThree) {
                    set1 = "";
                    set2 = "";
                    set3 = "";
                    inThree = false;
                }
            }

        }
        return inThreeRucksack;
    }

    static int sumOfPrioritiesSecondPart(String[] rucksack) {
        List<Character> inThreeRucksack = itemCarriedByThreeElves(rucksack);
        int sumBadges = 0;
        for (Character character : inThreeRucksack) {
            if (character >= 'a' && character <= 'z') {
                sumBadges += (int) character - (int) ('a') + 1;
            } else if (character >= 'A' && character <= 'Z') {
                sumBadges += (int) character - (int) ('A') + 1 + 26;
            }

        }
        return sumBadges;
    }
}
