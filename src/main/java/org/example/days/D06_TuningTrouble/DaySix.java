package org.example.days.D06_TuningTrouble;

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
        Optional<Integer> positionInString = processBufferData(bufferData, 4);

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
        Optional<Integer> positionInString = processBufferData(bufferData, 14);

        if (positionInString.isPresent()){
            System.out.println(positionInString);
            System.out.println(bufferData.length());
        }
        else {
            System.out.println("Integer je Optional.empty");
        }
    }

    private Optional<Integer> processBufferData(String bufferData, int numberOfCharactersInASequence) {
        int tempPosition = 0;

        List<Character> sequence = new ArrayList<>();

        for (int i = 0; i<bufferData.length(); i++){
            if (i == bufferData.length()-numberOfCharactersInASequence){
                break;
            }
            addToSequence(sequence, i, numberOfCharactersInASequence);

            if(hasNoDuplicates(sequence)){
                tempPosition = i+numberOfCharactersInASequence;
                return Optional.of(tempPosition);
            }
            else{
                sequence.clear();
            }

        }

        return Optional.empty();
    }

    private void addToSequence(List<Character> sequence, int index, int numberOfsequenceCharacters) {
        for(int i = 0; i<numberOfsequenceCharacters; i++){
            sequence.add(bufferData.charAt(index +i));
        }
    }

    private boolean hasNoDuplicates(List<Character> sequence) {
        List<Character> uniqueList = sequence.stream()
                .distinct()
                .collect(Collectors.toList());

        return uniqueList.size() == sequence.size();
    }
}
