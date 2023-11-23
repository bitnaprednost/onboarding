package org.example;

import org.example.days.day03.DayThree;
import org.example.days.day04.DayFour;
import org.example.days.day05.DayFive;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
     /*   DayOne dayOne = new DayOne();
        dayOne.executePartOne();
        System.out.println("--------------------------");
        dayOne.executePartTwo();*/

        //DayTwo dayTwo = new DayTwo();
        //dayTwo.executeDay();

        /*DayThree dayThree = new DayThree();
        dayThree.executePartTwo();*/

       /* DayFour dayFour = new DayFour();
        dayFour.executePartTwo();*/

        DayFive dayFive = new DayFive();
        dayFive.executePartTwo();
    }


}