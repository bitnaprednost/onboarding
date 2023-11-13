package day1;

import java.util.*;
import java.util.stream.Collectors;

public class ElfManager {

    public Elf createElf(String calorie) {
        if(calorie==null) return null;
        calorie=calorie.replaceAll("[^\\d-\\n]", "");
        if(calorie.isEmpty()) return null;

        int[] calories = Arrays.stream(calorie.split("\n")).mapToInt(Integer::parseInt).toArray();
        return new Elf(calories);
    }

    public List<Elf> createElves(String calories) {
        String[] split = calories.split("\n\n");
        List<Elf> elves = new ArrayList<>();

        for(String calorie:split){
            elves.add(createElf(calorie));
        }
        return elves;
    }

    public List<Elf> getElfMostCalories(List<Elf> elves, int N) {
        List<Elf> max = elves.stream().sorted(Comparator.comparing(Elf::getCalories).reversed()).limit(N).collect(Collectors.toList());
        return max;
    }

    public Elf getElfMostCalories(List<Elf> elves) {
        return getElfMostCalories(elves, 1).iterator().next();
    }

    public int sumCalories(List<Elf> topElves) {
        return topElves.stream().mapToInt(Elf::getCalories).sum();
    }
}
