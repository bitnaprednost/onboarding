package com.bp.aoc.day3;

import java.util.Scanner;

public class BadgeForThreeElves {
    /*Using the difference of Unicode value and priority*/
    public static final int differenceFromUppercase = 38;
    public static final int differenceFromLowercase = 96;

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args){
        int sumOfPriorities = 0;
        boolean isThreeLines = true;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(BadgeForThreeElves.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(isThreeLines){
                String words[] = new String[3];

                for(int i = 0; i < 3; i++){
                    if(scanner.hasNextLine()){
                        words[i] = scanner.nextLine();
                    }
                    else{
                        isThreeLines = false;
                        break;
                    }
                }


                if(isThreeLines){
                    sumOfPriorities += reorganization(words);
                }
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Sum of priorities is " + sumOfPriorities);
    }

    public static int reorganization(String[] words){
        int priority = 0;
        String duplicates = "";

        System.out.println(words[0]);
        System.out.println(words[1]);
        System.out.println(words[2]);

        for(int i = 0; i < words[0].length(); i++){
            char letter = words[0].charAt(i);
            if(words[1].indexOf(letter) != -1 && words[2].indexOf(letter) != -1 && duplicates.indexOf(letter) == -1){
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
