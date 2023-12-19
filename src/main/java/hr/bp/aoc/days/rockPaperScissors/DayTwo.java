package hr.bp.aoc.days.rockPaperScissors;

import hr.bp.aoc.util.ParserUtil;
import hr.bp.aoc.model.Day;

import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayTwo implements Day {
    String rockPaperScissorsDataPath = "src/main/resources/rockPaperScissorsData.txt";
    List<String> rockPaperScissorsData = ParserUtil.parseFromPathToList(rockPaperScissorsDataPath);


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
