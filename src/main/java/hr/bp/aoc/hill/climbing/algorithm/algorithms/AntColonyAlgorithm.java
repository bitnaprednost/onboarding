package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.Ant;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marko Krišković
 */
public class AntColonyAlgorithm implements Algorithm<Ant> {

	private int count;
	private int bestCount;
	private Ant bestAnt;
	private int dimensionX;
	//private int dimensionY;
	private Double[][] pheromones;

	public AntColonyAlgorithm(int dimensionX, int dimensionY) {
		count = 0;
		bestCount = 0;

		this.dimensionX = dimensionX;
		//this.dimensionY = dimensionY;

		this.pheromones = new Double[dimensionY*dimensionX][4];
		for (int i = 0; i < dimensionY*dimensionX; i++) {
			for (int j = 0; j < 4; j++) {
				pheromones[i][j] = 0.25;
			}
		}
	}

	@Override
	public Ant runMultiple(Ant initialAnt, int times) {
		Ant currentAnt = initialAnt;

		for (int i = 0; i < times; i++) {
			currentAnt = run(initialAnt);

			if (currentAnt.endReached()) {
				if (count < bestCount) {
					bestCount = count;
					bestAnt = currentAnt;
				}
			}
		}

		return currentAnt;
	}

	@Override
	public Ant run(Ant initialAnt) {
		Map<Ant, Integer> population = generateAntPopulation(initialAnt, 100);
		Map<Ant, Integer> bestAnts = findBestAnts(population, 20);
		updatePheromones(bestAnts.keySet(), 0.3);

		return bestAnts.entrySet().iterator().next().getKey();
	}

	private void updatePheromones(Set<Ant> population, double evaporationRate) {
		calculateFitness(population);

		for(int i=0;i<pheromones.length;i++){
			for(int j=0;j<pheromones[i].length;j++){
				pheromones[i][j] *= (1 - evaporationRate);
			}
		}
	}

	private Map<Ant, Integer> findBestAnts(Map<Ant, Integer> population, int top) {
		return population.entrySet().stream().sorted(new Comparator<Map.Entry<Ant, Integer>>() {
			@Override
			public int compare(Map.Entry<Ant, Integer> o1, Map.Entry<Ant, Integer> o2) {
				if(!Objects.equals(o1.getValue(), o2.getValue())) return o1.getValue().compareTo(o2.getValue());
				else return o1.getKey().getDistanceFromEnd().compareTo(o2.getKey().getDistanceFromEnd());
			}
		}).limit(top).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	private void calculateFitness(Set<Ant> population) {
		Double sumAnts = population.stream().mapToDouble(Ant::getFittness).sum();

		for(Ant ant : population){
			char[][] map = ant.getStringMap();
			for(int i=0;i<map.length;i++){
				for (int j=0;j<map[i].length;j++){
					switch (map[i][j]){
						case '>' -> pheromones[dimensionX*i+j][0] += ant.getFittness() / sumAnts;
						case 'v' -> pheromones[dimensionX*i+j][1] += ant.getFittness() / sumAnts;
						case '^' -> pheromones[dimensionX*i+j][2] += ant.getFittness() / sumAnts;
						case '<' -> pheromones[dimensionX*i+j][3] += ant.getFittness() / sumAnts;
					}
				}
			}
		}
	}

	private Map<Ant, Integer>  generateAntPopulation(Ant initialAnt, int times) {
		Map<Ant, Integer> map = new HashMap<>();
		for(int i=0;i<times;i++){
			map.put(runAnt(initialAnt), count);
		}
		return map;
	}

	private Ant runAnt(Ant currentAnt) {
		boolean changed=true;
		count = 0;

		for(int i=0;i<250 && changed;i++) {
			if(currentAnt.getValue()=='{') break;
			changed = false;

			Map<Ant, Double> neighbors = currentAnt.generateNeighbors(pheromones[dimensionX * currentAnt.getCurrentPosition().y + currentAnt.getCurrentPosition().x]);

			Optional<Ant> max = Ant.choose(neighbors);
			if(max.isPresent()){
				currentAnt = max.get();
				changed = true;
			}

			count++;
		}

		return currentAnt;
	}

	@Override
	public int getCount() {
		if (bestAnt == null) return count;
		else return bestCount;
	}

}