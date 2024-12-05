package hr.bp.adventofcode_2024.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class PageProcessor {

    private List<Page> pageUpdates;

    public PageProcessor(String input) {
        String firstPart = input.split("\\n\\n")[0];
        String secondPart = input.split("\\n\\n")[1];

        pageUpdates = new ArrayList<>();
        Map<Integer, List<Integer>> pageOrderingRules = extractPageOrderingRules(firstPart);
        generatePageUpdates(secondPart, pageOrderingRules);
    }

    private Map<Integer, List<Integer>> extractPageOrderingRules(String rulesInput) {
        Map<Integer, List<Integer>> pageOrderingRules = new HashMap<>();
        for (String rule : rulesInput.split("\\n")) {

            Integer firstNumber = Integer.parseInt(rule.split("\\|")[0]);
            Integer secondNumber = Integer.parseInt(rule.split("\\|")[1]);

            pageOrderingRules.computeIfAbsent(firstNumber, k -> new ArrayList<>()).add(secondNumber);
        }

        return pageOrderingRules;
    }

    private void generatePageUpdates(String pageUpdatesInput, Map<Integer, List<Integer>>  pageOrderingRules) {
        for (String pageUpdateInput: pageUpdatesInput.split("\\n")) {
            List<Integer> pagesNumbers = new ArrayList<>(Arrays.stream(pageUpdateInput.split(",")).map(Integer::parseInt).toList());
            this.pageUpdates.add(new Page(pagesNumbers, pageOrderingRules));
        }
    }

    public int calculateSumOfMiddleNumbers() {
        int sum = 0;
        for (Page page : pageUpdates) {
            if (page.hasNumbersInRightOrder()) {
                sum += page.getMiddleNumber();
            }
        }
        return sum;
    }

    public int calculateSumOfMiddleNumbersForUnorderedPages() {
        int sum = 0;
        List<Page> unorderedPages = new ArrayList<>();
        pageUpdates.forEach(page -> {
            if (!page.hasNumbersInRightOrder()) {
                unorderedPages.add(page.copy());
            }
        });
        for (Page page : unorderedPages) {
            page.orderNumbers();
            sum += page.getMiddleNumber();
        }
        return sum;
    }
}
