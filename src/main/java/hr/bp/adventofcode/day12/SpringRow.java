package hr.bp.adventofcode.day12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Ivan Tomičić
 */
public class SpringRow {

    private Long differentArrangements;

    private final List<Character> springs;

    private final List<Integer> contiguousGroups;

    private List<Integer> differentArrangementsCalculated;

    public SpringRow(List<Character> springs, List<Integer> contiguousGroups) {
        this.springs = springs;
        this.contiguousGroups = contiguousGroups;
        setDifferentArrangements(springs, contiguousGroups);
    }

    private void setDifferentArrangements(List<Character> springs, List<Integer> contiguousGroups) {
        differentArrangementsCalculated = new ArrayList<>(Collections.nCopies(contiguousGroups.size(), 0));
        this.differentArrangements = calculateDifferentArrangementsForSetup(new ArrayList<>(springs), new ArrayList<>(contiguousGroups));
        //this.differentArrangements = differentArrangementsCalculated.stream().reduce(1L, (a, b) -> a * b, (a, b) -> a * b);
    }

    private long calculateDifferentArrangementsForSetup(List<Character> springs, List<Integer> contiguousGroups) {
        // ako nisi jedini element zauzmi sebe najlijevije moguce, a pozovi rekurzivno sa contgroup(+1, end), a
        // inace izracunaj koliko puta mozes i to vrati
        // ponavljaj u petlji tako da na startIndex dodas 1, pazi na to da provjeris da li uopce mozes staviti na startIndex,
        //      npr. ?###???????? 3,2,1   ne moze uopce ista na nulti index premda je sve ?#
        int startIndex = 0;
        int groupSize = contiguousGroups.getFirst();
        long sum = 0;
        if (contiguousGroups.size() == 1) {
            sum += getPossibleArrangementsForOneGroup(springs, groupSize);
        } else {
            List<Character> springsSublist = getSpringsSublist();
            List<Integer> groupSublist =  new ArrayList<>(contiguousGroups.subList(1, contiguousGroups.size()));
            sum += calculateDifferentArrangementsForSetup(springsSublist, groupSublist);
        }

        return  sum;  // ovo sa sum je ovako ok, samo ces u petlji morati jos ici, znaci cilj je da ovaj zadnji element
                        // bude jedini koji zapravo vraca neku vrijednost, nema mnozenja, samo zbroj

    }

    private List<Character> getSpringsSublist(List<Character> springs, Integer groupSize, Integer startIndex) {
        // TODO: ovo popravi jer nije tako trivijalno
        return new ArrayList<>(springs.subList(startIndex + groupSize + 1, springs.size()));
    }

    private long getPossibleArrangementsForOneGroup(List<Character> springs, Integer groupSize) {
        int count = 0;
        for (int i = 0; i <= springs.size() - groupSize; i++) {
            if (springs.subList(i, i + groupSize).stream().allMatch(ch -> ch == '?' || ch == '#')) {
                count++;
            }
        }
        return count;
    }

    private boolean makesSenseToContinue(int startIndex, List<Character> springs, List<Integer> contiguousGroups) {
        boolean startIndexSmallerThanSpringsSize = startIndex < springs.size();
        boolean groupsCanFit = contiguousGroups.stream().reduce(0, Integer::sum, Integer::sum) <= springs.size() - startIndex;
        return startIndexSmallerThanSpringsSize && groupsCanFit;
    }

    private boolean canFitSublistIntoGroup(List<Character> springs) {
        return springs.stream().allMatch(ch -> ch == '?' || ch == '#');

    }

    public long getDifferentArrangements() {
        return differentArrangements;
    }
}
