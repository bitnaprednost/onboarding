package com.bp.aoc.day4;

import java.util.List;

/**
 * @author Ivona Pavela
 */


public class CheckAssignments {

    static int checkAssignments(List<String> lines, boolean checkFullyContained) {

        int counter = 0;

        for(String line: lines){
            int comma = line.indexOf(",");

            String[] firstRange = line.substring(0, comma).split("-");
            String[] secondRange = line.substring(comma + 1).split("-");

            int firstStart = Integer.parseInt(firstRange[0]);
            int firstEnd = Integer.parseInt(firstRange[1]);
            int secondStart = Integer.parseInt(secondRange[0]);
            int secondEnd = Integer.parseInt(secondRange[1]);

            if (checkFullyContained) {
                counter += (firstStart >= secondStart && firstEnd <= secondEnd) ||
                        (secondStart >= firstStart && secondEnd <= firstEnd) ? 1 : 0;
            } else {
                counter += (firstEnd >= secondStart && firstStart <= secondEnd) ? 1 : 0;
            }
        }

        return counter;
    }
}
