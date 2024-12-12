package aoc_2024.day11;

import java.util.HashMap;
import java.util.Map;

public class Stones {

    private long stoneNumber = 0;
    private int NumberOfBlinks;

    private final Map<String, Long> memo = new HashMap<>();

    public void setNumberOfBlinks(int NumberOfBlinks){
        this.NumberOfBlinks = NumberOfBlinks;
    }

    public long getStonesNumber(String input){
        String[] stones = input.split("\\s+");

        for (String stone : stones){
            applyRules(Long.parseLong(stone), 0);
        }
        return stoneNumber;

    }

    private void applyRules(Long stone, int count){

        String memoKey = stone + "," + count;
        if (memo.containsKey(memoKey)) {
            stoneNumber += memo.get(memoKey);
            return;
        }


        if (count == NumberOfBlinks){
            stoneNumber++;
            memo.put(memoKey, 1L);
            return;
        }

        long originalStoneNumber = stoneNumber;

        if (stone == 0)
        {
            stone = 1L;
            applyRules(stone, count + 1);
        }
        else if (String.valueOf(stone).length() % 2 == 0)
        {
            int length = String.valueOf(stone).length()/2;
            Long firstPart  = Long.parseLong(String.valueOf(stone).substring(0,length));
            applyRules(firstPart, count + 1);


            Long secondPart = Long.parseLong(String.valueOf(stone).substring(length));
            applyRules(secondPart, count + 1);
        }
        else
        {
            stone = stone*2024;
            applyRules(stone, count + 1);
        }

        long stonesAdded = stoneNumber - originalStoneNumber;
        memo.put(memoKey, stonesAdded);
    }
}
