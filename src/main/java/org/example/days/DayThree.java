package org.example.days;

import org.example.days.model.Backpack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayThree {
    public void executeDay(){


        final String backpackDataPath = "/home/user/Downloads/LUKA/Java1_Exercise0506/AdventOfCode/src/main/resources/backpackData.txt";
        List<String> backpackDataList = readBackpackData(backpackDataPath);
        List<Backpack> backpacksList = new ArrayList<>();

        sliceAndCreateCompartments(backpackDataList, backpacksList);


        List<Character> duplicatesInBackpack = findDuplicates(backpacksList);
        int sum = calculateSumOfTheDuplicates(duplicatesInBackpack);

        duplicatesInBackpack.forEach(System.out::println);

        System.out.println(sum);



    }

    private int calculateSumOfTheDuplicates(List<Character> duplicatesInBackpack) {
        int sum = 0;
        for (Character duplicate:duplicatesInBackpack){
            if (Character.isUpperCase(duplicate)){
                sum+=((int)duplicate - 38);
            }
            else{
                sum+=((int)duplicate - 96);
            }
        }
        return sum;
    }

    private ArrayList<Character> findDuplicates(List<Backpack> backpacksList) {
        ArrayList<Character> duplicates = new ArrayList<>();
        for (Backpack backpack:backpacksList){
            String firstCompartmant = backpack.getFirstCompartment();
            String secondCompartmant = backpack.getSecondCompartment();

            for (int i = 0; i<firstCompartmant.length();i++){
                    if (firstCompartmant.contains(Character.toString(secondCompartmant.charAt(i)))){
                        duplicates.add(secondCompartmant.charAt(i));
                        break;
                }
            }
        }
        return duplicates;
    }

    private void sliceAndCreateCompartments(List<String> backpackDataList, List<Backpack> backpacksList) {
        for (String bacpackData:backpackDataList){

            char[] bacpackDataInChar = bacpackData.toCharArray();
            int index = bacpackData.length()/2;

            String firstCompartment = new String(bacpackDataInChar,0, index);
            String secondCompartment = new String(bacpackDataInChar,index, bacpackData.length() - index);

            backpacksList.add(new Backpack(firstCompartment,secondCompartment));

        }
    }

    private List<String> readBackpackData(String backpackDataPath) {
        List<String> backpackDataList = new ArrayList<>();
        try {
            backpackDataList = Files.readAllLines(Paths.get(backpackDataPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return backpackDataList;
    }
}
