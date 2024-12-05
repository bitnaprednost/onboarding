package hr.bp.adventofcode_2024.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class Page {

    private List<Integer> pageNumbers;

    private Map<Integer, List<Integer>> pageOrderingRules;

    public Page(List<Integer> pageNumbers, Map<Integer, List<Integer>> pageOrderingRules) {
        this.pageNumbers = pageNumbers;
        this.pageOrderingRules = pageOrderingRules;
    }

    public boolean hasNumbersInRightOrder() {
        for (Integer pageNumber : pageNumbers) {
            List<Integer> numbersSucceeding = pageOrderingRules.get(pageNumber);
            if (numbersSucceeding == null) continue;

            for (Integer succeedingNumber : numbersSucceeding) {
                if (pageNumbers.contains(succeedingNumber) && pageNumbers.indexOf(succeedingNumber) < pageNumbers.indexOf(pageNumber)) return false;
            }
        }
        return true;
    }

    public void orderNumbers() {
        while (!hasNumbersInRightOrder()) pageNumbers.sort(this::pageNumberComparator);
    }


    public int getMiddleNumber() {
        return pageNumbers.get(pageNumbers.size() / 2);
    }

    public int pageNumberComparator(int pageNumberOne, int pageNumberTwo) {

        if (pageOrderingRules.get(pageNumberOne) != null && !pageOrderingRules.get(pageNumberOne).isEmpty()) {
            if (pageOrderingRules.get(pageNumberOne).contains(pageNumberTwo)) return -1;
        } if (pageOrderingRules.get(pageNumberTwo) != null && !pageOrderingRules.get(pageNumberTwo).isEmpty()) {
            if (pageOrderingRules.get(pageNumberTwo).contains(pageNumberOne)) return 1;
        }
        return 0;
    }

    public Page copy() {
        return new Page(new ArrayList<>(this.pageNumbers), this.pageOrderingRules);
    }
}
