package hr.bp.aoc.day6;

public class ToyBoat {
    private int speed;
    private int raceTime;

    public ToyBoat(int timeSpentHoldingButton, int raceTime) {
        this.speed = timeSpentHoldingButton;
        this.raceTime = raceTime;
    }

    private int getRemainingRaceTime() {
        return raceTime - speed;
    }

    public int getTraveledDistance() {
        return speed * getRemainingRaceTime();
    }

    public boolean raceWon(Race race) {
        return getTraveledDistance() > race.getRecordDistance();
    }
}
