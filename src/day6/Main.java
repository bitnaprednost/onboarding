package day6;

import util.Parser;

import java.io.IOException;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static int firstSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .map(i -> textFromFile.substring(i).chars().limit(consecutive).distinct().count() == consecutive ? i + consecutive : -1)
                .filter(i -> i > 0)
                .findFirst().getAsInt();
    }

    public static int secondSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .takeWhile(i -> textFromFile.substring(i).chars().limit(consecutive).distinct().count() < consecutive)
                .max().getAsInt() + consecutive + 1;
    }

    public static int thirdSolution(String textFromFile, int consecutive){
        return IntStream.range(0, textFromFile.length() - consecutive)
                .dropWhile(i -> textFromFile.substring(i).chars().limit(consecutive).distinct().count() < consecutive)
                .findFirst().getAsInt() + consecutive;
    }

    public static void main(String[] args) throws IOException {

        String textFromFile = Parser.getTextFromFile("Resources/day6Data.txt");

        System.out.println(firstSolution(textFromFile, 4));
        System.out.println(secondSolution(textFromFile, 4));
        System.out.println(thirdSolution(textFromFile, 4));
        System.out.println(thirdSolution(textFromFile, 15));

    }
}
