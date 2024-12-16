package hr.bp.aoc2024.day5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SafetyManualProducer {
    private static Logger log = LoggerFactory.getLogger(SafetyManualProducer.class);

    private List<Page> pages;
    private List<ArrayList<Integer>> producingOrders;

    public SafetyManualProducer(HashMap<Integer, List<Integer>> pagesParsed, List<ArrayList<Integer>> producingOrders) {
        this.pages = getPagesFromParsed(pagesParsed);
        this.producingOrders = producingOrders;
    }

    private static void moveIfCurrPageBrokeRule(Page currPage, ArrayList<Integer> correctOrder, int index) {
        if (currPage != null && !currPage.isPagePrintedInRightOrder(correctOrder.subList(index + 1,
                correctOrder.size()))) {

            int brokenRulePage = currPage.findBrokenRule(correctOrder.subList(index + 1, correctOrder.size()));
            int brokenRulePageIndex = correctOrder.indexOf(brokenRulePage);

            boolean didPageBreakRule = brokenRulePage != -1;
            if (didPageBreakRule) {
                correctOrder.set(index, brokenRulePage);
                correctOrder.set(brokenRulePageIndex, currPage.getPageNumber());
            }
        }
    }

    private List<Page> getPagesFromParsed(HashMap<Integer, List<Integer>> pagesParsed) {
        List<Page> pages = new ArrayList<>();

        for (int page : pagesParsed.keySet()) {
            pages.add(new Page(page, pagesParsed.get(page)));
        }

        return pages;
    }

    public long getMiddlePageSum() {
        long middlePageSum = 0;

        for (List<Integer> order : producingOrders) {
            if (isInCorrectOrder(order)) {

                log.debug("Production order correct {}", order);

                middlePageSum += getMiddlePage(order);
            }
        }

        return middlePageSum;
    }

    public long getMiddlePageSumIncorrectOrder() {
        long middlePageSum = 0;

        for (ArrayList<Integer> order : producingOrders) {
            if (!isInCorrectOrder(order)) {

                log.debug("Production order incorrect {}", order);

                ArrayList<Integer> correctOrder = putInCorrectOrder(order);

                log.debug("Production order correct {}", correctOrder);

                middlePageSum += getMiddlePage(correctOrder);
            }
        }

        return middlePageSum;
    }

    private ArrayList<Integer> putInCorrectOrder(ArrayList<Integer> order) {
        ArrayList<Integer> correctOrder = (ArrayList<Integer>) order.clone();

        do {
            for (int index = 0; index < order.size() - 1; index++) {
                Page currPage = getCurrentPage(correctOrder.get(index));

                moveIfCurrPageBrokeRule(currPage, correctOrder, index);

            }
        } while (!isInCorrectOrder(correctOrder));

        return correctOrder;
    }

    private boolean isInCorrectOrder(List<Integer> order) {

        for (int index = 0; index < order.size() - 1; index++) {
            Page currPage = getCurrentPage(order.get(index));
            if (currPage != null && !currPage.isPagePrintedInRightOrder(order.subList(index + 1, order.size()))) {
                return false;
            }
        }
        return true;

    }

    private Page getCurrentPage(int pageNumber) {
        for (Page page : pages) {
            if (page.getPageNumber() == pageNumber)
                return page;
        }

        return null;
    }

    private long getMiddlePage(List<Integer> order) {
        int middleIndex = order.size() / 2;
        return order.get(middleIndex);
    }

}
