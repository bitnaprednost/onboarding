package aoc_2024.day5;

import java.util.*;

public class PageOrderingRules {

    public HashMap<Integer, List<Integer>> rules = new HashMap<>();
    public List<List<Integer>> printPages = new ArrayList<>();

    public HashMap<Integer, List<Integer>> getRules() {
        return rules;
    }

    public List<List<Integer>> getPrintPages() {
        return printPages;
    }

    public void orderingRules(String Pages)
    {
        // Split file content into lines
        String[] lines = Pages.split(System.lineSeparator());
        processInputFile (lines);
    }

    public void processInputFile (String[] lines){

        boolean isProcessingSecondPart = false;
        for (String line : lines)
        {
            if (line.isEmpty())
            {
                isProcessingSecondPart = true;
                continue;
            }
            if (isProcessingSecondPart)
            {
                processPages(line);
            }
            else
            {
                processRules(line);
            }
        }
    }

    public void processRules(String line){
        String[] parts = line.split("\\|");
        int key = Integer.parseInt(parts[0].trim());
        int value = Integer.parseInt(parts[1].trim());

        rules.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    public void processPages(String line){
        String[] numbers = line.split(",");
        List<Integer> numberList = new ArrayList<>();
        for (String num : numbers)
        {
            numberList.add(Integer.parseInt(num.trim()));
        }
        printPages.add(numberList);
    }
}
