package hr.bp.aoc.day6;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        List<String> races = Utils.readFromFile("inputDay6.txt");

        RaceParser raceParser = new RaceParser(races, true);
        BoatConfiguration boatConfigurations = new BoatConfiguration(raceParser.getRacesFromFile());

        System.out.println(boatConfigurations.numberOfRecordsBeatMultiply());
    }
}
