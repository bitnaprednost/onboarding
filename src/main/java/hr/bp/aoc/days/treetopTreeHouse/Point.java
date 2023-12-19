package hr.bp.aoc.days.treetopTreeHouse;

public record Point(int x, int y) {
    Point move(int mx, int my) { return new Point(x + mx, y + my);}
    boolean inside(int[][] map) { return y >= 0 && y < map.length && x >= 0 && x < map[y].length; }
}
