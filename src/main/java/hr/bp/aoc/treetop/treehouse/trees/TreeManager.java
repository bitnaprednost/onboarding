package hr.bp.aoc.treetop.treehouse.trees;

import java.util.List;

/**
 * <p>TreeManager class.</p>
 *
 * @author Marko Krišković
 */
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
