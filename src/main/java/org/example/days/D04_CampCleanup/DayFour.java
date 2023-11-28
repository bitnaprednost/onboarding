package org.example.days.D04_CampCleanup;

import org.example.days.D04_CampCleanup.model.Pair;
import org.example.days.model.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class DayFour implements Day {

    String pairsDataPath = "src/main/resources/PairsAndTheirRange.txt";
    List<String> pairsDataList = readPairsToList(pairsDataPath);
    List<Pair> pairList = new ArrayList<>(stringListToPairList(pairsDataList));


    @Override
    public void executePartOne() {
        int fullyContainCounter = countRangesThatFullyContainTheOther();
        System.out.println(fullyContainCounter);
    }
    @Override
    public void executePartTwo() {
        int overlapingCounter = coutRangesThatOverlap();
        System.out.println(overlapingCounter);
    }

    private int coutRangesThatOverlap() {
        int counter = 0;
        for (Pair pair : pairList){
            if (pair.rangeOverlap()){
                counter++;
            }
        }
        return counter;
    }


    private int countRangesThatFullyContainTheOther() {
        int counter = 0;
        for (Pair pair: pairList){
            if (pair.rangeFullyContainOther()){
                counter++;
            }
        }
        return counter;
    }


    private List<String> readPairsToList(String pairsDataPath) {
        List<String> pairsDataList;
        try {
            pairsDataList = Files.readAllLines(Paths.get(pairsDataPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pairsDataList;
    }
    private List<Pair> stringListToPairList(List<String> pairsDataList) {
        List<Pair> pairs = new ArrayList<>();
        pairsDataList.forEach(pair -> pairs.add(new Pair(pair)));
        return pairs;
    }
}
