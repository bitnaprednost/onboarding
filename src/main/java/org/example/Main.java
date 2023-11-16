package org.example;

import org.example.days.day03.DayThree;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
     /*   DayOne dayOne = new DayOne();
        dayOne.executePartOne();
        System.out.println("--------------------------");
        dayOne.executePartTwo();*/

        //DayTwo dayTwo = new DayTwo();
        //dayTwo.executeDay();

        DayThree dayThree = new DayThree();
        dayThree.executePartTwo();
       /* String input = Files.readString(Path.of("src/main/resources/backpackData.txt"));



        var counter = IntStream.range(0, input.length()).iterator();
        var sum2 = input.lines()
                .collect(Collectors.groupingBy(c -> counter.nextInt()/3)).values().stream()
                .mapToInt(l -> commonPriority(l)).sum();
        System.out.printf("part 2: %d\n", sum2);*/
    }

    static int commonPriority(List<String> strings) {
        // common character in list of strings
        var c = strings.stream().reduce((s1, s2) -> commonChars(s1, s2)).get().charAt(0);
        return c < 'a' ? c - 'A' + 27 : c - 'a' + 1; // convert to priority
    }

    static String commonChars(String a, String b) {
        return a.chars().filter(i1 -> b.chars().anyMatch(i2 -> i1 == i2)).distinct()
                .mapToObj(c -> Character.toString(c)).collect(Collectors.joining());
    }

}