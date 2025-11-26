package com.bp.aoc.day5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

/**
 * @author Ivona Pavela
 */

public class RearrangementProcedure {

    public static void rearrangeCratesOneByOne(List<String> rearrangementProcedure, Map<Integer, Deque<Character>> stacksOfCrates){
        rearrangeCrates(rearrangementProcedure, stacksOfCrates, RearrangementProcedure::moveCratesOneByOne);
    }

    public static void rearrangeCratesInOrder(List<String> rearrangementProcedure, Map<Integer, Deque<Character>> stacksOfCrates){
        rearrangeCrates(rearrangementProcedure, stacksOfCrates, RearrangementProcedure::moveCratesInOrder);
    }

    private static void rearrangeCrates(List<String> procedure, Map<Integer, Deque<Character>> stacks,
                                        TriConsumer<Map<Integer, Deque<Character>>, Integer, Integer, Integer> moveStrategy){

        for(String command : procedure){
            String[] parts = command.split(" ");
            int amount = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]);
            int to = Integer.parseInt(parts[5]);
            moveStrategy.accept(stacks, amount, from, to);
        }

        printTopCrates(stacks);
    }

    private static void moveCratesInOrder(Map<Integer, Deque<Character>> stacks, int amount, int from, int to){
        Deque<Character> temp = new ArrayDeque<>();

        for (int i = 0; i < amount; i++) {
            temp.push(stacks.get(from).pop());
        }

        while (!temp.isEmpty()) {
            stacks.get(to).push(temp.pop());
        }
    }

    private static void moveCratesOneByOne(Map<Integer, Deque<Character>> stacks, int amount, int from, int to){
        for(int i = 0; i < amount; i++){
            stacks.get(to).push(stacks.get(from).pop());
        }
    }

    private static void printTopCrates(Map<Integer, Deque<Character>> stacks){
        for(int i = 1; i <= stacks.size(); i++){
            System.out.print(stacks.get(i).peek());
        }
    }

    @FunctionalInterface
    private interface TriConsumer<T, U, V, W> {
        void accept(T t, U u, V v, W w);
    }
}
