package hr.bp.aoc.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CratesUtil {
    static int countNumberOfStacks(String[] input, int heightOfStack) {
        String[] numbers = input[heightOfStack].split(" ");
        int count = 0;
        for (String str : numbers) {
            try {
                Integer.parseInt(str);
            } catch (NumberFormatException e) {
                count++;
            }
        }
        return numbers.length - count;
    }

    static List<Stack<Character>> createStacks(List<String> crates, int numberOfStacks) {
        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new Stack<>());
        }
        for (String row : crates) {
            int i = 0;
            while (i < row.length()) {
                if (row.charAt(i) == '[') {
                    int indexOfLetter = i + 1;
                    char letter = row.charAt(indexOfLetter);
                    int whichStack = (indexOfLetter) / 4;
                    stacks.get(whichStack).push(letter);
                    i++;
                }
                i++;

            }

        }
        return stacks;
    }

    static void moveCratesPartOneAndTwo(List<String> moves, List<Stack<Character>> stacksPart1, List<Stack<Character>> stacksPart2) {
        for (String row : moves) {

            int lastIndexMove = row.indexOf("move") + 3;
            int firstIndexFrom = row.indexOf("from");
            int firstIndexTo = row.indexOf("to");

            int howMuch = Integer.parseInt(row.substring(lastIndexMove + 1, firstIndexFrom - 1).trim());
            int from = Integer.parseInt(row.substring(firstIndexFrom + 4, firstIndexTo - 1).trim());
            int to = Integer.parseInt(row.substring(firstIndexTo + 2).trim());

            Stack<Character> temp = new Stack<>();
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

            temp.clear();


        }
    }

    static void printTopCrates(List<Stack<Character>> stacks) {
        StringBuilder topElements = new StringBuilder();
        for (Stack<Character> stack : stacks) {
            topElements.append(stack.peek());
        }
        System.out.println(topElements);
    }
}
