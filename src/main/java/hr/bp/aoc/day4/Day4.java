package hr.bp.aoc.day4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import hr.bp.aoc.DaySolution;

public class Day4 extends DaySolution {
  public Day4() throws FileNotFoundException, IOException {
    super();
  }

  @Override
  public String getInputFileName() {
    return "section-assignments.txt";
  }

  @Override
  public int getPart1Solution() {
    return getNumberOfFullyContainingPairs();
  }

  @Override
  public int getPart2Solution() {
    return 0;
  }

  private int getNumberOfFullyContainingPairs() {
    int fullyContainingPairs = 0;
    List<SectionAssignmentPair> assignmentPairs = AssignmentsPairsDecoder.decodeAssignemtsPairs(getInputLines());

    for (SectionAssignmentPair assignmentPair : assignmentPairs) {
      SectionAssignment firstAssignment = assignmentPair.getFirstSectionAssignment();
      SectionAssignment secondAssignment = assignmentPair.getSecondSectionAssignment();

      boolean isSupposedToSwap = (firstAssignment.getStartingSectionID() >= secondAssignment.getStartingSectionID() &&
          firstAssignment.getEndingSectionID() <= secondAssignment.getEndingSectionID());
      if (isSupposedToSwap) {
        SectionAssignment temp = firstAssignment;
        firstAssignment = secondAssignment;
        secondAssignment = temp;
      }

      boolean isFirstContainingSecond = (firstAssignment.getStartingSectionID() <= secondAssignment
          .getStartingSectionID() &&
          firstAssignment.getEndingSectionID() >= secondAssignment.getEndingSectionID());
      if (isFirstContainingSecond) {
        fullyContainingPairs++;
      }
    }

    return fullyContainingPairs;
  }
}
