package hr.bp.aoc.day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TuningTrouble {

    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day6/inputday6.txt";
        String input = readLine(filePath);

        //Part One
        int charactersToBeProcessedMarker4 = MarkerUtil.numberOfCharactersMarker4(input);

        System.out.println(charactersToBeProcessedMarker4);

        //Part Two
        int charactersToBeProcessedMarker14 = MarkerUtil.numberOfCharactersMarker14(input);
        System.out.println(charactersToBeProcessedMarker14);
    }

    private static String readLine(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }


}
