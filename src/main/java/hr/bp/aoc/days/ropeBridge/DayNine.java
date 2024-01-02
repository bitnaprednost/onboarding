package hr.bp.aoc.days.ropeBridge;

import hr.bp.aoc.days.calorieCounting.DayOne;
import hr.bp.aoc.model.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DayNine implements Day {
    public static final Logger logger = LoggerFactory.getLogger(DayNine.class);
    List<Move> moves;
    Knot head;


    @Override
    public void executePartOne() {

        init();

        logger.info("ropeBridge PART 1: {}", nth(head, 1).history.stream().distinct().count());

    }

    @Override
    public void executePartTwo() {

        init();
        logger.info("ropeBridge PART 2: {}", nth(head, 9).history.stream().distinct().count());
    }

    @Override
    public String getDayOrderNumber() {
        return "Day Nine";
    }

    private void init() {
        try {
            moves = parseMoves(Files.readString(Path.of("src/main/resources/ropeBridgeData.txt")));
        } catch (IOException e) {
            logger.error("The initial method cant read String from path");
        }
        head = tieKnots(10);
        head = runMoves(moves, head);
    }

    Knot nth(Knot k, int count) {
        return count == 0 ? k : nth(k.tail, count - 1);
    }

    Knot runMoves(List<Move> moves, Knot head) {
        return moves.stream().reduce(head, (k, m) -> k.apply(m), (a, b) -> {
            return a;
        });
    }

    Knot tieKnots(int count) {
        return new Knot(new XY(0, 0), Set.of(new XY(0, 0)), count > 1 ? tieKnots(count - 1) : null);
    }

    List<Move> parseMoves(String input) {
        return input.lines()
                .map(l -> new Move(vector.get(l.charAt(0)), Integer.parseInt(l.substring(2))))
                .toList();
    }

    record Knot(XY pos, Set<XY> history, Knot tail) {
        Knot apply(Move m) {
            return IntStream.range(0, m.steps).mapToObj(i -> m)
                    .reduce(this, (k, move) -> k.move(move.vector), (a, b) -> {
                        return a;
                    });
        }

        Knot move(XY vector) {
            XY newPos = pos.move(vector);
            Set<XY> newHistory = Stream.concat(history.stream(), Stream.of(newPos)).collect(Collectors.toSet());
            return new Knot(newPos, newHistory, tail != null ? tail.follow(newPos) : null);
        }

        Knot follow(XY head) {
            if (head.touching(pos)) {
                return this;
            }
            int dx = (head.x - pos.x) / 2 + (head.x - pos.x) % 2;
            int dy = (head.y - pos.y) / 2 + (head.y - pos.y) % 2;
            return move(new XY(dx, dy));
        }
    }

    record Move(XY vector, int steps) {
    }

    record XY(int x, int y) {
        XY move(XY vector) {
            return new XY(x + vector.x, y + vector.y);
        }

        boolean touching(XY o) {
            return Math.abs(x - o.x) <= 1 && Math.abs(y - o.y) <= 1;
        }
    }

    Map<Character, XY> vector = Map.of(
            'U', new XY(0, -1), 'D', new XY(0, +1),
            'L', new XY(-1, 0), 'R', new XY(+1, 0));
}
