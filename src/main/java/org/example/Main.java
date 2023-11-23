package org.example;

import org.example.days.day03.DayThree;
import org.example.days.day04.DayFour;
import org.example.days.day05.DayFive;
import org.example.days.day06.DaySix;
import org.example.days.model.Day;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Day daySix = new DaySix();
        daySix.executePartTwo();
    }


}