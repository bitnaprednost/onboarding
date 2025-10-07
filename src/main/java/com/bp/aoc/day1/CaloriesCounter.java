package com.bp.aoc.day1;

import java.util.ArrayList;
import java.util.Scanner;

public class CaloriesCounter {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {

        int calories = 0;
        int counter = 1;
        ArrayList<Elf> elves = new ArrayList<>();

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(CaloriesCounter.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();

                if(!line.isEmpty()){
                    calories += Integer.parseInt(line);
                }
                else{
                    addElf(elves, counter, calories);
                    counter++;
                    calories = 0;
                }
            }

            addElf(elves, counter, calories);

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        /*Printing elves and the number of calories*/
        for(Elf elf: elves){
            System.out.println(elf);
        }

        /*Printing the elf with the maximum number of calories*/
        System.out.println("The elf with maximum number of calories is " + getMaximumCaloriesElf(elves));
    }

    private static void addElf(ArrayList<Elf> elves, int counter, int calories){
        if(calories > 0){
            elves.add(new Elf(counter, calories));
        }
    }

    private static Elf getMaximumCaloriesElf(ArrayList<Elf> elves){
        Elf maximumCaloriesElf = elves.get(0);

        for(Elf elf: elves){
            if(elf.numberOfCalories() >= maximumCaloriesElf.numberOfCalories()){
                maximumCaloriesElf = elf;
            }
        }

        return maximumCaloriesElf;
    }
}

