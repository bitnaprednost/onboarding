package hr.bp.aoc.day4;

import java.util.ArrayList;
import java.util.List;

public class AssignmentsPairsDecoder {
  public static List<SectionAssignmentPair> decodeAssignemtsPairs(List<String> pairs) {
    List<SectionAssignmentPair> decodedAssignments = new ArrayList<>();

    for (String pair : pairs) {
      String firstEncodedAssignment = pair.split(",")[0];
      String secondEncodedAssignment = pair.split(",")[1];

      SectionAssignment firstSectionAssignmet = AssignmentsPairsDecoder.getSectionAssignment(firstEncodedAssignment);
      SectionAssignment secondSectionAssignment = AssignmentsPairsDecoder.getSectionAssignment(secondEncodedAssignment);

      decodedAssignments.add(new SectionAssignmentPair(firstSectionAssignmet, secondSectionAssignment));
    }

    return decodedAssignments;
  }

  private static SectionAssignment getSectionAssignment(String assignment) {
    int startingSectionID = Integer.parseInt(assignment.split("-")[0]);
    int endingSectionID = Integer.parseInt(assignment.split("-")[1]);

    return new SectionAssignment(startingSectionID, endingSectionID);
  }
}
