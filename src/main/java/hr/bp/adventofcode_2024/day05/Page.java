package hr.bp.adventofcode_2024.day05;

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

    public boolean numbersAreInRightOrder() {
        for (Integer pageNumber : pageNumbers) {
            List<Integer> numbersSucceeding = pageOrderingRules.get(pageNumber);
            if (numbersSucceeding == null) continue;

            for (Integer succeedingNumber : numbersSucceeding) {
                if (pageNumbers.contains(succeedingNumber) && pageNumbers.indexOf(succeedingNumber) < pageNumbers.indexOf(pageNumber)) return false;
            }
        }
        return true;
    }
}
