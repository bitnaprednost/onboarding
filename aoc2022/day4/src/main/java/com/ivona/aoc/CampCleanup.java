package com.ivona.aoc;

import java.util.ArrayList;
import java.util.Scanner;

public class CampCleanup {

    /*Scanner to scan the name of the file provided by the user*/
    public static Scanner scannerFileName = new Scanner(System.in);

    public static void main(String[] args) {

        int counter = 0;

        System.out.println("Enter the name of the file:");
        String nameOfTheFile = scannerFileName.nextLine();

        try(Scanner scanner = new Scanner(CampCleanup.class.getClassLoader().getResourceAsStream(nameOfTheFile))){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                counter += checkForFullyContainedAssignments(line);
            }
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("One range fully contains the other in " + counter + " assignments");
    }

    private static int checkForFullyContainedAssignments(String line){
        int comma = line.indexOf(",");

        ArrayList<Integer> firstElfSection = convertStringToInt(line.substring(0,comma));
        ArrayList<Integer> secondElfSection = convertStringToInt(line.substring(comma + 1));

        int differenceBetweenFirsts = firstElfSection.get(0) - secondElfSection.get(0);
        int differenceBetweenLasts = firstElfSection.get(firstElfSection.size() - 1) - secondElfSection.get(secondElfSection.size() - 1);

        if(differenceBetweenFirsts == 0){
            return 1;
        }
        else if(differenceBetweenFirsts > 0){
            return differenceBetweenLasts <= 0 ? 1 : 0;
        }

        return differenceBetweenLasts >= 0 ? 1 : 0;
    }

    public static ArrayList convertStringToInt(String line){
        int dash = line.indexOf("-");
        int first = Integer.parseInt(line.substring(0,dash));
        int last = Integer.parseInt(line.substring(dash + 1));
        ArrayList<Integer> sections = new ArrayList<Integer>();

        for(int i = first; i <= last; i++){
            sections.add(i);
        }

        return sections;
    }
}
