package hr.bp.aoc.day6;

import java.util.List;

public class BoatConfiguration {
    private List<Race> races;

    public BoatConfiguration(List<Race> races) {
        this.races = races;
    }

    public long numberOfRecordsBeatMultiply() {
        long[] recordsBeatInRace = new long[races.size()];

        for (int raceInd = 0; raceInd < races.size(); raceInd++) {
            recordsBeatInRace[raceInd] = getNumOfWinsInRace(races.get(raceInd));
        }

        return multiplyElements(recordsBeatInRace);
    }

    private long multiplyElements(long[] array) {
        int product = 1;

        for (long element : array) {
            product *= element;
        }

        return product;
    }

    private long getNumOfWinsInRace(Race race) {
        long numOfWins = 0;

        for (long buttonHeld = 0; buttonHeld <= race.getTime(); buttonHeld++) {
            ToyBoat boat = new ToyBoat(buttonHeld, race.getTime());

            if (boat.raceWon(race)) {
                numOfWins++;
            }
        }

        return numOfWins;
    }
}
