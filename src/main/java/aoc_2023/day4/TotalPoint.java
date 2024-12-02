package aoc_2023.day4;

public class TotalPoint {
    public int totalPoint (String filename){
        int  totalSum = 0;

        // Split the file content into lines
        String[] lines = filename.split(System.lineSeparator());

        // Process each line
        for (String line : lines)
        {
            // Use CardParser to parse the line and get arrays
            CardParser parser = new CardParser(line);

            // Use MatchCounter to calculate the number of matches
            MatchCounter counter = new MatchCounter(parser.getWinningNumbers(), parser.getPlayerNumbers());
            int matchCount = counter.getMatchCount();

            int cardValue = 0;

            // Calculate the card's value based on the number of matches
            if (matchCount > 0)
            {
                cardValue = 1; // First match
                for (int k = 1; k < matchCount; k++)
                {
                    cardValue *= 2; // Double for each subsequent match
                }
            }

            totalSum += cardValue;
        }
        return totalSum;
    }
}
