package day8;

import day8.trees.Tree;
import day8.trees.TreeManager;
import util.Parser;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String textFromFile = Parser.getTextFromFile("Resources/day8Data.txt");
        List<Tree> forest = ParserDay8.generateForest(textFromFile);
        int count = TreeManager.countVisibleTrees(forest);
        System.out.println(count);

        int max = TreeManager.calculateHighestScore(forest);
        System.out.println(max);
    }
}
