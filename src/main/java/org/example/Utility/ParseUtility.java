package org.example.Utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author Luka Ljubić
 */
public class ParseUtility {
    private ParseUtility() {
        throw new RuntimeException("Cannot instantiate class " + this.getClass().getName());
    }

    public static List<String> parseFromPathToList(String path){
        List<String> DataList;
        try {
            DataList = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return DataList;
    }

    public static String parseFromPath(String path){
        String temp;
        try {
            temp = Files.readString(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return temp;
    }
}
