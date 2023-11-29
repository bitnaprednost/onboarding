package hr.bitnaprednost.days.D02_RockPaperScissors;

import hr.bitnaprednost.Utility.ParseUtility;
import hr.bitnaprednost.days.model.Day;

import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayTwo implements Day {
    String rockPaperScissorsDataPath = "src/main/resources/rockPaperScissorsData.txt";
    List<String> rockPaperScissorsData = ParseUtility.parseFromPathToList(rockPaperScissorsDataPath);


    @Override
    public void executePartOne() {
        System.out.println(rockPaperScissorsData);
    }

    @Override
    public void executePartTwo() {

    }
}
