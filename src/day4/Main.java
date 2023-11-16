package day4;

import util.Parser;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {

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

    public static Boolean bifunctionPipeline(List<List<Integer>> array, BiFunction<List<Integer>, List<Integer>, Boolean> bifunction){
        Iterator<List<Integer>> iterator = array.stream().iterator();
        return bifunction.apply(iterator.next(), iterator.next());
    }

    public static void main(String args[]) throws IOException {
        String input = Parser.getTextFromFile("Resources/day4Data.txt");
        //format: [[[2,3,4],  [6,7,8]], [...], ...]
        List<List<List<Integer>>> lists = textToListHell(input);

        BiFunction<List<Integer>, List<Integer>, Boolean> bifunction1 = (first, second) -> first.containsAll(second) || second.containsAll(first);
        BiFunction<List<Integer>, List<Integer>, Boolean> bifunction2 = (first, second) ->  first.stream().anyMatch(second::contains);

        long result1 = lists.stream().map((array) -> bifunctionPipeline(array, bifunction1)).filter(pred->pred).count();
        System.out.println(result1);

        long result2 = lists.stream().map((array) -> bifunctionPipeline(array, bifunction2)).filter(pred->pred).count();
        System.out.println(result2);
    }


}
