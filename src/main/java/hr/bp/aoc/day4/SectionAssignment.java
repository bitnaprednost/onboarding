package hr.bp.aoc.day4;

public class SectionAssignment {
  int startingSectionID;
  int endingSectionID;

  public SectionAssignment(int startingSectionID, int endingSectionID) {
    this.startingSectionID = startingSectionID;
    this.endingSectionID = endingSectionID;
  }

  public int getStartingSectionID() {
    return startingSectionID;
  }

  public int getEndingSectionID() {
    return endingSectionID;
  }
}
