package day4;

import java.util.stream.*;

public class TotalCardNumber {
    public int totalCardNumber (String filename){
        int  totalSum = 0;

        // Split the file content into lines
        String[] lines = filename.split(System.lineSeparator());

        int[] cardNumbers = new int[lines.length];
        int count = 0;

        // Process each line
        for (String line : lines)
        {
            cardNumbers[count]++;
            count++;

            // Use CardParser to parse the line and get arrays
            CardParser parser = new CardParser(line);

            // Use MatchCounter to calculate the number of matches
            MatchCounter counter = new MatchCounter(parser.getWinningNumbers(), parser.getPlayerNumbers());
            int matchCount = counter.getMatchCount();

            for (int k = count; k < (count + matchCount); k++)
            {
                cardNumbers[k] = cardNumbers[count-1] + cardNumbers[k];
            }
        }

        totalSum = IntStream.of(cardNumbers).sum();
        return totalSum;
    }
}
