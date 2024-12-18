package aoc_2024.day13;

public class ClawMachine {
    private PointLong A;
    private PointLong B;
    private PointLong prizeLocation;

    public ClawMachine() {
        A = new PointLong();
        B = new PointLong();
        prizeLocation = new PointLong();
    }

    public long getMinToken(String fileContent){

        long totalToken = 0;

        // Process the file content
        String[] entries = fileContent.split("\n\n");

        for (String s : entries) {
            String entry = s.trim();
            String[] lines = entry.split("\n");
            getA(lines);
            getB(lines);
            getPrizeLocation(lines);

            long token = calculateToken();
            totalToken += token;
        }
        return totalToken;
    }

    public long getMinTokenUnitConversion(String fileContent){

        long totalToken = 0;

        // Process the file content
        String[] entries = fileContent.split("\n\n");

        for (String s : entries) {
            String entry = s.trim();
            String[] lines = entry.split("\n");
            getA(lines);
            getB(lines);
            getPrizeLocationUnitConversion(lines);

            long token = calculateToken();
            totalToken += token;
        }
        return totalToken;
    }

    private void getA(String[] lines){
        String[] buttonA = lines[0].split(":")[1].trim().split(",");
        A.x = Long.parseLong(buttonA[0].replace("X+", "").trim());
        A.y = Long.parseLong(buttonA[1].replace("Y+", "").trim());
    }

    private void getB(String[] lines){
        String[] buttonB = lines[1].split(":")[1].trim().split(",");
        B.x = Long.parseLong(buttonB[0].replace("X+", "").trim());
        B.y = Long.parseLong(buttonB[1].replace("Y+", "").trim());
    }

    private void getPrizeLocation(String[] lines){
        String[] prize = lines[2].split(":")[1].trim().split(",");
        prizeLocation.x = Integer.parseInt(prize[0].replace("X=", "").trim());
        prizeLocation.y = Integer.parseInt(prize[1].replace("Y=", "").trim());
    }

    private void getPrizeLocationUnitConversion(String[] lines){
        String[] prize = lines[2].split(":")[1].trim().split(",");
        prizeLocation.x = Long.parseLong(prize[0].replace("X=", "").trim()) + 10000000000000L;
        prizeLocation.y = Long.parseLong(prize[1].replace("Y=", "").trim()) + 10000000000000L;
    }

    private long calculateToken(){
        long token;

        // Calculate the determinant (denominator for Cramer's rule)
        long determinant = A.x * B.y - A.y * B.x;

        if (determinant != 0) {
            if ((prizeLocation.x * B.y - prizeLocation.y * B.x) % determinant == 0 &&
                    (A.x * prizeLocation.y - A.y * prizeLocation.x) % determinant == 0) {

                // Calculate At and Bt using Cramer's rule
                long At = (prizeLocation.x * B.y - prizeLocation.y * B.x) / determinant;
                long Bt = (A.x * prizeLocation.y - A.y * prizeLocation.x) / determinant;

                token = 3 * At + Bt;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
        return token;
    }
}