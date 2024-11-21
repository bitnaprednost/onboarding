package hr.bp.aoc.day4;

import java.util.ArrayList;
import java.util.List;

public class Scratchcard {
    private List<Integer> winningNumbers;
    private List<Integer> myNumbers;
    private int id;
    private int matches = -1;

    public Scratchcard(int id) {
        this.id = id;
        winningNumbers = new ArrayList<>();
        myNumbers = new ArrayList<>();
    }

    public void setWinningNumbers(String numbersString) {
        winningNumbers = stringToNumList(numbersString);
    }

    public void setMyNumbers(String numbersString) {
        myNumbers = stringToNumList(numbersString);
    }

    private List<Integer> stringToNumList(String numberString) {
        List<Integer> numberList = new ArrayList<>();

        for (String num : numberString.split(" ")) {
            if (!num.isEmpty())
                numberList.add(Integer.parseInt(num.strip()));
        }

        return numberList;
    }

    public int getPoints() {
        int matches = getMatches();
        return matches == 1 ? 1 : (matches > 1 ? (int) Math.pow(2, matches-1) : 0);
    }

    private int getMatches() {
        return matches < 0 ? setMatches() : matches;
    }

    private int setMatches() {
        int matches = 0;

        for (Integer myNumber : myNumbers) {
            if (winningNumbers.contains(myNumber))
                matches++;
        }

        this.matches = matches;
        return matches;
    }
}
