package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static String getTextFromFile(String file) throws IOException {
        String everything = null;
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }

        return everything;
    }

    private static List<List<List<Integer>>> textToListHell(String input) {
        List<List<List<Integer>>> result = new ArrayList<>();
        String[] split = input.split("\n");
        for(String line : split){
            int[] numbers = Arrays.stream(line.split("[,-]")).mapToInt(Integer::parseInt).toArray();
            List<Integer> temp1 = IntStream.rangeClosed(numbers[0], numbers[1]).boxed().toList();
            List<Integer> temp2 = IntStream.rangeClosed(numbers[2], numbers[3]).boxed().toList();
            List<List<Integer>> list = List.of(temp1, temp2);
            result.add(list);
        }
        return result;
    }

    public static void main(String args[]) throws IOException {
        String input = getTextFromFile("Resources/day4Data.txt");
        List<List<List<Integer>>> lists = textToListHell(input);

        long result1 = lists.stream().map(array -> {
            Iterator<List<Integer>> iterator = array.stream().iterator();
            List<Integer> first = iterator.next();
            List<Integer> second = iterator.next();
            return first.containsAll(second) || second.containsAll(first);
        }).filter(pred->pred).count();

        //System.out.println(result1);

        long result2 = lists.stream().map(array -> {
            Iterator<List<Integer>> iterator = array.iterator();
            List<Integer> first = iterator.next();
            List<Integer> second = iterator.next();
            return first.stream().anyMatch(second::contains);
        }).filter(pred->pred).count();

        System.out.println(result2);
        //test
    }


}
