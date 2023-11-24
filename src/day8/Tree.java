package day8;

import java.util.List;
public record Tree(int height, List<Boolean> directions, List<Integer> directionsTemp){

    public boolean isVisible(){
        for(Boolean direction : directions) {
            if(direction==null) return true;
            else if(direction) return true;
        }
        return false;
    }

    public static TreeBuilder builder(){
        return new TreeBuilder();
    }

}
