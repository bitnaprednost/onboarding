package org.example.days.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class ElfGroup {
    private final List<String> elvesGroup;
    private String groupID;


    private ElfGroup(List<String> elvesGroup) {
        this.elvesGroup = new ArrayList<>(elvesGroup);
    }

    public static ElfGroup of(List<String> elvesGroup) {
        if (elvesGroup.size() != 3) throw new RuntimeException("Elve group cant be larger than 3");
        return new ElfGroup(elvesGroup);
    }

    public List<String> getElvesGroup() {
        return elvesGroup;
    }

    @Override
    public String toString() {
        return "ElfGroup{" +
                "elvesGroup=" + elvesGroup +
                '}';
    }
}
