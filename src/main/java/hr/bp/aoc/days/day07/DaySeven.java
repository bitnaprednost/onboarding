package hr.bp.aoc.days.day07;

import hr.bp.aoc.util.ParserUtil;
import hr.bp.aoc.model.Day;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DaySeven implements Day {

    String listOfCommandsPath = "src/main/resources/commandsData.txt";
    List<String> listOfCommands = ParserUtil.parseFromPathToList(listOfCommandsPath);


    @Override
    public void executePartOne() {
        listOfCommands.forEach(System.out::println);

    }

    @Override
    public void executePartTwo() {

    }
}
