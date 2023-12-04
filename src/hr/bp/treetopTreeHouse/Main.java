package hr.bp.treetopTreeHouse;

import hr.bp.treetopTreeHouse.trees.Tree;
import hr.bp.treetopTreeHouse.trees.TreeManager;
import hr.bp.util.Parser;

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
