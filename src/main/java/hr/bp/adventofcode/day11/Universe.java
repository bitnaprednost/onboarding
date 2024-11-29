package hr.bp.adventofcode.day11;

/**
 * @author Ivan Tomičić
 */
public class Universe {

    private char[][] image;

    public Universe(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input cannot be null or blank");
        }
        parseImage(input);
    }

    private void parseImage(String input) {
        String[] lines = input.split("\\n");
        image = new char[lines.length][];

        for (int i = 0; i < image.length; i++) {
            image[i] = lines[i].toCharArray();
        }
    }

    public char[][] getImage() {
        return image;
    }
}
