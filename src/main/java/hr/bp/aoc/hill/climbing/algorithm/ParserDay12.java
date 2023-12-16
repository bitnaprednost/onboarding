package hr.bp.aoc.hill.climbing.algorithm;

import hr.bp.aoc.util.Parser;

import java.awt.*;

public class ParserDay12 implements Parser {
    public static State parseStartingState(String[] textFromFile){
        char[][] map = new char[textFromFile.length][textFromFile[0].length()];
        char[][] stringMap = new char[map.length][map[0].length];

        Point point = fillMaps(textFromFile, map, stringMap);

        return new State(map, point, stringMap);
    }

    private static Point fillMaps(String[] textFromFile, char[][] map, char[][] stringMap) {
        Point point = null;

        for(int i = 0; i<textFromFile.length; i++){
            for(int j=0;j<textFromFile[i].length();j++){
                char letter = textFromFile[i].charAt(j);

                if(letter == 'S') {
                    map[i][j] = '`';
                    stringMap[i][j] = letter;

                    point = new Point(i, j);
                }
                else if(letter == 'E'){
                    map[i][j] = '{';
                    stringMap[i][j] = letter;
                }
                else{
                    map[i][j] = letter;
                    stringMap[i][j] = '.';
                }
            }
        }

        return point;
    }

}
