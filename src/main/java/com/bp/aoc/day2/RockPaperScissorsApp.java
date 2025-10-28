package com.bp.aoc.day2;

import com.bp.aoc.util.ContentLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ivona Pavela
 */


public class RockPaperScissorsApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List firstColumn = new ArrayList<>();
        List secondColumn = new ArrayList<>();
        int totalScore = 0;

        System.out.print("Select mode:\n" +
                "[1] find total score if the first column is what your opponent is going to play and the second column is what you should play in response\n" +
                "[2] find total score if the first column is what your opponent is going to play and the second column says how the round needs to end\n ");
        String mode = scanner.nextLine().trim().toLowerCase();

        List<String> lines = ContentLoader.loadContent("day2.txt");

        for(String line: lines){
            line = line.replaceAll("\\s", "");
            if(line.length() != 2){
                throw new IllegalArgumentException("Error: Line must contain two characters");
            }
            firstColumn.add(String.valueOf(line.charAt(0)));
            secondColumn.add(String.valueOf(line.charAt(1)));

        }

        switch (mode) {
            case "1" -> totalScore = Tournament.play(firstColumn, secondColumn, true);
            case "2" -> totalScore = Tournament.play(firstColumn, secondColumn, false);
            default -> System.out.println("Invalid mode");
        }

        System.out.println("Your total score since everything went exactly according to your strategy guide is " + totalScore);
    }
}
