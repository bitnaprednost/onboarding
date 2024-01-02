package hr.bp.aoc.days.calorieCounting;

import hr.bp.aoc.model.Day;
import hr.bp.aoc.days.calorieCounting.model.Elf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Luka Ljubić
 */
public class DayOne implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DayOne.class);

    static final String CALORIE_DATA_PATH = "src/main/resources/callorieData.txt";
    final List<String> calorieData = new ArrayList<>(readCalorieData(CALORIE_DATA_PATH));
    List<Elf> elvesList = new ArrayList<>();

    @Override
    public void executePartOne() {
        if (!elvesList.isEmpty()) {
            elvesList.clear();
        }
        calculateAndPushDataIntoList(elvesList, calorieData);
        Elf elfWithTheMostCallories;
        elfWithTheMostCallories = getElfWithMostCallories(elvesList);

        logger.info("CalorieCounting PART 1: {}", elfWithTheMostCallories);
    }

    @Override
    public void executePartTwo() {
        if (!elvesList.isEmpty()) {
            elvesList.clear();
        }
        calculateAndPushDataIntoList(elvesList, calorieData);
        Collections.sort(elvesList);

        int firstThreeSum = calculateSum(elvesList, 3);

        logger.info("CalorieCounting PART 2: {}", firstThreeSum);
    }

    @Override
    public String getDayOrderNumber() {
        return "Day One";
    }


    private int calculateSum(List<Elf> elvesList, int numberOfElves) {
        int sum = 0;
        for (int i = elvesList.size() - 1; i > elvesList.size() - (numberOfElves + 1); i--) {
            sum += elvesList.get(i).getCallorieCount();
        }
        return sum;
    }

    private Elf getElfWithMostCallories(List<Elf> elvesList) {
        Elf elfWithMost = elvesList.get(0);

        for (Elf elf : elvesList) {
            if (elf.getCallorieCount() > elfWithMost.getCallorieCount()) {
                elfWithMost = elf;
            }
        }
        return elfWithMost;
    }

    private void calculateAndPushDataIntoList(List<Elf> elvesList, List<String> callorieData) {
        int tempSum = 0;

        for (int i = 0; i < callorieData.size(); i++) {
            if (Objects.equals(callorieData.get(i), "")) {
                elvesList.add(new Elf(tempSum));
                tempSum = 0;
            } else if (i == callorieData.size() - 1) {
                tempSum += Integer.parseInt(callorieData.get(i));
                elvesList.add(new Elf(tempSum));
            } else {
                tempSum += Integer.parseInt(callorieData.get(i));
            }
        }
    }

    private List<String> readCalorieData(String calorieDataPath) {
        List<String> tempCalorieData;
        try {
            tempCalorieData = Files.readAllLines(Paths.get(calorieDataPath));
        } catch (IOException e) {
            logger.error("Callorie Data Not readable");
            tempCalorieData = null;
        }
        return tempCalorieData;
    }
}
