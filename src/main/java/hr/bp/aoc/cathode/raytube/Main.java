package hr.bp.aoc.cathode.raytube;

import hr.bp.aoc.util.Parser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] textFromFile = Parser.getLinesFromFile("Resources/day10Data.txt");

        RayTube rayTube = new RayTube();
        for(String line : textFromFile){
            rayTube.parse(line);
        }

        int result = rayTube.getSignalSum();
        System.out.println(result);
        rayTube.printMessage();
    }
}
