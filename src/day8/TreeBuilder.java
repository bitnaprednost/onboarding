package day8;

import java.util.Arrays;

public class TreeBuilder {
    private int height;
    private Boolean[] directionsVisible = new Boolean[4];
    private Integer[] directions = new Integer[4];
    public Tree build(){
        var directionVisibleList = Arrays.asList(directionsVisible);
        var directionList = Arrays.asList(directions);
        return new Tree(height, directionVisibleList, directionList);
    }

    public TreeBuilder setHeight(int height) {
        this.height = height;

        return this;
    }

    public TreeBuilder setTop(Boolean top) {
        directionsVisible[0] = top;

        return this;
    }

    public TreeBuilder setLeft(Boolean left) {
        directionsVisible[1] = left;

        return this;
    }

    public TreeBuilder setBottom(Boolean bottom) {
        directionsVisible[2] = bottom;

        return this;
    }

    public TreeBuilder setRight(Boolean right) {
        directionsVisible[3] = right;

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
                if(other.directionsVisible[pos]) return true;
                else {
                    directions[pos] = other.directions[pos];
                    return false;
                }
            }
            else {
                directions[pos] = other.height;
                return false;
            }
        }
    }
}
