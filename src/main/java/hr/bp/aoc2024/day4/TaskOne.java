package hr.bp.aoc2024.day4;

import hr.bp.aoc.day1.Utils;

import java.util.List;

public class TaskOne {

    public static void main(String[] args) {
        List<String> document = Utils.readFromFile("aoc2024/inputDay4.txt");

        WordSearchParser parser = new WordSearchParser(document);
        WordSearch wordSearch = new WordSearch(parser.parseWordSearchInput());

        System.out.println(wordSearch.findWordInSearchTable());
    }
}
