package hr.bitnaPrednost.calorieCounting;

import java.util.*;
import java.util.stream.Collectors;

public class ElfManager {

    private static String filterOutFormat(String calorie) {
        if(calorie == null) throw new NullPointerException("String input is null.");
        calorie = calorie.replaceAll("[^\\d-\\n]", "");
        if(calorie.isEmpty()) throw new NoSuchElementException("Input is empty after filtering.");
        return calorie;
    }

    public static Elf createElf(String calorie) {
        calorie = filterOutFormat(calorie);

        ElfBuilder elfBuilder = new ElfBuilder();
        Arrays.stream(calorie.split("\n")).mapToInt(Integer::parseInt).forEach(elfBuilder::append);
        return elfBuilder.build();
    }

    public static List<Elf> createElves(String calories) {
        String[] split = calories.split("\n\n");

        List<Elf> elves = new ArrayList<>();
        for(String calorieString : split){
            elves.add(createElf(calorieString));
        }

        return elves;
    }

    public static List<Elf> getElfMostCalories(List<Elf> elves, int N) {
        return elves.stream().sorted(Comparator.comparing(Elf::getCalories).reversed()).limit(N).collect(Collectors.toList());
    }

    public static Elf getElfMostCalories(List<Elf> elves) {
        return getElfMostCalories(elves, 1).iterator().next();
    }

    public static int sumCalories(List<Elf> topElves) {
        return topElves.stream().mapToInt(Elf::getCalories).sum();
    }
}
