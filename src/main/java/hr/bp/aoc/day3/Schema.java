package hr.bp.aoc.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Schema {
    private final List<String> schematic;
    private final List<EngineSymbol> allSymbols;

    public Schema(List<String> schematic) {
        this.schematic = schematic;
        allSymbols = new ArrayList<>();
    }

    private static boolean isSymbol(String potentialSymbol) {
        return !Character.isDigit(potentialSymbol.charAt(0)) && !potentialSymbol.equals(".");
    }

    private static boolean isDigit(String potentialDigit) {
        return Character.isDigit(potentialDigit.charAt(0));
    }

    public int getSumPartNumbers() {
        int sum = 0;
        Set<EngineNumber> partNumbers = new HashSet<>();

        for (EngineSymbol symbol : allSymbols) {
            List<Coordinate> adjacent = symbol.getAdjacantNumCoordinates();
            List<EngineNumber> numbers = getPartNumbersFromCordinates(adjacent);
            partNumbers.addAll(numbers);
        }

        for (EngineNumber number : partNumbers) {
            sum += number.getValue();
        }

        return sum;
    }

    private List<EngineNumber> getPartNumbersFromCordinates(List<Coordinate> coordinates) {
        List<EngineNumber> partNumbers = new ArrayList<>();

        for (Coordinate coordinate : coordinates) {
            if (isOnSchema(coordinate)) {
                EngineNumber potentialNum = getIfPartNum(coordinate);
                if (potentialNum != null) {
                    partNumbers.add(potentialNum);
                }
            }
        }
        return partNumbers;
    }

    private EngineNumber getIfPartNum(Coordinate coordinate) {
        String potentialNum = getAtIndex(coordinate);

        if (isDigit(potentialNum)) {
            return getFullNumFromSchema(coordinate);
        }

        return null;
    }

    private EngineNumber getFullNumFromSchema(Coordinate coordinate) {
        int numStart;
        int numEnd;
        StringBuilder sb = new StringBuilder();
        sb.append(getAtIndex(coordinate));

        int right = 1;
        Coordinate potentialNumCoordinate = new Coordinate(coordinate.getRow(), coordinate.getColumn() + right);
        String potentialNum = getAtIndex(potentialNumCoordinate);

        while (isOnSchema(potentialNumCoordinate)
                && isDigit(potentialNum)) {
            sb.append(potentialNum);

            right++;
            potentialNumCoordinate.setColumn(coordinate.getColumn() + right);
            potentialNum = getAtIndex(potentialNumCoordinate);
        }
        numEnd = potentialNumCoordinate.getColumn() - 1;

        int left = 1;
        potentialNumCoordinate = new Coordinate(coordinate.getRow(), coordinate.getColumn() - left);
        potentialNum = getAtIndex(potentialNumCoordinate);

        while (isOnSchema(potentialNumCoordinate)
                && isDigit(potentialNum)) {
            sb.insert(0, potentialNum);

            left++;
            potentialNumCoordinate.setColumn(coordinate.getColumn() - left);
            potentialNum = getAtIndex(potentialNumCoordinate);
        }
        numStart = potentialNumCoordinate.getColumn() + 1;

        return new EngineNumber(numStart, numEnd, Integer.parseInt(sb.toString()), potentialNumCoordinate.getRow());
    }

    private boolean isOnSchema(Coordinate coordinate) {
        return coordinate.getRow() >= 0
                && coordinate.getRow() < schematic.size()
                && coordinate.getColumn() >= 0
                && coordinate.getColumn() < schematic.get(0).length();
    }

    public void findSymbols() {
        for (int row = 0; row < schematic.size(); row++) {
            findSymbolRow(row);
        }
    }

    private void findSymbolRow(int row) {
        String[] schematicRow = schematic.get(row).split("");

        for (int collumn = 0; collumn < schematicRow.length; collumn++) {
            String potentialSymbol = schematicRow[collumn];
            if (isSymbol(potentialSymbol)) {
                allSymbols.add(new EngineSymbol(row, collumn, potentialSymbol));
            }
        }
    }

    public String getAtIndex(Coordinate coordinate) {
        if (isOnSchema(coordinate)) {
            return schematic.get(coordinate.getRow()).split("")[coordinate.getColumn()];
        }
        return "";
    }
}
