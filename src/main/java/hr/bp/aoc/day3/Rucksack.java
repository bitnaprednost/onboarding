package hr.bp.aoc.day3;

public class Rucksack extends BasePriorityCounter{
    private final String firstCompartment;
    private final String secondCompartment;

    public Rucksack(String line) {
        this.firstCompartment = line.substring(0, line.length() / 2);
        this.secondCompartment = line.substring(line.length() / 2);
    }

    protected char getCommonChar() {
        for (int i = 0; i < firstCompartment.length(); i++) {
            for (int j = 0; j < secondCompartment.length(); j++) {
                if (firstCompartment.charAt(i) == secondCompartment.charAt(j)) {
                    return firstCompartment.charAt(i);
                }
            }
        }
        return ' ';
    }

    public String getAllItem() {
        return firstCompartment + secondCompartment;
    }

}
