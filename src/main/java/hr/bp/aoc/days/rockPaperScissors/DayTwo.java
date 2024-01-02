package hr.bp.aoc.days.rockPaperScissors;

import hr.bp.aoc.util.ReaderUtil;
import hr.bp.aoc.model.Day;

import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayTwo implements Day {
    String rockPaperScissorsDataPath = "src/main/resources/rockPaperScissorsData.txt";
    List<String> rockPaperScissorsData = ReaderUtil.readFromPathToList(rockPaperScissorsDataPath);


    @Override
    public void executePartOne() {
        System.out.println(rockPaperScissorsData);
    }

    @Override
    public void executePartTwo() {

    }

    @Override
    public String getDayOrderNumber() {
        return "Day Two";
    }
}
