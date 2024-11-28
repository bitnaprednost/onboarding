package hr.bp.aoc.day6;

public class ToyBoat {
    private long speed;
    private long raceTime;

    public ToyBoat(long timeSpentHoldingButton, long raceTime) {
        this.speed = timeSpentHoldingButton;
        this.raceTime = raceTime;
    }

    private long getRemainingRaceTime() {
        return raceTime - speed;
    }

    public long getTraveledDistance() {
        return speed * getRemainingRaceTime();
    }

    public boolean raceWon(Race race) {
        return getTraveledDistance() > race.getRecordDistance();
    }
}
