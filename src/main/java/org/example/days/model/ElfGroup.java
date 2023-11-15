package org.example.days.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author Luka Ljubić
 */
public class ElfGroup {
    private final List<String> elvesGroup;
    private Character groupID;


    private ElfGroup(List<String> elvesGroup) {
        this.elvesGroup = new ArrayList<>(elvesGroup);
        calculateGroupID();
    }

    public static ElfGroup of(List<String> elvesGroup) {
        if (elvesGroup.size() != 3) throw new RuntimeException("Elve group cant be larger than 3");
        return new ElfGroup(elvesGroup);
    }

    public List<String> getElvesGroup() {
        return elvesGroup;
    }

    private void calculateGroupID() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String line : elvesGroup) {
            stringBuilder.append(line);
        }
        String allElvesCombined = stringBuilder.toString();

        groupID = ElfGroup.byStream(allElvesCombined);

    }

    static Character byStream(String input) {
        return input.chars()
                .mapToObj(x -> (char) x)
                .collect(groupingBy(x -> x, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .get()
                .getKey();
    }

    @Override
    public String toString() {
        return "ElfGroup{" +
                "elvesGroup=" + elvesGroup + groupID +
                '}';
    }
}
