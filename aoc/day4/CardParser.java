package day4;

import converter.ConvertStringToIntArray;

import java.util.Arrays;

public class CardParser {
    private int[] winningNumbers;
    private int[] playerNumbers;

    public CardParser(String cardLine) {
        // Split the line at ':' and '|'
        String[] parts = cardLine.split(":")[1].trim().split("\\|");

        // Create arrays for winning numbers and player numbers
        this.winningNumbers = ConvertStringToIntArray.convertToIntArray(parts[0].trim().split("\\s+"));
        this.playerNumbers = ConvertStringToIntArray.convertToIntArray(parts[1].trim().split("\\s+"));

        // Sort the arrays for easier matching
        Arrays.sort(this.winningNumbers);
        Arrays.sort(this.playerNumbers);
    }

    public int[] getWinningNumbers() {
        return winningNumbers;
    }

    public int[] getPlayerNumbers() {
        return playerNumbers;
    }
}
