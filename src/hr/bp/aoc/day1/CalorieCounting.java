package hr.bp.aoc.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class CalorieCounting {
    public static void main(String[] args) {
        String filePath = "src/hr/bp/aoc/day1/inputday1.txt";
        String input = readFile(filePath);
        System.out.println(input);

        int sumCalories = 0;
        int maxCalories = 0;
        ArrayList<Integer> sumGroups = new ArrayList<Integer>();

        for (String s : input.split("\n")) {
            //System.out.println(s);
            //String strCal = s.trim();
            if (s.isBlank()) {
                if (maxCalories < sumCalories) {
                    maxCalories = sumCalories;
                }
                sumGroups.add(sumCalories);
                sumCalories = 0;
            }else{
                try{
                    sumCalories += Integer.parseInt(s);
                }
                catch (NumberFormatException nfe){
                    nfe.printStackTrace();
                }
            }

            }
        sumGroups.add(sumCalories);
        System.out.println("Elf is carrying "+maxCalories+" calories.");

        Collections.sort(sumGroups, Collections.reverseOrder());
        System.out.println("Top three Elves are carrying "+(sumGroups.get(0)+sumGroups.get(1)+sumGroups.get(2))+" calories");
    }
    private static String readFile(String file_path) {

        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return string;
    }

}