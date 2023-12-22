package hr.bp.aoc.treetop.treehouse.trees;

import java.util.Arrays;
import java.util.Iterator;

/**
 * <p>TreeBuilder class.</p>
 *
 * @author Marko Krišković
 */
public class TreeBuilder {
    private int height;
    private final Boolean[] directionsVisible = new Boolean[4];
    private final Integer[] directions = new Integer[4];
    private final Integer[] directionCount = new Integer[4];
    public Tree build(){
        var directionVisibleList = Arrays.asList(directionsVisible);
        var directionCountList = Arrays.asList(directionCount);
        return new Tree(height, directionVisibleList, directionCountList);
    }

    public TreeBuilder height(int height) {
        this.height = height;

        return this;
    }

    public TreeBuilder topVisible(Boolean top) {
        directionsVisible[0] = top;

        return this;
    }

    public TreeBuilder leftVisible(Boolean left) {
        directionsVisible[1] = left;

        return this;
    }

    public TreeBuilder bottomVisible(Boolean bottom) {
        directionsVisible[2] = bottom;

        return this;
    }

    public TreeBuilder rightVisible(Boolean right) {
        directionsVisible[3] = right;

        return this;
    }

    public TreeBuilder topCount(Integer top) {
        directionCount[0] = top;

        return this;
    }

    public TreeBuilder leftCount(Integer left) {
        directionCount[1] = left;

        return this;
    }

    public TreeBuilder bottomCount(Integer bottom) {
        directionCount[2] = bottom;

        return this;
    }

    public TreeBuilder rightCount(Integer right) {
        directionCount[3] = right;

        return this;
    }

    public boolean isDirectionVisible(TreeBuilder other, int pos){
        if(other.directionsVisible[pos]==null) {
            if(height>other.height) return true;
            else{
                directions[pos] = other.height;
                return false;
            }
        }
        else{
            if(height>other.height) {
                if(other.directionsVisible[pos] || height>other.directions[pos]) return true;
                else {
                    directions[pos] = other.directions[pos];
                    return false;
                }
            }
            else {
                if(other.directionsVisible[pos]) directions[pos] = other.height;
                else directions[pos] = other.directions[pos];
                return false;
            }
        }
    }

    public Integer calculateCount(Iterator<TreeBuilder> iterator, int limit) {
        int count=1;
        for (int i=0; i<limit && iterator.hasNext(); i++) {
            if(i==0) iterator.next();
            else{
                TreeBuilder builder = iterator.next();

                if(builder==this) return count;
                else{
                    if(height>builder.height) count++;
                    else count=1;
                }
            }
        }
        return count;
    }
}
