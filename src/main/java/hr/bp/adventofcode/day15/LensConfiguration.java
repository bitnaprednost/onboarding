package hr.bp.adventofcode.day15;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Ivan Tomičić
 */
public class LensConfiguration {

    private Map<Integer, LinkedHashMap<String, Integer>> boxes;

    private final Hasher hasher = new Hasher();

    public LensConfiguration(String input) {
        boxes = new HashMap<>();
        String[] sequences = input.replace("\\n", "").split(",");
        for (String sequence : sequences) {
            processSequence(sequence);
        }

    }

    private void processSequence(String sequence) {
        if (sequence.contains("-")) {
            processDash(sequence);
        } else {
            processEqualsSign(sequence);
        }
    }

    private void processEqualsSign(String sequence) {
        String label = sequence.split("=")[0];
        Integer focusLength = Integer.parseInt(sequence.split("=")[1]);

        int labelHash = hasher.hash(label);

        LinkedHashMap<String, Integer> box = boxes.computeIfAbsent(labelHash, k -> new LinkedHashMap<>());

        if (box.isEmpty() || !box.containsKey(label)) {
            box.putLast(label, focusLength);
        } else {
            box.put(label, focusLength);
        }


    }

    private void processDash(String sequence) {
        String label = sequence.split("-")[0];

        int labelHash = hasher.hash(label);
        LinkedHashMap<String, Integer> box = boxes.get(labelHash);

        if (box == null) return;

        box.remove(label);
    }

    public int getFocusingPower() {
        return boxes.entrySet().stream().filter(entry -> !entry.getValue().isEmpty())
                .map(entry -> {
                    int boxSum = 0;
                    int order = 1;
                    for (Map.Entry<String, Integer> stringIntegerEntry : entry.getValue().entrySet()) {
                        int multiplication = 1;
                        multiplication *= entry.getKey() + 1;
                        multiplication *= order;
                        multiplication *= stringIntegerEntry.getValue();
                        boxSum += multiplication;
                        order++;
                    }
                    return boxSum;
                }).reduce(Integer::sum).get();
    }
}
