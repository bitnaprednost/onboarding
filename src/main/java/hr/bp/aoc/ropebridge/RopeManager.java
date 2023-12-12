package hr.bp.aoc.ropebridge;

import org.apache.commons.lang3.Validate;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class RopeManager {
    private final Rope rope;
    private final Set<Point> tailTrail;

    public RopeManager(int size){
        rope = new Rope(size);
        tailTrail = new HashSet<>();
        tailTrail.add(new Point(0, 0));
    }

    public Point getHead() {
        return rope.getHead();
    }

    public Point getTail() {
        return rope.getTail();
    }

    public void moveRight(int times) {
        for(int i=0;i<times;i++){
            rope.moveRight();
            updateTailTrail();
        }
    }

    public void moveLeft(int times) {
        for(int i=0;i<times;i++){
            rope.moveLeft();
            updateTailTrail();
        }
    }

    public void moveUp(int times) {
        for(int i=0;i<times;i++){
            rope.moveUp();
            updateTailTrail();
        }
    }

    public void moveDown(int times) {
        for(int i=0;i<times;i++){
            rope.moveDown();
            updateTailTrail();
        }
    }

    public void parse(String command) {
        Validate.notBlank(command);
        if(!command.matches("[RULD] \\d+")) throw new IllegalArgumentException("Input string not in correct format.");

        int times = Integer.parseInt(command.substring(2));
        switch (command.substring(0, 1)){
            case "R" -> moveRight(times);
            case "U" -> moveUp(times);
            case "L" -> moveLeft(times);
            case "D" -> moveDown(times);
        }
    }

    private void updateTailTrail(){
        tailTrail.add(getTail());
    }

    public int countTailTrail() {
        return tailTrail.size();
    }

    public String print(int size){
        StringBuilder sb = new StringBuilder();
        for (int i=size;i>-size;i--){
            for (int j=-size;j<size;j++){
                if(i==0 && j==0) sb.append("s");
                else if(tailTrail.contains(new Point(j, i))) sb.append("#");
                else sb.append(".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
