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
	private final int populationSize;
	private final int filterSize;
	private final int numOfMaxSteps;
	private final double evaporationRate;

	public AntColonyAlgorithm(Ant ant, int populationSize, int filterSize, int numOfMaxSteps, double evaporationRate) {
		this.populationSize=populationSize;
		this.filterSize=filterSize;
		this.numOfMaxSteps=numOfMaxSteps;
		this.evaporationRate=evaporationRate;

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

		return bestAnt;
	}

	public void initialUpdatePharomones(State initialState, double initialPheromone) {
		for(int i=0;i<dimensionY;i++){
			for (int j=0;j<dimensionX;j++){
				switch (initialState.getStringMap()[i][j]){
					case '>' -> pheromones[dimensionX*i+j][0] += initialPheromone;
					case 'v' -> pheromones[dimensionX*i+j][1] += initialPheromone;
					case '^' -> pheromones[dimensionX*i+j][2] += initialPheromone;
					case '<' -> pheromones[dimensionX*i+j][3] += initialPheromone;
				}
			}
		}
	}

	@Override
	public Ant run(Ant initialAnt) {
		Map<Ant, Integer> population = generateAntPopulation(initialAnt);
		population = findBestAnts(population);
		updatePheromones(population);

		Map.Entry<Ant, Integer> entry = population.entrySet().iterator().next();
		count = entry.getValue();
		return entry.getKey();
	}

	private Map<Ant, Integer> findBestAnts(Map<Ant, Integer> population) {
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
		}).limit(filterSize).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x,y)->x, LinkedHashMap::new));
	}

	private void updatePheromones(Map<Ant, Integer> population) {
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

		//evaporatePheromones(evaporationRate);
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

	private Map<Ant, Integer> generateAntPopulation(Ant initialAnt) {
		Map<Ant, Integer> map = new HashMap<>();
		for(int i=0;i<populationSize;i++){
			map.put(runAnt(new Ant(initialAnt)), count);
		}
		return map;
	}

	private Ant runAnt(Ant currentAnt) {
		boolean changed=true;
		count = 0;

		for(int i=0;i<numOfMaxSteps && changed;i++) {
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