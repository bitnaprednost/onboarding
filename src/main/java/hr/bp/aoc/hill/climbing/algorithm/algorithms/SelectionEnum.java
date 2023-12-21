package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.Ant;
import hr.bp.aoc.hill.climbing.algorithm.State;

import java.util.*;

/**
 * @author Marko Krišković
 */
public enum SelectionEnum {
    ROULETTE {
        @Override
        public Optional<State> select(List<State> list) {
            return selectRoulette(list);
        }
    }, TOURNAMENT {
        @Override
        public Optional<State> select(List<State> list) {
            return selectTournament(list);
        }
    }, MIXED {
        @Override
        public Optional<State> select(List<State> list) {
            int randInt = random.nextInt(2);
            return randInt == 0 ? selectTournament(list) : selectRoulette(list);
        }
    };

    private static final Random random = new Random();

    public abstract Optional<State> select(List<State> list);

    private static Optional<State> selectRoulette(List<State> list) {
        double sum = list.stream().mapToDouble(State::getHeuristic).sum();

        Map<State, Double> map = new LinkedHashMap<>();
        double initial = 0;
        for(State state : list){
            initial += state.getHeuristic() / sum;
            map.put(state, initial);
        }

        double rand = random.nextDouble();
        for(Map.Entry<State, Double> entry : map.entrySet()){
            if(rand <= entry.getValue()) return Optional.of(entry.getKey());
        }

        return Optional.empty();
    }

    private static Optional<Ant> selectRoulette(Map<Ant, Double> initialMap) {
        double sum = initialMap.values().stream().mapToDouble(a->a).sum();

        Map<Ant, Double> map = new LinkedHashMap<>();
        double chance = 0;
        for(Map.Entry<Ant, Double> entry : initialMap.entrySet()){
            chance += entry.getValue() / sum;
            map.put(entry.getKey(), chance);
        }

        double rand = random.nextDouble();
        for(Map.Entry<Ant, Double> entry : map.entrySet()){
            if(rand <= entry.getValue()) return Optional.of(entry.getKey());
        }

        return Optional.empty();
    }

    private static Optional<State> selectTournament(List<State> list) {
        return switch (list.size()){
            case 1 -> Optional.of(list.getFirst());
            case 2 -> Optional.of(versus(list.get(0), list.get(1)));
            default -> {
                int randInt1 = random.nextInt(list.size());
                int randInt2 = random.nextInt(list.size());
                while(randInt1==randInt2) randInt2 = random.nextInt(list.size());

                yield Optional.of(versus(list.get(randInt1), list.get(randInt2)));
            }
        };
    }

    private static State versus(State state0, State state1) {
        if(state0.getHeuristic() > state1.getHeuristic()) return state0;
        else if(state0.getHeuristic() < state1.getHeuristic()) return state1;
        else{
            int randInt = random.nextInt(2);
            return randInt == 0 ? state0 : state1;
        }
    }

    public Optional<Ant> selectAnt(Map<Ant, Double> map) {
        return selectRoulette(map);
    }
}
