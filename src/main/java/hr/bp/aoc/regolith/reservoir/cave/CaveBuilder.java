package hr.bp.aoc.regolith.reservoir.cave;

import hr.bp.aoc.regolith.reservoir.Edges;
import hr.bp.aoc.regolith.reservoir.obstacle.Rock;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * <p>CaveBuilder class.</p>
 *
 * @author Marko Krišković
 */
public class CaveBuilder {
    private final Set<Rock> rocks;
    private boolean bottomless;

    public CaveBuilder() {
        this.rocks = new HashSet<>();
        this.bottomless = true;
    }

    public CaveBuilder(boolean botomless) {
        this.rocks = new HashSet<>();
        this.bottomless = botomless;
    }

    public CaveBuilder rock(int x, int y) {
        Rock rock = new Rock(new Point(x,y));
        rocks.add(rock);
        return this;
    }

    public CaveBuilder rock(Point point) {
        Rock rock = new Rock(point);
        rocks.add(rock);
        return this;
    }

    public int getRocksSize() {
        return rocks.size();
    }

    private void _rockRange(Point point1, Point point2) {
        if(point1.x == point2.x){
            if(point1.y < point2.y){
                for(int i=point1.y;i<=point2.y;i++){
                    rocks.add(new Rock(new Point(point1.x,i)));
                }
            }
            else {
                for(int i=point2.y;i<=point1.y;i++) {
                    rocks.add(new Rock(new Point(point1.x, i)));
                }
            }
        }
        else if(point1.y == point2.y){
            if(point1.x < point2.x) {
                for(int i=point1.x;i<=point2.x;i++) {
                    rocks.add(new Rock(new Point(i, point1.y)));
                }
            }
            else {
                for(int i=point2.x;i<=point1.x;i++) {
                    rocks.add(new Rock(new Point(i, point1.y)));
                }
            }
        }
    }

    public CaveBuilder rockRange(Point... points){
        Iterator<Point> iterator = Arrays.stream(points).iterator();
        Point current = iterator.next();

        while(iterator.hasNext()){
            Point next = iterator.next();
            _rockRange(current, next);
            current = next;
        }

        return this;
    }

    private static Edges claculateEdges(Set<Rock> rocks) {
        int maxX = 0;
        int maxY = 0;
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;

        for(Rock rock : rocks){
            if(rock.point().x<minX) minX = rock.point().x;
            if(rock.point().x>maxX) maxX = rock.point().x;
            if(rock.point().y<minY) minY = rock.point().y;
            if(rock.point().y>maxY) maxY = rock.point().y;
        }

        return new Edges(maxX, maxY, minY, minX);
    }

    public Cave build() {
        Point sandSource = new Point(500, 0);
        Edges edges = claculateEdges(rocks);

        if(!bottomless){
            int height = edges.maxY() - sandSource.y + 2;

            rockRange(new Point(sandSource.x - height - 1, height), new Point(sandSource.x + height + 1, height));
        }

        edges = claculateEdges(rocks);

        return new Cave(sandSource, rocks, edges);
    }
}
