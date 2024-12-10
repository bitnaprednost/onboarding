package hr.bp.aoc2024.day8;

import java.util.List;

public class AntennaMapParser {
    List<String> document;

    public AntennaMapParser(List<String> document) {
        this.document = document;
    }

    public char[][] parseAntennaMap() {
        int mapLength = document.size();
        int mapWidth = document.get(0).strip().length();

        char[][] antennaMap = new char[mapLength][mapWidth];

        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapWidth; j++) {
                antennaMap[i][j] = getCharFromDocument(i, j);
            }
        }
        return antennaMap;
    }

    private char getCharFromDocument(int x, int y) {
        String[] stringAtRowX = document.get(x).strip().split("");

        return stringAtRowX[y].charAt(0);
    }
}
