package com.bp.aoc.day5;

import java.util.*;

public class CratesInStacks {
    public static Map<Integer, Deque<Character>> storingCratesInStacks(List<String> lines) {
        Map<Integer, Deque<Character>> stacksOfCrates = new HashMap<>();
        int columns = lines.get(lines.size() - 1).trim().split("\\s+").length;

        for(int i = 1; i <= columns; i++){
            stacksOfCrates.put(i, new ArrayDeque<>());
        }

        for(int r = 0; r < lines.size() - 1; r++){
            String line = lines.get(r);
            for(int c = 0; c <= columns; c++){
                int index = 1 + c * 4;
                if(index <= line.length()){
                    char ch = line.charAt(index);
                    if(ch != ' ' && ch != '[' && ch != ']'){
                        stacksOfCrates.get(c + 1).addLast(ch);
                    }
                }
            }
        }
        return stacksOfCrates;
    }
}
