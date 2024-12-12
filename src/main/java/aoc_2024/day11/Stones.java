package aoc_2024.day11;

public class Stones {

    private int stoneNumber = 0;
    private int NumberOfBlinks;

    public void setNumberOfBlinks(int NumberOfBlinks){
        this.NumberOfBlinks = NumberOfBlinks;
    }

    public int getStonesNumber(String input){
        String[] stones = input.split("\\s+");

        for (String stone : stones){
            applyRules(Long.parseLong(stone), 0);
        }
        return stoneNumber;

    }

    private void applyRules(Long stone, int count){

        if (count == NumberOfBlinks){
            stoneNumber++;
            return;
        }

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
    }
}
