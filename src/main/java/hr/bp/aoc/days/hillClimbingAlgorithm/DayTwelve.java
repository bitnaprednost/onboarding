package hr.bp.aoc.days.hillClimbingAlgorithm;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DayTwelve implements Day {

    public static final Logger logger = LoggerFactory.getLogger(DayTwelve.class);

    Map<XY, Byte> map;
    XY start;
    XY end;

    {
        try {
            init();
        } catch (IOException e) {
            logger.error("Initial method broke down");
        }
    }

    @Override
    public void executePartOne() {
        logger.info("hillClimbingAlgorithm PART 1: {}", shortestPath(map, new HashMap<>(), start, dh -> dh <= 1, p -> p.equals(end)));
    }

    @Override
    public void executePartTwo() {
        logger.info("hillClimbingAlgorithm PART 1: {}",shortestPath(map, new HashMap<>(), end, dh -> dh >= -1, p -> map.get(p) == 'a') );
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Twelve";
    }

    private void init() throws IOException {
        map = readMap(Files.readString(Path.of("src/main/resources/hillClimbingAlgorithm.txt")));
        start = map.keySet().stream().filter(k -> map.get(k) == 'S').findFirst().get();
        end = map.keySet().stream().filter(k -> map.get(k) == 'E').findFirst().get();
        map.put(start, (byte) 'a');
        map.put(end, (byte) 'z');
    }

    int shortestPath(Map<XY, Byte> map, Map<XY, Integer> visits, XY start,
                     Function<Byte, Boolean> ok, Function<XY, Boolean> target) {
        HashMap<XY, Integer> visited = new HashMap<XY, Integer>();
        LinkedList<Visit> toVisit = new LinkedList<Visit>();
        toVisit.add(new Visit(start, 0));
        while (!toVisit.isEmpty()) {
            Visit c = toVisit.removeFirst();
            if (!visited.containsKey(c.xy) || visited.get(c.xy) > c.distance) { // not visited or longer distance
                visited.put(c.xy, c.distance); // visit
                moves.stream().map(m -> c.move(m)) // next location
                        .filter(n -> map.containsKey(n.xy)) // is inside map
                        .filter(n -> ok.apply((byte) (map.get(n.xy) - map.get(c.xy)))) // ok to climb
                        .forEach(n -> toVisit.add(n));  // add to visit list
            }
        }

        return visited.keySet().stream()
                .filter(p -> target.apply(p)) // match or target
                .map(p -> visited.get(p)) // map to distance
                .sorted().findFirst().get(); // get minimum
    }

    Map<XY, Byte> readMap(String input) {
        Map<XY, Byte> map = new HashMap<>();
        var lines = input.lines().toList();
        for (int y = 0; y < lines.size(); y++) {
            for (int x = 0; x < lines.get(y).length(); x++) {
                map.put(new XY(x, y), (byte) lines.get(y).charAt(x));
            }
        }
        return map;
    }

    record Visit(XY xy, int distance) {
        Visit move(XY v) {
            return new Visit(new XY(xy.x + v.x, xy.y + v.y), distance + 1);
        }
    }

    record XY(int x, int y) {
    }

    static List<XY> moves = List.of(new XY(1, 0), new XY(-1, 0), new XY(0, 1), new XY(0, -1));
}
