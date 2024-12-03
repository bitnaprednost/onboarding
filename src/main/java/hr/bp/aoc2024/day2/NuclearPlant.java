package hr.bp.aoc2024.day2;

import java.util.ArrayList;
import java.util.List;

public class NuclearPlant {
    private List<Report> reports;
    private boolean testDampner;

    public NuclearPlant(List<List<Integer>> reportsInput) {
        this(reportsInput, false);
    }

    public NuclearPlant(List<List<Integer>> reportsInput, boolean testDampner) {
        this.testDampner = testDampner;
        this.reports = getReports(reportsInput);
    }

    private List<Report> getReports(List<List<Integer>> reportsInput) {
        List<Report> reports = new ArrayList<>();

        for (List<Integer> report : reportsInput) {
            reports.add(new Report(report, testDampner));
        }

        return reports;
    }

    public long getNumOfSafeReports() {
        return reports.stream().filter(report -> report.isSafe).count();
    }
}
