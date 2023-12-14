package hr.bp.aoc.monkeyInTheMiddle;

import hr.bp.aoc.monkeyInTheMiddle.monkey.Monkey;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyManager;
import hr.bp.aoc.monkeyInTheMiddle.monkey.MonkeyParser;
import hr.bp.aoc.util.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String textFromFile = Parser.getTextFromFile("Resources/day11Data.txt");

        Monkey[] monkeyList = MonkeyParser.parseToMonkies(textFromFile);
        MonkeyManager monkeyManager = MonkeyManager.of(monkeyList);
        monkeyManager.simulateRounds(20);

        Integer result = monkeyManager.getProductOfTopActiveMonkeys(2);
        System.out.println(result);
    }
}
