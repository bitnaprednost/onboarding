package hr.bp.adventofcode_2024.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class ReportList {

    private final List<Report> reports = new ArrayList<>();

    public ReportList(String input) {
        parseInput(input);
    }

    private void parseInput(String input) {
        for (String line : input.split("\\n")) {
            Report report = new Report(Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).boxed().toList());
            reports.add(report);
        }
    }

    public int countSafeReports() {
        int count = 0;
        for (Report report : reports) {
            count += report.isSafe() ? 1: 0;
        }
        return count;
    }
}
