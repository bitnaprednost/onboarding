package day6;

import util.Parser;

import java.io.IOException;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String textFromFile = Parser.getTextFromFile("Resources/day6Data.txt");

//        int result1 = IntStream.range(0, textFromFile.length() - 4)
//                .map(i -> {
//                    if (textFromFile.substring(i).chars().limit(4).distinct().count() == 4) return i + 4;
//                    else return -1;
//                }).filter(i -> i > 0).findFirst().getAsInt();

        int result1 = IntStream.range(0, textFromFile.length() - 4)
                .takeWhile(i -> textFromFile.substring(i).chars().limit(4).distinct().count() < 4)
                .max().getAsInt() + 5;

        System.out.println(result1);


        int result2 = IntStream.range(0, textFromFile.length() - 14)
                .takeWhile(i -> textFromFile.substring(i).chars().limit(14).distinct().count() < 14)
                .max().getAsInt() + 15;

        System.out.println(result2);

    }
}
