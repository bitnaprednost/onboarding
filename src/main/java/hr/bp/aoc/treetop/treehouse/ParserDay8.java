package hr.bp.aoc.treetop.treehouse;

import hr.bp.aoc.treetop.treehouse.trees.Tree;
import hr.bp.aoc.treetop.treehouse.trees.TreeBuilder;
import hr.bp.aoc.util.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>ParserDay8 class.</p>
 *
 * @author Marko Krišković
 */
public class ParserDay8 implements Parser {

    private static <T>  List<LinkedList<T>> transposeArray(T[][] doubleArray) {
        List<LinkedList<T>> reversed = new ArrayList<>();

        for (int i=0;i<doubleArray.length;i++){
            LinkedList<T> elements = new LinkedList<>();
            for(int j=0;j<doubleArray[0].length;j++){
                elements.add(doubleArray[j][i]);
            }
            reversed.add(elements);
        }

        return reversed;
    }

    private static void fillTopAndLeftVisible(Integer[][] treeIntegerMap, TreeBuilder[][] treeBuilders) {
        for(int i = 0; i < treeIntegerMap.length; i++){
            for(int j = 0; j < treeIntegerMap[i].length; j++){
                if(treeIntegerMap[i][j]<0 || treeIntegerMap[i][j]>9) throw new IllegalArgumentException();

                TreeBuilder treeTempBuilder = Tree.builder().height(treeIntegerMap[i][j]);

                if(i!=0){
                    treeTempBuilder.topVisible(treeTempBuilder.isDirectionVisible(treeBuilders[i-1][j], 0));

                    List<LinkedList<TreeBuilder>> transposedTreeBuilders = transposeArray(treeBuilders);
                    treeTempBuilder.topCount(treeTempBuilder.calculateCount(transposedTreeBuilders.get(j).listIterator(), i));
                }
                else{
                    treeTempBuilder.topCount(0);
                }
                if(j!=0){
                    treeTempBuilder.leftVisible(treeTempBuilder.isDirectionVisible(treeBuilders[i][j-1], 1));
                    treeTempBuilder.leftCount(treeTempBuilder.calculateCount(Arrays.stream(treeBuilders[i]).iterator(), j));
                }
                else{
                    treeTempBuilder.leftCount(0);
                }

                treeBuilders[i][j] = treeTempBuilder;
            }
        }
    }

    private static void fillBottomAndRightVisible(Integer[][] treeIntegerMap, TreeBuilder[][] treeBuilders) {
        for(int i = treeIntegerMap.length - 1; i >= 0; i--){
            for(int j = treeIntegerMap[i].length - 1; j >= 0; j--){
                TreeBuilder treeTempBuilder = treeBuilders[i][j];

                if(i != treeIntegerMap.length-1){
                    treeTempBuilder.bottomVisible(treeTempBuilder.isDirectionVisible(treeBuilders[i+1][j], 2));

                    List<LinkedList<TreeBuilder>> transposedTreeBuilders = transposeArray(treeBuilders);
                    treeTempBuilder.bottomCount(treeTempBuilder.calculateCount(transposedTreeBuilders.get(treeIntegerMap.length-1-j).descendingIterator(), treeIntegerMap.length-1-i));
                }
                else{
                    treeTempBuilder.bottomCount(0);
                }
                if(j != treeIntegerMap[i].length-1){
                    treeTempBuilder.rightVisible(treeTempBuilder.isDirectionVisible(treeBuilders[i][j+1], 3));
                    treeTempBuilder.rightCount(treeTempBuilder.calculateCount(Arrays.stream(treeBuilders[i]).collect(Collectors.toCollection(LinkedList::new)).descendingIterator(), treeIntegerMap[i].length-1-j));
                }
                else{
                    treeTempBuilder.rightCount(0);
                }

                treeBuilders[i][j] = treeTempBuilder;
            }
        }
    }

    private static Integer[][] stringToIntegerArray(String line){
        return Arrays.stream(line.split("\n"))
                .map(s->Arrays.stream(s.split(""))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .toArray(Integer[]::new))
                .toArray(Integer[][]::new);
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
