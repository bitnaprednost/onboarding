package com.bp.aoc.day1;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreeElvesCounter {

    /*Scanner to read the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {

        int calories = 0;
        int counter = 1;
        int total = 0;
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
                    sortedAdd(elves, counter, calories);
                    counter++;
                    calories = 0;
                }
            }

            sortedAdd(elves, counter, calories);

        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        /*Printing elves and the number of calories*/
        for(Elf elf: elves){
            System.out.println(elf);
        }

        /*Calculating the total and printing the first three elves who have the largest number of calories*/
        for(int i = 0; i < 3 && i < elves.size(); i++){
            Elf elf = elves.get(i);
            total += elf.numberOfCalories();
            System.out.println(i + 1 + " elf carrying the most calories is " + elf);
        }

        System.out.println("The top three elves carrying the most calories are in total carrying: " + total);
    }

    /*sorted input in order to retrieve the first three elements*/
    private static void sortedAdd(ArrayList<Elf> elves, int position, int calories){
        int i = 0;
        while (i < elves.size() && elves.get(i).numberOfCalories() > calories) {
            i++;
        }

        elves.add(i, new Elf(position, calories));
    }
}