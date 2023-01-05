package hr.bp.aoc.day6;

import hr.bp.aoc.InputUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TuningTrouble {

    public static void main(String[] args) throws Exception {


        Path inputFilePath = InputUtil.getPath(TuningTrouble.class, "inputday6.txt");
        Path filePath = inputFilePath.toAbsolutePath();

        String input = readLine(filePath.toString());

        //Part One
        int charactersToBeProcessedMarker4 = MarkerUtil.numberOfCharactersMarker4(input);
        System.out.println(charactersToBeProcessedMarker4);

        //Part Two
        int charactersToBeProcessedMarker14 = MarkerUtil.numberOfCharactersMarker14(input);
        System.out.println(charactersToBeProcessedMarker14);
    }

    private static String readLine(String filePath) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }


}
