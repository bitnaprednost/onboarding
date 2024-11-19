package hr.bp.aoc.day1;

public class TaskOne {
    public static void main(String[] args) {
        String testFloorDirections = "))(((((";
        String testCalibrationReader = "treb7uchet";

        ReadingStrategy strategyFloors = new FloorReadingStrategy();
        SantaDirectionsReader santa = new SantaDirectionsReader(testFloorDirections, strategyFloors);

        int floor = santa.whatFloor();
        System.out.println("Santa will end up on " + floor + " floor!");

        ReadingStrategy strategyCalibrations = new CalibrationReaderStrategy();
        CalibrationDocumentReader calibrationsReader = new CalibrationDocumentReader(testCalibrationReader,
                strategyCalibrations);

        System.out.println(calibrationsReader.calibration());
    }
}
