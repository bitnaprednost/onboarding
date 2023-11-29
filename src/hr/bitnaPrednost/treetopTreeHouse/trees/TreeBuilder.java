package hr.bitnaPrednost.treetopTreeHouse.trees;

import java.util.Arrays;
import java.util.Iterator;

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

    public TreeBuilder setHeight(int height) {
        this.height = height;

        return this;
    }

    public TreeBuilder setTopVisible(Boolean top) {
        directionsVisible[0] = top;

        return this;
    }

    public TreeBuilder setLeftVisible(Boolean left) {
        directionsVisible[1] = left;

        return this;
    }

    public TreeBuilder setBottomVisible(Boolean bottom) {
        directionsVisible[2] = bottom;

        return this;
    }

    public TreeBuilder setRightVisible(Boolean right) {
        directionsVisible[3] = right;

        return this;
    }

    public TreeBuilder setTopCount(Integer top) {
        directionCount[0] = top;

        return this;
    }

    public TreeBuilder setLeftCount(Integer left) {
        directionCount[1] = left;

        return this;
    }

    public TreeBuilder setBottomCount(Integer bottom) {
        directionCount[2] = bottom;

        return this;
    }

    public TreeBuilder setRightCount(Integer right) {
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
                //directionCount[pos] = other.directionCount[pos] + 1;
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
