package day8;

import java.util.List;

public class TreeManager {
    public static int countVisibleTrees(List<Tree> forest){
        int count=0;
        for(Tree tree : forest){
            System.out.println(tree);
            if(tree.isVisible()){
                count++;
            }
        }
        return count;
    }
}
