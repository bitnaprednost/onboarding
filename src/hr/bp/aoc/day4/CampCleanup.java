import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CampCleanup {



    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day4/inputday4.txt";
        String input = readFile(filePath);
        //System.out.println(input);

        String[] assignments = input.split("\n");
        int overlapPart1 = 0;
        int overlapPart2 = 0;


        for (int i = 0; i < assignments.length; i++) {

            String task = assignments[i].trim();
            System.out.println(task);


            int firtMinus = task.indexOf("-");
            int positionComma = task.indexOf(",", firtMinus);
            ;
            int secondMinus = task.indexOf("-", positionComma);

            String[] first = {task.substring(0, firtMinus).trim(), task.substring(firtMinus + 1, positionComma).trim()};
            String[] second = {task.substring(positionComma + 1, secondMinus).trim(), task.substring(secondMinus + 1, task.length()).trim()};


            int begPrvi = Integer.parseInt(first[0]);
            int endPrvi = Integer.parseInt(first[1]);


            int begDrugi = Integer.parseInt(second[0]);
            int endDrugi = Integer.parseInt(second[1]);

            if (begPrvi >= begDrugi && endPrvi <= endDrugi) {
                overlapPart1++;
                overlapPart2++;
            } else if (begPrvi <= begDrugi && endPrvi >= endDrugi) {
                overlapPart1++;
                overlapPart2++;
            } else if (begDrugi <= begPrvi && endDrugi <= endPrvi && begPrvi <= endDrugi) {
                overlapPart2++;
            } else if (begDrugi >= begPrvi && endDrugi >= endPrvi && begDrugi <= endPrvi) {
                overlapPart2++;
            } else if (endPrvi == endDrugi || begPrvi == begDrugi || endPrvi == begDrugi || endDrugi == begPrvi) {
                overlapPart2++;
            }


        }

        System.out.println(overlapPart1);
        System.out.println(overlapPart2);

    }

    private static String readFile(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }

}