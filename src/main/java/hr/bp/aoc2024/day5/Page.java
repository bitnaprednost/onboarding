package hr.bp.aoc2024.day5;

import java.util.List;

public class Page {
    private int pageNumber;
    private List<Integer> orderingRules;

    public Page(int pageNumber, List<Integer> orderingRules) {
        this.pageNumber = pageNumber;
        this.orderingRules = orderingRules;
    }

    public boolean isPagePrintedInRightOrder(List<Integer> pagesToBePrintedAfter) {
        for (int page : pagesToBePrintedAfter) {
            if (orderingRules.contains(page))
                return false;
        }

        return true;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}


