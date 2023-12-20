package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.Ant;

import java.util.*;

/**
 * @author Marko Krišković
 */
public class AntColonyAlgorithm implements Algorithm<Ant> {

	private int count;
	private int bestCount;
	private Ant bestAnt;
	private int dimensionX;
	private int dimensionY;
	private Double[][] pheromones;

	public AntColonyAlgorithm(int dimensionX, int dimensionY) {
		count = 0;
		bestCount = 0;

		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
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
			count = 0;
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
		Set<Ant> population = generateAntPopulation(initialAnt, 100);
		updatePheromones(population, 0.3);

		return findBestAnts(population);
	}

	private void updatePheromones(Set<Ant> population, double evaporationRate) {
		calculateFitness(population);

		for(int i=0;i<pheromones.length;i++){
			for(int j=0;j<pheromones[i].length;j++){
				pheromones[i][j] *= (1 - evaporationRate);
			}
		}
	}

	private Ant findBestAnts(Set<Ant> population) {
		Iterator<Ant> iterator = population.iterator();
		Ant currentMin = iterator.next();
		double min = currentMin.getDistanceFromEnd();

		while (iterator.hasNext()){
			Ant next = iterator.next();
			if(next.getDistanceFromEnd() < min){
				currentMin = next;
				min = next.getDistanceFromEnd();
			}
		}

		return currentMin;
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

	private Set<Ant> generateAntPopulation(Ant initialAnt, int times) {
		Set<Ant> set = new HashSet<>();
		for(int i=0;i<times;i++){
			set.add(runAnt(initialAnt));
		}
		return set;
	}

	private Ant runAnt(Ant currentAnt) {
		boolean changed=true;

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
		if (bestAnt == null)

			return count;
			else

			return bestCount;
	}

}