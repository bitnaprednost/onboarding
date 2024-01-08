package hr.bp.aoc.treetop.treehouse.trees;

import hr.bp.aoc.treetop.treehouse.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>TreeManager class.</p>
 *
 * @author Marko Krišković
 */
public class TreeManager {
    private static final Logger logger = LoggerFactory.getLogger(TreeManager.class);
    public static int countVisibleTrees(List<Tree> forest){
        int count=0;
        for(Tree tree : forest){
            //logger.info(String.valueOf(tree));
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
