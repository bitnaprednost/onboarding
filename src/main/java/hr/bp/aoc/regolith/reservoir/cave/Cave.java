package hr.bp.aoc.regolith.reservoir.cave;

import hr.bp.aoc.regolith.reservoir.Edges;
import hr.bp.aoc.regolith.reservoir.obstacle.Obsticle;
import hr.bp.aoc.regolith.reservoir.obstacle.Rock;
import hr.bp.aoc.regolith.reservoir.obstacle.Sand;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Cave {
    private final Point sandSource;
    private Set<Obsticle> obsticles;
    private Edges edges;

    Cave(Point sandSource, Set<Rock> rocks, Edges edges) {
        obsticles = new HashSet<>(rocks);
        this.sandSource = sandSource;
        this.edges = edges;
    }

    private boolean moveSand(Sand sand) {
        if(!isObstacleAt(new Point(sand.getPoint().x, sand.getPoint().y+1))){
            sand.getPoint().y += 1;

            return true;
        }
        else if(!isObstacleAt(new Point(sand.getPoint().x-1, sand.getPoint().y+1))) {
            sand.getPoint().y += 1;
            sand.getPoint().x -= 1;

            return true;
        }
        else if(!isObstacleAt(new Point(sand.getPoint().x+1, sand.getPoint().y+1))) {
            sand.getPoint().y += 1;
            sand.getPoint().x += 1;

            return true;
        }

        return false;
    }

    public boolean dropSand() {
        Sand sand = new Sand(sandSource.x, sandSource.y);

        int maxHeight = edges.maxY() - sandSource.y;
        int count = 0;
        while(moveSand(sand) && count <= maxHeight) count++;

        if(count <= maxHeight){
            return obsticles.add(sand);
        }
        else return false;
    }

    public int countMaxSand() {
        int count = 0;
        while(dropSand()) count++;
        return count;
    }

    private boolean isSandAt(Point point) {
        return obsticles.contains(new Sand(point));
    }

    private boolean isRockAt(Point point) {
        return obsticles.contains(new Rock(point));
    }

    private boolean isObstacleAt(Point point){
        return isRockAt(point) || isSandAt(point);
    }

    public int getObsticlesSize() {
        return obsticles.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=sandSource.y;i<=edges.maxY();i++){
            sb.append(i).append(" ");
            for(int j=edges.minX();j<=edges.maxX();j++) {
                Point point = new Point(j, i);

                if(isRockAt(point)) sb.append("#");
                else if(isSandAt(point)) sb.append("o");
                else if(sandSource.equals(point)) sb.append("+");
                else sb.append(".");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
