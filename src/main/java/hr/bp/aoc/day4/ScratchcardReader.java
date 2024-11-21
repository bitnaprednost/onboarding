package hr.bp.aoc.day4;

import java.util.ArrayList;
import java.util.List;

public class ScratchcardReader {
//    private List<String> scratchcards;
//    private int totalPoints = 0;
    private List<Scratchcard> scratchcards;

    public ScratchcardReader(List<String> scratchcards) {
        this.scratchcards = stringToScratchcards(scratchcards);
    }

    public static List<Scratchcard> stringToScratchcards(List<String> scratchcardsString) {
        List<Scratchcard> scratchcards = new ArrayList<>();
        String winningNumbers = "";
        String myNumbers = "";

        for (String card : scratchcardsString) {
            String scratchcardId = card.split(":")[0].split(" ")[1];

            Scratchcard scratchcard = new Scratchcard(Integer.parseInt(scratchcardId));
            String numTogether = card.split(":")[1].strip();

            winningNumbers = numTogether.split("\\|")[0].strip();
            myNumbers = numTogether.split("\\|")[1].strip();

            scratchcard.setMyNumbers(myNumbers);
            scratchcard.setWinningNumbers(winningNumbers);

            scratchcards.add(scratchcard);
        }

        return scratchcards;
    }

    public int getTotalPoints() {
        int totalPoints = 0;

        for (Scratchcard scratchcard : scratchcards) {
            totalPoints += scratchcard.getPoints();
        }

        return totalPoints;
    }
}
