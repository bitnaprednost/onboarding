package hr.bp.aoc2024.day2;

import java.util.ArrayList;
import java.util.List;

public class ReportsParser {
    private List<String> input;

    public ReportsParser(List<String> input) {
        this.input = input;
    }

    public List<List<Integer>> parseInput() {
        List<List<Integer>> reports = new ArrayList<>();

        for (String reportString : input) {
            reports.add(getReportFromString(reportString));
        }

        return reports;
    }

    private List<Integer> getReportFromString(String reportString) {
        List<Integer> report = new ArrayList<>();

        for (String s : reportString.split(" ")) {
            report.add(Integer.parseInt(s));
        }

        return report;
    }
}
