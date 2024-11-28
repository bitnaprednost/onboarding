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



}
