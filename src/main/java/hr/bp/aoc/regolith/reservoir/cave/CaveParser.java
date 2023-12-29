package hr.bp.aoc.regolith.reservoir.cave;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public class CaveParser {

    private CaveParser(){}
    public static CaveBuilder parseLine(CaveBuilder builder, String line) {
        String[] split = line.split(" -> ");
        List<Point> points = new ArrayList<>();

        for(String input : split){
            String[] inputs = input.split(",");
            Point point = new Point(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
            points.add(point);
        }

        return builder.rockRange(points.toArray(Point[]::new));
    }

    public static Cave parseLines(String[] lines, boolean bottomless) {
        CaveBuilder builder = new CaveBuilder(bottomless);
        for(String line : lines){
            parseLine(builder, line);
        }

        return builder.build();
    }
}
