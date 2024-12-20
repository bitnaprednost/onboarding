package hr.bp.aoc2024.day7;

import java.util.ArrayList;
import java.util.List;

public class CalibrationEquationParser {
    List<String> input;

    public CalibrationEquationParser(List<String> input) {
        this.input = input;
    }

    public List<String> parseInput() {
        List<String> parsedInput = new ArrayList<>();

        for(String line : input) {
            parsedInput.add(getDataFromLine(line));
        }

        return parsedInput;
    }

    private static String getDataFromLine(String line) {
        StringBuilder sb = new StringBuilder();

        sb.append(line.split(":")[0].strip());

        String[] numbersString = line.strip().split(":")[1].split(" ");

        for (String number : numbersString){
            sb.append(" ");
            sb.append(number.strip());
    }
        return sb.toString();
    }
}
