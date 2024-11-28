package hr.bp.adventofcode.day10;

/**
 * @author Ivan Tomičić
 */
public class TestUtils {

    public static String getFirstInput() {
        return """
            ..F7.
            .FJ|.
            SJ.L7
            |F--J
            LJ...""";
    }

    public static GridElement[][] getFirstInputGrid() {
        return new GridElement[][] {
                new GridElement[] {GridElement.GROUND, GridElement.GROUND, GridElement.SOUTH_EAST, GridElement.SOUTH_WEST, GridElement.GROUND},
                new GridElement[] {GridElement.GROUND, GridElement.SOUTH_EAST, GridElement.NORTH_WEST, GridElement.NORTH_SOUTH, GridElement.GROUND},
                new GridElement[] {GridElement.STARTING_POSITION, GridElement.NORTH_WEST, GridElement.GROUND, GridElement.NORTH_EAST, GridElement.SOUTH_WEST},
                new GridElement[] {GridElement.NORTH_SOUTH, GridElement.SOUTH_EAST, GridElement.EAST_WEST, GridElement.EAST_WEST, GridElement.NORTH_WEST},
                new GridElement[] {GridElement.NORTH_EAST, GridElement.NORTH_WEST, GridElement.GROUND, GridElement.GROUND, GridElement.GROUND}
        };
    }

    public static String getSecondInput() {
        return """
            .....
            .S-7.
            .|.|.
            .L-J.
            .....""";
    }

    public static String getThirdInput() {
        return """
            ...........
            .S-------7.
            .|F-----7|.
            .||.....||.
            .||.....||.
            .|L-7.F-J|.
            .|..|.|..|.
            .L--J.L--J.
            ...........""";
    }

    public static String getFourthInput() {
        return """
            .F----7F7F7F7F-7....
            .|F--7||||||||FJ....
            .||.FJ||||||||L7....
            FJL7L7LJLJ||LJ.L-7..
            L--J.L7...LJS7F-7L7.
            ....F-J..F7FJ|L7L7L7
            ....L7.F7||L7|.L7L7|
            .....|FJLJ|FJ|F7|.LJ
            ....FJL-7.||.||||...
            ....L---J.LJ.LJLJ...""";
    }

}
