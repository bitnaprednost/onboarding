package main.adventofcode.day1;

public class TaskOne {
    public static void main(String[] args) {
        String test = "(())";

        ReadingStrategy strategy = new FloorReadingStrategy();
        SantaDirectionsReader santa = new SantaDirectionsReader(test, strategy);

        int floor = santa.whatFloor();
        System.out.println(floor);
    }
}
