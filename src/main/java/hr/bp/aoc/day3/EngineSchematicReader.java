package hr.bp.aoc.day3;

import java.util.List;

public class EngineSchematicReader {
    private Schema schema;

    public EngineSchematicReader(List<String> schematic) {
        schema = new Schema(schematic);
        schema.findSymbols();
    }

    public int getSumPartNumbers() {
        return schema.getSumPartNumbers();
    }

    public int getSumGearRatios() {
        return schema.getSumGearRations();
    }

}
