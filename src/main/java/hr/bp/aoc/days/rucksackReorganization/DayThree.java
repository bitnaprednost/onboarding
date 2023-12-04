package hr.bp.aoc.days.rucksackReorganization;

import hr.bp.aoc.days.rucksackReorganization.model.Backpack;
import hr.bp.aoc.model.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Luka Ljubić
 */
public class DayThree implements Day {

    String backpackDataPath = "src/main/resources/backpackData.txt";
    List<String> backpackDataList = readBackpackData(backpackDataPath);
    List<Backpack> backpacksList = new ArrayList<>();

    @Override
    public void executePartOne() {
        sliceAndCreateCompartments(backpackDataList, backpacksList);

        List<Character> duplicatesInBackpack = findDuplicates(backpacksList);
        int sum = calculateSumOfTheDuplicates(duplicatesInBackpack);

        System.out.println(sum);
    }

    @Override
    public void executePartTwo() {
        try {
            String input = Files.readString(Path.of("src/main/resources/backpackData.txt"));
            var counter = IntStream.range(0, input.length()).iterator();
            var sum2 = input.lines()
                    .collect(Collectors.groupingBy(c -> counter.nextInt() / 3)).values().stream()
                    .mapToInt(l -> commonPriority(l)).sum();
            System.out.printf("part 2: %d\n", sum2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private int calculateSumOfTheDuplicates(List<Character> duplicatesInBackpack) {
        int sum = 0;
        for (Character duplicate : duplicatesInBackpack) {
            if (Character.isUpperCase(duplicate)) {
                sum += ((int) duplicate - 38);
            } else {
                sum += ((int) duplicate - 96);
            }
        }
        return sum;
    }

    private ArrayList<Character> findDuplicates(List<Backpack> backpacksList) {
        ArrayList<Character> duplicates = new ArrayList<>();
        for (Backpack backpack : backpacksList) {
            String firstCompartmant = backpack.getFirstCompartment();
            String secondCompartmant = backpack.getSecondCompartment();

            for (int i = 0; i < firstCompartmant.length(); i++) {
                if (firstCompartmant.contains(Character.toString(secondCompartmant.charAt(i)))) {
                    duplicates.add(secondCompartmant.charAt(i));
                    break;
                }
            }
        }
        return duplicates;
    }

    private void sliceAndCreateCompartments(List<String> backpackDataList, List<Backpack> backpacksList) {
        for (String bacpackData : backpackDataList) {

            char[] bacpackDataInChar = bacpackData.toCharArray();
            int index = bacpackData.length() / 2;

            String firstCompartment = new String(bacpackDataInChar, 0, index);
            String secondCompartment = new String(bacpackDataInChar, index, bacpackData.length() - index);

            backpacksList.add(new Backpack(firstCompartment, secondCompartment));

        }
    }

    private List<String> readBackpackData(String backpackDataPath) {
        List<String> backpackDataList = new ArrayList<>();
        try {
            backpackDataList = Files.readAllLines(Paths.get(backpackDataPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return backpackDataList;
    }

    int commonPriority(List<String> strings) {
        // common character in list of strings
        var c = strings.stream().reduce((s1, s2) -> commonChars(s1, s2)).get().charAt(0);
        return c < 'a' ? c - 'A' + 27 : c - 'a' + 1; // convert to priority
    }

    String commonChars(String a, String b) {
        return a.chars().filter(i1 -> b.chars().anyMatch(i2 -> i1 == i2)).distinct()
                .mapToObj(c -> Character.toString(c)).collect(Collectors.joining());
    }

}
