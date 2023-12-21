package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.Ant;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marko Krišković
 */
public class AntColonyAlgorithm implements Algorithm<Ant> {

	private int count;
	private Integer bestCount;
	private Ant bestAnt;
	private int dimensionX;
	private int dimensionY;
	private Double[][] pheromones;

	public AntColonyAlgorithm(Ant ant) {
		count = 0;
		bestCount = 100000;

		this.dimensionX = ant.getStringMap()[0].length;
		this.dimensionY = ant.getStringMap().length;

		this.pheromones = new Double[dimensionY * dimensionX][4];
		for (int i = 0; i < dimensionY * dimensionX; i++) {
			for (int j = 0; j < 4; j++) {
				pheromones[i][j] = 1.0;
			}
		}
	}

	@Override
	public Ant runMultiple(Ant initialAnt, int times) {
		Ant currentAnt = initialAnt;

		for (int i = 0; i < times; i++) {
			currentAnt = run(initialAnt);

			if(i%10==0){
				System.out.println(currentAnt);
			}

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
		Map<Ant, Integer> population = generateAntPopulation(initialAnt, 500, 300);
		population = findBestAnts(population, 200);
		updatePheromones(population.keySet(), 0.1);

		Iterator<Map.Entry<Ant, Integer>> iterator = population.entrySet().iterator();
		//for(int i=0;i<49;i++) iterator.next();
		return iterator.next().getKey();
	}

	private Map<Ant, Integer> findBestAnts(Map<Ant, Integer> population, int top) {
		return population.entrySet().stream().sorted(new Comparator<Map.Entry<Ant, Integer>>() {
			@Override
			public int compare(Map.Entry<Ant, Integer> o1, Map.Entry<Ant, Integer> o2) {
				if(!Objects.equals(o1.getValue(), o2.getValue())) return o1.getValue().compareTo(o2.getValue());
				else return o1.getKey().getDistanceFromEnd().compareTo(o2.getKey().getDistanceFromEnd());
			}
		}).limit(top).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x,y)->x, LinkedHashMap::new));
	}

	private void updatePheromones(Set<Ant> population, double evaporationRate) {
		for(Ant ant : population){
			for(int i=0;i<dimensionY;i++){
				for (int j=0;j<dimensionX;j++){
					switch (ant.getStringMap()[i][j]){
						case '>' -> pheromones[dimensionX*i+j][0] += ant.getFittness(i, j, 0) / pheromones[dimensionX*i+j][0];
						case 'v' -> pheromones[dimensionX*i+j][1] += ant.getFittness(i, j, 1) / pheromones[dimensionX*i+j][1];
						case '^' -> pheromones[dimensionX*i+j][2] += ant.getFittness(i, j, 2) / pheromones[dimensionX*i+j][2];
						case '<' -> pheromones[dimensionX*i+j][3] += ant.getFittness(i, j, 3) / pheromones[dimensionX*i+j][3];
					}
				}
			}
		}

		evaporatePheromones(evaporationRate);
	}

	private void evaporatePheromones(double evaporationRate) {
		for(int i=0;i<dimensionY;i++) {
			for (int j=0;j<dimensionX;j++) {
				for (int k=0;k<4;k++) {
					pheromones[dimensionX*i+j][k] *= (1-evaporationRate);
				}
			}
		}
	}

	private Map<Ant, Integer>  generateAntPopulation(Ant initialAnt, int times, int maxSteps) {
		Map<Ant, Integer> map = new HashMap<>();
		for(int i=0;i<times;i++){
			map.put(runAnt(initialAnt, maxSteps), count);
		}
		return map;
	}

	private Ant runAnt(Ant currentAnt, int maxSteps) {
		boolean changed=true;
		count = 0;

		for(int i=0;i<maxSteps && changed;i++) {
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