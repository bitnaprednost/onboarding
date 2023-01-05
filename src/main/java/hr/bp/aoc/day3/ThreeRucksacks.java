package hr.bp.aoc.day3;

public class ThreeRucksacks extends BasePriorityCounter {

    private final Rucksack rucksackOne;
    private final Rucksack rucksackTwo;
    private final Rucksack rucksackThree;

    public ThreeRucksacks(String lineOne, String lineTwo, String lineThree) {
        this.rucksackOne = new Rucksack(lineOne);
        this.rucksackTwo = new Rucksack(lineTwo);
        this.rucksackThree = new Rucksack(lineThree);
    }

    protected char getCommonChar() {
        String[] contents = {
                rucksackOne.getAllItem(),
                rucksackTwo.getAllItem(),
                rucksackThree.getAllItem()
        };

        for (int i = 0; i < contents[0].length(); i++) {
            String letter = contents[0].charAt(i) + "";
            if ((contents[1].contains(letter)) && (contents[2].contains(letter))) {
                return letter.charAt(0);
            }
        }
        return ' ';
    }
}
