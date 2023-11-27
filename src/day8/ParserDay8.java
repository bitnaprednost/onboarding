package day8;

import java.util.Arrays;
import java.util.List;

public class ParserDay8 {

    private static Integer[][] stringToIntegerArray(String line){
        return Arrays.stream(line.split("\n"))
                .map(s->Arrays.stream(s.split(""))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new))
                 .toArray(Integer[][]::new);
    }

    private static void fillBottomAndRightVisible(Integer[][] treeIntegerMap, TreeBuilder[][] treeBuilders) {
        for(int i = treeIntegerMap.length - 1; i >= 0; i--){
            for(int j = treeIntegerMap[i].length - 1; j >= 0; j--){
                TreeBuilder treeTempBuilder = treeBuilders[i][j];

                if(i != treeIntegerMap.length-1){
                    treeTempBuilder.setBottom(treeTempBuilder.isDirectionVisible(treeBuilders[i+1][j], 2));
                }
                if(j != treeIntegerMap[i].length-1){
                    treeTempBuilder.setRight(treeTempBuilder.isDirectionVisible(treeBuilders[i][j+1], 3));
                }

                treeBuilders[i][j] = treeTempBuilder;
            }
        }
    }

    private static void fillTopAndLeftVisible(Integer[][] treeIntegerMap, TreeBuilder[][] treeBuilders) {
        for(int i = 0; i< treeIntegerMap.length; i++){
            for(int j = 0; j< treeIntegerMap[i].length; j++){
                if(treeIntegerMap[i][j]<0 || treeIntegerMap[i][j]>9) throw new IllegalArgumentException();

                TreeBuilder treeTempBuilder = Tree.builder().setHeight(treeIntegerMap[i][j]);

                if(i!=0){
                    treeTempBuilder.setTop(treeTempBuilder.isDirectionVisible(treeBuilders[i-1][j], 0));
                }
                if(j!=0){
                    treeTempBuilder.setLeft(treeTempBuilder.isDirectionVisible(treeBuilders[i][j-1], 1));
                }

                treeBuilders[i][j] = treeTempBuilder;
            }
        }
    }

    private static TreeBuilder[][] initializeTreeBuilders(Integer[][] treeIntegerMap) {
        TreeBuilder[][] treeBuilders = new TreeBuilder[treeIntegerMap.length][treeIntegerMap[0].length];

        fillTopAndLeftVisible(treeIntegerMap, treeBuilders);
        fillBottomAndRightVisible(treeIntegerMap, treeBuilders);

        return treeBuilders;
    }

    private static List<Tree> buildTrees(TreeBuilder[][] treeBuilders) {
        return Arrays.stream(treeBuilders)
                .flatMap(Arrays::stream)
                .map(TreeBuilder::build)
                .toList();
    }

    public static List<Tree> generateForest(String line){
        Integer[][] treeIntegerMap = stringToIntegerArray(line);
        TreeBuilder[][] treeBuilders = initializeTreeBuilders(treeIntegerMap);
        List<Tree> forest = buildTrees(treeBuilders);

        return forest;
    }

}
