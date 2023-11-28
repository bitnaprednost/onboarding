package org.example.days.D02_RockPaperScissors;

import org.example.Utility.ParseUtility;
import org.example.days.model.Day;

import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayTwo implements Day {
    String rockPaperScissorsDataPath = "src/main/resources/rockPaperScissorsData.txt";
    List<String> rockPaperScissorsData = ParseUtility.parseFromPathToList(rockPaperScissorsDataPath);


    @Override
    public void executePartOne() {

    }

    @Override
    public void executePartTwo() {

    }
}
