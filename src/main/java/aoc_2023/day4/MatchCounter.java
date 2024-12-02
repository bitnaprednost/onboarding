package aoc_2023.day4;

public class MatchCounter {
    private int matchCount;

    public MatchCounter(int[] winningNumbers, int[] playerNumbers) {
        this.matchCount = calculateMatchCount(winningNumbers, playerNumbers);
    }

    private int calculateMatchCount(int[] winningNumbers, int[] playerNumbers) {
        int i = 0, j = 0, count = 0;

        while (i < winningNumbers.length && j < playerNumbers.length)
        {
            if (winningNumbers[i] == playerNumbers[j])
            {
                count++;
                i++;
                j++;
            }
            else if (winningNumbers[i] < playerNumbers[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }

        return count;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
