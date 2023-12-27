package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.Ant;
import hr.bp.aoc.hill.climbing.algorithm.State;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Marko Krišković
 */
public class AntColonyAlgorithm implements Algorithm<Ant> {

	private int count;
	private int bestCount;
	private Ant bestAnt;
	private final int dimensionX;
	private final int dimensionY;
	private Double[][] pheromones;

	public AntColonyAlgorithm(Ant ant) {
		count = 0;
		bestCount = 100000;

		this.dimensionX = ant.getStringMap()[0].length;
		this.dimensionY = ant.getStringMap().length;

		this.pheromones = new Double[dimensionY * dimensionX][4];
		for (int i = 0; i < dimensionY * dimensionX; i++) {
			for (int j = 0; j < 4; j++) {
				pheromones[i][j] = 1.00;
			}
		}
	}

	@Override
	public Ant runMultiple(Ant initialAnt, int times) {
		Ant currentAnt = initialAnt;

		for (int i = 0; i < times; i++) {
			currentAnt = run(initialAnt);

			if(i%100==0){
				System.out.println(currentAnt);
			}

			if (currentAnt.endReached()) {
				if (count < bestCount) {
					bestCount = count;
					bestAnt = currentAnt;
				}
			}
		}

		return bestAnt;
	}

	public void initialUpdatePharomones(State initialState, double pheromone) {
		for(int i=0;i<dimensionY;i++){
			for (int j=0;j<dimensionX;j++){
				switch (initialState.getStringMap()[i][j]){
					case '>' -> pheromones[dimensionX*i+j][0] += pheromone;
					case 'v' -> pheromones[dimensionX*i+j][1] += pheromone;
					case '^' -> pheromones[dimensionX*i+j][2] += pheromone;
					case '<' -> pheromones[dimensionX*i+j][3] += pheromone;
				}
			}
		}
	}

	@Override
	public Ant run(Ant initialAnt) {
		Map<Ant, Integer> population = generateAntPopulation(initialAnt, 1000, 1500);
		population = findBestAnts(population, 100);
		updatePheromones(population, 0.05);

		Map.Entry<Ant, Integer> entry = population.entrySet().iterator().next();
		count = entry.getValue();
		return entry.getKey();
	}

	private Map<Ant, Integer> findBestAnts(Map<Ant, Integer> population, int top) {
		return population.entrySet().stream().sorted(new Comparator<Map.Entry<Ant, Integer>>() {
			@Override
			public int compare(Map.Entry<Ant, Integer> o1, Map.Entry<Ant, Integer> o2) {
				boolean firstEndReached = o1.getKey().endReached();
				boolean secondEndReached = o2.getKey().endReached();

				if(firstEndReached && secondEndReached) return o1.getValue().compareTo(o2.getValue());				//returns shortest count
				else if(firstEndReached) return -1;																	//returns first
				else if(secondEndReached) return 1;																//returns second
				else {
					return o1.getKey().getDistanceFromEnd().compareTo(o2.getKey().getDistanceFromEnd());			//returns smallest heuristic
				}
			}
		}).limit(top).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x,y)->x, LinkedHashMap::new));
	}

	private void updatePheromones(Map<Ant, Integer> population, double evaporationRate) {
		for(Map.Entry<Ant, Integer> entry : population.entrySet()){
			for(int i=0;i<dimensionY;i++){
				for (int j=0;j<dimensionX;j++){
//					for(int k=0;k<4;k++){
//						if(ant.getFittness(i, j, k) != 0) pheromones[dimensionX*i+j][k] += 1 / ant.getFittness(i, j, k); // pheromones[dimensionX*i+j][k];
//					}
					switch (entry.getKey().getStringMap()[i][j]){
						case '>' -> pheromones[dimensionX*i+j][0] += entry.getValue() / entry.getKey().getFittness(i, j, 0); // pheromones[dimensionX*i+j][0];
						case 'v' -> pheromones[dimensionX*i+j][1] += entry.getValue() / entry.getKey().getFittness(i, j, 1); // pheromones[dimensionX*i+j][1];
						case '^' -> pheromones[dimensionX*i+j][2] += entry.getValue() / entry.getKey().getFittness(i, j, 2); // pheromones[dimensionX*i+j][2];
						case '<' -> pheromones[dimensionX*i+j][3] += entry.getValue() / entry.getKey().getFittness(i, j, 3); // pheromones[dimensionX*i+j][3];
					}
				}
			}
		}

		//if(endReached) evaporatePheromones(evaporationRate);
	}

	private void evaporatePheromones(double evaporationRate) {
		for(int i=0;i<dimensionY;i++) {
			for (int j=0;j<dimensionX;j++) {
				for (int k=0;k<4;k++) {
					pheromones[dimensionX*i+j][k] *= (1 - evaporationRate);
				}
			}
		}
	}

	private Map<Ant, Integer>  generateAntPopulation(Ant initialAnt, int times, int maxSteps) {
		Map<Ant, Integer> map = new HashMap<>();
		for(int i=0;i<times;i++){
			map.put(runAnt(new Ant(initialAnt), maxSteps), count);
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