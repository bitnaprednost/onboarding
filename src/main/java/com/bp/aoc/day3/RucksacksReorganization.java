package com.bp.aoc.day3;

import java.util.Scanner;

public class RucksacksReorganization {

    /*Using the difference of Unicode value and priority*/
    public static final int differenceFromUppercase = 38;
    public static final int differenceFromLowercase = 96;

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args){
        int sumOfPriorities = 0;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(RucksacksReorganization.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                sumOfPriorities += reorganization(line);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Sum of priorities is " + sumOfPriorities);
    }

    public static int reorganization(String line){
        int priority = 0;
        int mid = line.length() / 2;
        String duplicates = "";

        String firstCompartment = line.substring(0, mid);
        String secondCompartment = line.substring(mid);

        System.out.println(firstCompartment);
        System.out.println(secondCompartment);

        for(int i = 0; i < firstCompartment.length(); i++){
            char letter = firstCompartment.charAt(i);
            if(secondCompartment.indexOf(letter) != -1 && duplicates.indexOf(letter) == -1){
                duplicates += letter;
                if(Character.isUpperCase(letter)){
                    priority = (letter - differenceFromUppercase);
                }
                else{
                    priority += (letter - differenceFromLowercase);
                }
            }
        }

        return priority;
    }
}
