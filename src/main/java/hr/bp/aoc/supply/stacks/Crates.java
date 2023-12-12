package hr.bp.aoc.supply.stacks;

import java.util.Map;
import java.util.Stack;

/**
 * <p>Crates class.</p>
 *
 * @author Marko Krišković
 */
public class Crates {
    private Map<Integer, Stack<String>> stacks;

    public Crates(Map<Integer, Stack<String>> stacks) {
        this.stacks = stacks;
    }

    public String pop(int from) {
        return stacks.get(from).pop();
    }

    public String push(int into, String item) {
        return stacks.get(into).push(item);
    }

    public String peek(int into) {
        return stacks.get(into).peek();
    }

    public void move(int from, int into) {
        push(into, pop(from));
    }

    public String getTops() {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=stacks.size();i++){
            sb.append(peek(i));
        }
        return sb.toString();
    }
}
