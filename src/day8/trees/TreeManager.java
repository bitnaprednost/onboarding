package day8.trees;

import day8.trees.Tree;

import java.util.List;

public class TreeManager {
    public static int countVisibleTrees(List<Tree> forest){
        int count=0;
        for(Tree tree : forest){
            //System.out.println(tree);
            if(tree.isVisible()){
                count++;
            }
        }
        return count;
    }

    public static Integer calculateHighestScore(List<Tree> forest){
        return forest.stream().mapToInt(Tree::getScenicScore).max().getAsInt();
    }
}
