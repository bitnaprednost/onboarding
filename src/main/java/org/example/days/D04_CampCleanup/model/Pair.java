package org.example.days.D04_CampCleanup.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public final class Pair {
    private List<Integer> firstRange;
    private List<Integer> secondRange;

    private final String range;


    public Pair(String range) {
        this.range = range;
        sliceRangeToFirstAndSecondRange();
    }

    private void sliceRangeToFirstAndSecondRange(){
        //2-4,6-8

        String[] ranges = range.split(",");
        //2-4
        //6-8
        firstRange= stringToRange(ranges[0]);
        secondRange= stringToRange(ranges[1]);
    }
    public boolean rangeFullyContainOther(){
        return firstRange.containsAll(secondRange) || secondRange.containsAll(firstRange);
    }
    public boolean rangeOverlap(){
        return firstRange.stream()
                .anyMatch(secondRange::contains);
    }

    private List<Integer> stringToRange(String range) {
        List<Integer> list = new ArrayList<>();
        String[] numbers = range.split("-");

        int begin = Integer.parseInt(numbers[0]);
        int end = Integer.parseInt(numbers[1]);
        for (int i = begin; i<=end; i++){
            list.add(i);
        }
        return list;
    }


    @Override
    public String toString() {
        return "Pair{" +
                "firstRange=" + firstRange +
                ", secondRange=" + secondRange +
                ", range='" + range + '\'' +
                '}';
    }


}
