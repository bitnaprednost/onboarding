package com.ivona.aoc;

import java.util.ArrayList;
import java.util.Scanner;

import static com.ivona.aoc.CampCleanup.convertStringToInt;

public class RangeOverlap {

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {

        int counter = 0;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(CampCleanup.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                counter += checkForOverlappedSections(line);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Ranges overlap in " + counter + " assignments");
    }

    private static int checkForOverlappedSections(String line){
        int comma = line.indexOf(",");

        ArrayList<Integer> firstElfSection = convertStringToInt(line.substring(0,comma));
        ArrayList<Integer> secondElfSection = convertStringToInt(line.substring(comma + 1));

        for(int i = 0; i < firstElfSection.size(); i++){
            int index = firstElfSection.get(i);

            if(secondElfSection.contains(index)){
                return 1;
            }
        }

        return 0;
    }
}
