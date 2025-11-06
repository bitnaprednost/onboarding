package com.bp.aoc.day5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class RearrangementProcedure {
    public static void rearrangeCrates(List<String> rearrangementProcedure, Map<Integer, Deque<Character>> stacksOfCrates, boolean inOrder){

        for(String command : rearrangementProcedure){
            String[] parts = command.split(" ");
            int amount = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]);
            int to = Integer.parseInt(parts[5]);

            if(!inOrder){
                for(int i = 0; i < amount; i++){
                    stacksOfCrates.get(to).push(stacksOfCrates.get(from).pop());
                }
            }
            else{
                Deque<Character> temp = new ArrayDeque<>();

                for (int i = 0; i < amount; i++) {
                    temp.push(stacksOfCrates.get(from).pop());
                }

                while (!temp.isEmpty()) {
                    stacksOfCrates.get(to).push(temp.pop());
                }
            }
        }

        for(int i = 1; i <= stacksOfCrates.size(); i++){
            System.out.print(stacksOfCrates.get(i).pop());
        }
    }
}
