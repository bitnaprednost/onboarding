package hr.bp.aoc.day4;

public class SectionAssignmentPair {
  private SectionAssignment firstSectionAssignment;
  private SectionAssignment secondSectionAssignment;

  public SectionAssignmentPair(
      SectionAssignment firstSectionAssignment, SectionAssignment secondSectionAssignment) {
    this.firstSectionAssignment = firstSectionAssignment;
    this.secondSectionAssignment = secondSectionAssignment;
  }

  public SectionAssignment getFirstSectionAssignment() {
    return firstSectionAssignment;
  }

  public SectionAssignment getSecondSectionAssignment() {
    return secondSectionAssignment;
  }
}
