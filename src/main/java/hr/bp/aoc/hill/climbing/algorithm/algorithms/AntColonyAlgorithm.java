package hr.bp.aoc.hill.climbing.algorithm.algorithms;

import hr.bp.aoc.hill.climbing.algorithm.State;

import java.util.List;

/**
 * @author Marko Krišković
 */
public class AntColonyAlgorithm implements Algorithm<State> {

	private int count;
	private int bestCount;
	private State bestState;
	private int[][] pheromones;
	private double[][] probabilities;

	public AntColonyAlgorithm(int dimensionX, int dimensionY) {
		count = 0;
		bestCount = 0;

		pheromones = new int[dimensionY][dimensionX];
		probabilities = new double[dimensionY][dimensionX];

		for (int i = 0; i < dimensionY; i++) {
			for (int j = 0; j < dimensionX; j++) {
				pheromones[i][j] = 0;
				probabilities[i][j] = 0.5;
			}
		}
	}

	@Override
	public State runMultiple(State initialState, int times) {
		State currentState = initialState;

		for (int i = 0; i < times; i++) {
			count = 0;
			currentState = run(initialState);

			if (currentState.endReached()) {
				if (count < bestCount) {
					bestCount = count;
					bestState = currentState;
				}
			}
		}

		return currentState;
	}

	@Override
	public State run(State initialState) {
		List<State> population = generateAntPopulation(initialState, 100);
		calculateFitness(population);
		State bestAnt = findBestAnts(population);
		updatePheromones(population);

		return bestAnt;
	}

	private void updatePheromones(List<State> population) {
	}

	private State findBestAnts(List<State> population) {
		return null;
	}

	private void calculateFitness(List<State> population) {
	}

	private List<State> generateAntPopulation(State initialState, int i) {
		return null;
	}

	@Override
	public int getCount() {
		if (bestState == null)

			return count;
			else

			return bestCount;
	}

}