package org.example.days.day06;

import org.example.Utility.ParseUtility;
import org.example.days.model.Day;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Luka Ljubić
 */
public class DaySix implements Day {

    String getBufferDataPath = "src/main/resources/bufferData.txt";
    String bufferData = ParseUtility.parseFromPath(getBufferDataPath);

    @Override
    public void executePartOne() {
        Optional<Integer> positionInString = processBufferData(bufferData);

        if (positionInString.isPresent()){
            System.out.println(positionInString);
            System.out.println(bufferData.length());
        }
        else {
            System.out.println("Integer je Optional.empty");
        }
    }

    @Override
    public void executePartTwo() {

    }

    private Optional<Integer> processBufferData(String bufferData) {
        int tempPosition = 0;

        List<Character> sequenceOfFour = new ArrayList<>();

        for (int i = 0; i<bufferData.length(); i++){
            if (i == bufferData.length()-3){
                break;
            }
            sequenceOfFour.add(bufferData.charAt(i));
            sequenceOfFour.add(bufferData.charAt(i+ 1));
            sequenceOfFour.add(bufferData.charAt(i +2));
            sequenceOfFour.add(bufferData.charAt(i +3));

            if(hasNoDuplicates(sequenceOfFour)){
                tempPosition = i+4;
                return Optional.of(tempPosition);
            }
            else{
                sequenceOfFour.clear();
            }

        }

        return Optional.empty();
    }

    private boolean hasNoDuplicates(List<Character> sequenceOfFour) {
        List<Character> uniqueList = sequenceOfFour.stream()
                .distinct()
                .collect(Collectors.toList());

        return uniqueList.size() == sequenceOfFour.size();
    }
}
