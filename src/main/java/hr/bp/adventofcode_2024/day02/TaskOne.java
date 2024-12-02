package hr.bp.adventofcode_2024.day02;

import static hr.bp.adventofcode_2024.Utils.displayResult;
import static hr.bp.adventofcode_2024.Utils.readInputForDay;

/**
 * @author Ivan Tomičić
 */
public class TaskOne {

    public static void main(String[] args) {
        String input = readInputForDay("day02");

        ReportList reportList = new ReportList(input);

        displayResult(reportList.countSafeReports());
    }
}
