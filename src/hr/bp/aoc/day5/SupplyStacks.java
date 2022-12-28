package hr.bp.aoc.day5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.Collections;

public class SupplyStacks {

    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day5/inputday5.txt";
        String input = readFile(filePath);
        //System.out.println(input);

        ArrayList<String> crates = new ArrayList<String>();
        ArrayList<String> moves = new ArrayList<String>();

        ArrayList<Stack<Character>> stacksPart1 = new ArrayList<Stack<Character>>();
        ArrayList<Stack<Character>> stacksPart2 = new ArrayList<Stack<Character>>();

        int heightOfStack = 0;


        for (String line : input.split("\n")) {
            if (line.contains("[")) {
                crates.add(line);
                heightOfStack++;
            } else if (line.contains("move")) {
                moves.add(line);

            }
        }


        String[] numbers = input.split("\n")[heightOfStack].split(" ");
        int count = 0;
        for (String str : numbers) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                count++;
            }
        }

        int numberOfStacks = numbers.length - count;
        System.out.println(numberOfStacks);
        //System.out.println();


        for (int i = 0; i < numberOfStacks; i++) {
            stacksPart1.add(new Stack<Character>());
            stacksPart2.add(new Stack<Character>());
        }


        //System.out.println(numberOfStacks);
        //System.out.println(crates.toString());
        //System.out.println(moves.toString());


        Collections.reverse(crates);

        for (String row : crates) {
            int i = 0;
            while (i < row.length()) {
                if (Character.compare(row.charAt(i), '[') == 0) {
                    int indexOfLetter = i + 1;
                    char letter = row.charAt(indexOfLetter);
                    int whichStack = (indexOfLetter) / 4;
                    stacksPart1.get(whichStack).push(letter);
                    stacksPart2.get(whichStack).push(letter);
                    //System.out.println(letter);
                    i++;
                }
                i++;

            }

        }

        //System.out.println(stacksPart1.toString());

        for (String row : moves) {
            row.trim();

            int lastIndexMove = row.indexOf("move") + 3;
            int firstIndexFrom = row.indexOf("from");
            int firstIndexTo = row.indexOf("to");

            int howMuch = Integer.parseInt(row.substring(lastIndexMove + 1, firstIndexFrom - 1).trim());
            int from = Integer.parseInt(row.substring(firstIndexFrom + 4, firstIndexTo - 1).trim());
            int to = Integer.parseInt(row.substring(firstIndexTo + 2, row.length()).trim());

            Stack<Character> temp = new Stack<Character>();
            for (int i = 0; i < howMuch; i++) {
                char el = stacksPart1.get(from - 1).pop();
                stacksPart1.get(to - 1).push(el);
                char el2 = stacksPart2.get(from - 1).pop();
                temp.push(el2);
            }

            for (int j = 0; j < howMuch; j++) {
                char el2 = temp.pop();
                stacksPart2.get(to - 1).push(el2);
            }

            //System.out.println(stacksPart2.toString());
            temp.clear();

        }

        //System.out.println(stacksPart1.toString());
        String part1 = "";
        String part2 = "";
        for (int i = 0; i < numberOfStacks; i++) {
            part1 += stacksPart1.get(i).peek();
            part2 += stacksPart2.get(i).peek();
        }
        System.out.println(part1);
        System.out.println(part2);

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
