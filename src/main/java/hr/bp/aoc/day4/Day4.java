package hr.bp.aoc.day4;

import java.io.IOException;
import java.util.List;
import java.util.function.BiPredicate;

import hr.bp.aoc.DaySolution;
import hr.bp.aoc.utils.Pair;

public class Day4 extends DaySolution<Integer, Integer> {
  public Day4() throws IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "section-assignments.txt";
  }

  @Override
  public Integer getPart1Solution() {
    return getNumberOfPredicateMatchingPairs(new FullyContainingPairsPredicate());
  }

  @Override
  public Integer getPart2Solution() {
    return getNumberOfPredicateMatchingPairs(new PartialyContainingPairsPredicate());
  }

  private int getNumberOfPredicateMatchingPairs(BiPredicate<SectionAssignment, SectionAssignment> overlapingCondition) {
    int matchingPairs = 0;
    List<Pair<SectionAssignment>> assignmentPairs = AssignmentsPairsDecoder.decodeAssignemtsPairs(getInputLines());

    for (Pair<SectionAssignment> assignmentPair : assignmentPairs) {
      SectionAssignment firstAssignment = assignmentPair.getFirstPair();
      SectionAssignment secondAssignment = assignmentPair.getSecondPair();

      if (overlapingCondition.test(firstAssignment, secondAssignment))
        matchingPairs++;
    }

    return matchingPairs;
  }

  private class FullyContainingPairsPredicate
      implements BiPredicate<SectionAssignment, SectionAssignment> {

    @Override
    public boolean test(SectionAssignment firstAssignment, SectionAssignment secondAssignment) {
      boolean isSecondAssigmentBigger = (firstAssignment.getSize() - secondAssignment.getSize() < 0);

      if (isSecondAssigmentBigger) {
        SectionAssignment temp = firstAssignment;
        firstAssignment = secondAssignment;
        secondAssignment = temp;
      }

      return (firstAssignment.getStartingSectionID() <= secondAssignment
          .getStartingSectionID() &&
          firstAssignment.getEndingSectionID() >= secondAssignment.getEndingSectionID());
    };
  }

  private class PartialyContainingPairsPredicate
      implements BiPredicate<SectionAssignment, SectionAssignment> {

    @Override
    public boolean test(SectionAssignment firstAssignment, SectionAssignment secondAssignment) {
      boolean firstContainsSecond = ((firstAssignment.getEndingSectionID() >= secondAssignment.getStartingSectionID())
          &&
          (firstAssignment.getStartingSectionID() <= secondAssignment.getStartingSectionID()));

      boolean secondContainsFirst = ((secondAssignment.getEndingSectionID() >= firstAssignment.getStartingSectionID())
          &&
          (secondAssignment.getStartingSectionID() <= firstAssignment.getStartingSectionID()));

      return firstContainsSecond || secondContainsFirst;
    };
  }
}
