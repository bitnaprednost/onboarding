package hr.bp.aoc.day6;

import java.util.Arrays;
import java.util.List;

public class BoatConfiguration {
    private List<Race> races;

    public BoatConfiguration(List<Race> races) {
        this.races = races;
    }

    public int numberOfRecordsBeatMultiply() {
        int[] recordsBeatInRace = new int[races.size()];

        for (int raceInd = 0; raceInd < races.size(); raceInd++) {
            recordsBeatInRace[raceInd] = getNumOfWinsInRace(races.get(raceInd));
        }

        return multiplyElements(recordsBeatInRace);
    }

    private int multiplyElements(int[] array) {
        int product = 1;

        for (int element : array) {
            product *= element;
        }

        return product;
    }

    private int getNumOfWinsInRace(Race race) {
        int numOfWins = 0;

        for (int buttonHeld = 0; buttonHeld <= race.getTime(); buttonHeld++) {
            ToyBoat boat = new ToyBoat(buttonHeld, race.getTime());

            if (boat.raceWon(race)) {
                numOfWins++;
            }
        }

        return numOfWins;
    }
}
