package day4;

import io.ReadFile;

public class Main {
    public static void main(String[] args) {

        // Specify the file name
        String fileName = "day4/scratchcard.txt";

        // Read the file
        ReadFile readFile = new ReadFile();
        String fileContent = readFile.readFile(fileName);

        // Solve task 1
        TotalPoint ScratchcardSum = new TotalPoint();
        int totalSum = ScratchcardSum.totalPoint(fileContent);

        System.out.println(totalSum);

        // Solve task 2
        TotalCardNumber ScratchcardNum = new TotalCardNumber();
        totalSum = ScratchcardNum.totalCardNumber(fileContent);

        System.out.println(totalSum);
    }
}