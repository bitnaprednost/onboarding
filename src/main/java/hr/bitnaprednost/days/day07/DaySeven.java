package hr.bitnaprednost.days.day07;

import hr.bitnaprednost.Utility.ParseUtility;
import hr.bitnaprednost.days.model.Day;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DaySeven implements Day {

    String listOfCommandsPath = "src/main/resources/commandsData.txt";
    List<String> listOfCommands = ParseUtility.parseFromPathToList(listOfCommandsPath);


    @Override
    public void executePartOne() {
        listOfCommands.forEach(System.out::println);

    }

    @Override
    public void executePartTwo() {

    }
}
