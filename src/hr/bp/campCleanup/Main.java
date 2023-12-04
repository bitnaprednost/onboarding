package hr.bp.campCleanup;

import hr.bp.util.Parser;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
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

    public static <T> Boolean bifunctionBoolean(List<List<T>> array, BiFunction<List<T>, List<T>, Boolean> bifunction){
        Iterator<List<T>> iterator = array.stream().iterator();
        return bifunction.apply(iterator.next(), iterator.next());
    }

    public static void main(String args[]) throws IOException {
        String input = Parser.getTextFromFile("Resources/day4Data.txt");
        //format: [[[2,3,4],  [6,7,8]], [...], ...]
        List<List<List<Integer>>> lists = textToListHell(input);

        BiFunction<List<Integer>, List<Integer>, Boolean> containsEachOther = (first, second) -> first.containsAll(second) || second.containsAll(first);
        BiFunction<List<Integer>, List<Integer>, Boolean> matchesOneElement = (first, second) ->  first.stream().anyMatch(second::contains);

        long result1 = lists.stream().map((twoArrays) -> bifunctionBoolean(twoArrays, containsEachOther)).filter(pred->pred).count();
        System.out.println(result1);

        long result2 = lists.stream().map((twoArrays) -> bifunctionBoolean(twoArrays, matchesOneElement)).filter(pred->pred).count();
        System.out.println(result2);
    }


}
