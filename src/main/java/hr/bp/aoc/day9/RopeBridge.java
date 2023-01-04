package hr.bp.aoc.day9;

import hr.bp.aoc.InputUtil;

import java.util.*;

public class RopeBridge {
    private static final Map<String, Position> direction = new HashMap<>();

    public static void main(String[] args) {
        direction.put("R", new Position(1, 0));
        direction.put("L", new Position(-1, 0));
        direction.put("U", new Position(0, 1));
        direction.put("D", new Position(0, -1));

        String filePath = "src/hr/bp/aoc/day9/inputday9.txt";
        List<String> moves = new ArrayList<>(Arrays.asList(InputUtil.readLines(filePath)));

        List<Position> tailPositionsPartOne = new LinkedList<>();
        tailPositionsPartOne.add(new Position(0, 0));

        List<Position> tailPositionsPartTwo = new LinkedList<>();
        tailPositionsPartTwo.add(new Position(0, 0));

        updatePositions(moves, tailPositionsPartOne, tailPositionsPartTwo);

        printNumberOfDistinctPositions(tailPositionsPartOne);
        printNumberOfDistinctPositions(tailPositionsPartTwo);
    }

    private static void updatePositions(List<String> moves, List<Position> tailPositionsPartOne, List<Position> tailPositionPartTwo) {
        Position head = new Position(0, 0);
        int[][] knots = new int[10][2];
        for (String s : moves) {
            String[] move = s.split(" ");
            String dir = move[0];
            int numOfSteps = Integer.parseInt(move[1]);
            Position step = new Position(direction.get(dir).getX(), direction.get(dir).getY());
            move(tailPositionsPartOne, head, numOfSteps, step);
            updateKnotsPositions(tailPositionPartTwo, knots, step, numOfSteps);
        }
    }

    private static void move(List<Position> tailPositions, Position head, int numOfSteps, Position step) {
        for (int j = 0; j < numOfSteps; j++) {
            head.updatePosition(step.getX(), step.getY());
            Position tail = tailPositions.get(tailPositions.size() - 1);
            Position newTailPosition = tailPositions.get(tailPositions.size() - 1);
            if (!isTouching(head, tail)) {
                int pomakX = calculateStep(head.getX(), tail.getX());
                int pomakY = calculateStep(head.getY(), tail.getY());
                newTailPosition = new Position(tail.getX() + pomakX, tail.getY() + pomakY);
            }
            tailPositions.add(newTailPosition);
        }
    }

    private static void updateKnotsPositions(List<Position> tailPositionPartTwo, int[][] knots, Position step, int numOfSteps) {
        for (int j = 0; j < numOfSteps; j++) {
            knots[0][0] += step.getX();
            knots[0][1] += step.getY();
            for (int i = 1; i <= 9; i++) {
                Position head = new Position(knots[i - 1][0], knots[i - 1][1]);
                Position tail = new Position(knots[i][0], knots[i][1]);
                Position newTail = new Position(knots[i][0], knots[i][1]);
                if (!isTouching(head, tail)) {
                    int pomakX = calculateStep(head.getX(), tail.getX());
                    int pomakY = calculateStep(head.getY(), tail.getY());
                    newTail = new Position(tail.getX() + pomakX, tail.getY() + pomakY);
                }
                knots[i][0] = newTail.getX();
                knots[i][1] = newTail.getY();
                if (i == 9) {
                    tailPositionPartTwo.add(newTail);
                }
            }
        }
    }

    private static boolean isTouching(Position head, Position tail) {
        return Math.abs(head.getX() - tail.getX()) <= 1 && Math.abs(head.getY() - tail.getY()) <= 1;
    }

    private static int calculateStep(int h, int t) {
        return (h == t) ? 0 : (h - t) / (Math.abs(h - t));
    }

    private static void printNumberOfDistinctPositions(List<Position> tailPositions) {
        Set<Position> distinctPositions = new HashSet<>(tailPositions);
        System.out.println(distinctPositions.size());
    }

}