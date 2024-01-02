package hr.bp.aoc.days.rucksackReorganization;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.days.rucksackReorganization.model.Backpack;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static final Logger logger = LoggerFactory.getLogger(DayThree.class);
    static final String BACKPACK_DATA_PATH = "src/main/resources/backpackData.txt";
    List<String> backpackDataList = readBackpackData(BACKPACK_DATA_PATH);
    List<Backpack> backpacksList = new ArrayList<>();

    @Override
    public void executePartOne() {
        sliceAndCreateCompartments(backpackDataList, backpacksList);

        List<Character> duplicatesInBackpack = findDuplicates(backpacksList);
        int sum = calculateSumOfTheDuplicates(duplicatesInBackpack);

        logger.info("rucksackReorganization PART 1: {}", sum);
    }

    @Override
    public void executePartTwo() {
        try {
            String input = Files.readString(Path.of(BACKPACK_DATA_PATH));
            var counter = IntStream.range(0, input.length()).iterator();
            var sum2 = input.lines()
                    .collect(Collectors.groupingBy(c -> counter.nextInt() / 3)).values().stream()
                    .mapToInt(this::commonPriority).sum();
            logger.info("rucksackReorganization PART 2: {}", sum2);
        } catch (IOException e) {
            logger.error("Cannot read String from path");
        }
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Three";
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
            String firstCompartment = backpack.getFirstCompartment();
            String secondCompartment = backpack.getSecondCompartment();

            for (int i = 0; i < firstCompartment.length(); i++) {
                if (firstCompartment.contains(Character.toString(secondCompartment.charAt(i)))) {
                    duplicates.add(secondCompartment.charAt(i));
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
        List<String> tempBackpackDataList = new ArrayList<>();
        try {
            tempBackpackDataList = Files.readAllLines(Paths.get(backpackDataPath));
        } catch (IOException e) {
            logger.error("Cannot read lines from PATH");
        }
        return tempBackpackDataList;
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
