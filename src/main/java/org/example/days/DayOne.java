package org.example.days;

import org.example.days.model.Elf;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Luka Ljubić
 */
public class DayOne {
    public void executeDay(){

        final String  callorieDataPath = "/home/user/Downloads/LUKA/Java1_Exercise0506/AdventOfCode/src/main/resources/callorieData.txt";
        final List<String> callorieData= new ArrayList<>(readCallorieData(callorieDataPath));
        List<Elf> elvesList = new ArrayList<>();

        calculateAndPushDataIntoList(elvesList, callorieData);
        Elf elfWithTheMostCallories = new Elf();

        elfWithTheMostCallories = getElfWithMostCallories(elvesList);


        Collections.sort(elvesList);

        int firstThreeSum = calculateSum(elvesList, 3);
        elvesList.forEach(elf-> System.out.println(elf.toString()));
        System.out.println(firstThreeSum);

    }

    private int calculateSum(List<Elf> elvesList, int numberOfElves) {
        int sum = 0;
        for (int i = elvesList.size()-1; i > elvesList.size()-(numberOfElves+1); i--){
            sum += elvesList.get(i).getCallorieCount();
        }
        return sum;
    }

    private Elf getElfWithMostCallories(List<Elf> elvesList) {
        Elf elfWithMost = elvesList.get(0);

        for (Elf elf:elvesList) {
            if (elf.getCallorieCount() > elfWithMost.getCallorieCount()){
                elfWithMost = elf;
            }
        }
        return elfWithMost;
    }

    private void calculateAndPushDataIntoList(List<Elf> elvesList, List<String> callorieData) {
        int tempSum = 0;

        for(int i = 0; i< callorieData.size(); i++){
            if(Objects.equals(callorieData.get(i), "")){
                elvesList.add(new Elf(tempSum));
                tempSum = 0;
            }
            else if(i == callorieData.size()-1){
                tempSum += Integer.parseInt(callorieData.get(i));
                elvesList.add(new Elf(tempSum));
            }
            else {
                tempSum += Integer.parseInt(callorieData.get(i));
            }
        }
    }

    private List<String> readCallorieData(String callorieDataPath) {
        List<String> callorieData = new ArrayList<>();
        try {
            callorieData = Files.readAllLines(Paths.get(callorieDataPath));
            System.out.println(callorieData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return callorieData;
    }
}
