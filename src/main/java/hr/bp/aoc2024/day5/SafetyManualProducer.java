package hr.bp.aoc2024.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SafetyManualProducer {
    private List<Page> pages;
    private List<List<Integer>> producingOrders;

    public SafetyManualProducer(HashMap<Integer, List<Integer>> pagesParsed, List<List<Integer>> producingOrders) {
        this.pages = getPagesFromParsed(pagesParsed);
        this.producingOrders = producingOrders;
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
                middlePageSum += getMiddlePage(order);
            }
        }

        return middlePageSum;
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
