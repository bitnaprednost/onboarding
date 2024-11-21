package hr.bp.aoc.day3;

import java.util.List;

public class EngineSchematicReader {
    private Schema schema;

    public EngineSchematicReader(List<String> schematic) {
        schema = new Schema(schematic);
    }

    public int getSumPartNumbers() {
        schema.findSymbols();
        return schema.getSumPartNumbers();
    }

}
