package com.bp.aoc.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContentLoader {

    public static List<String> loadContent(String fileName) {
        List<String> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(com.bp.aoc.util.ContentLoader.class.getClassLoader().getResourceAsStream(fileName))) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;
    }
}
