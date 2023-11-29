package hr.bitnaPrednost.day8.trees;

import java.util.List;
public record Tree(int height, List<Boolean> directions, List<Integer> directionsCount){

    public boolean isVisible(){
        for(Boolean direction : directions) {
            if(direction==null) return true;
            else if(direction) return true;
        }
        return false;
    }

    public Integer getScenicScore(){
        return directionsCount.stream().reduce(1, (a,b)->a*b);
    }

    public static TreeBuilder builder(){
        return new TreeBuilder();
    }

}
