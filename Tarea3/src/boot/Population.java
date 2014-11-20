package boot;

import java.util.ArrayList;
import java.util.List;

public class Population {
	/** List of individual making the population */
	private List<Individual> individuals;
	
	/** Number of individuals that may form a tournament */
	private final int TOURNAMENT_SIZE = 5;
	
	/** 
	 * Create a list of individuals
	 * @param size	number of individual to consider
	 */
	public void create(int size) {
		individuals = new ArrayList<Individual>();
		for(int i = 0; i < size; i++)
			individuals.add(new Individual());
	}
	
	/**
	 * Create individuals and generate genotype for each of them
	 * @param size	size of the population
	 */
	public void createAndGenerateIndividual(int size) {
		this.create(size);
		this.generateGenotype();
	}

	/** 
	 * Generate the genotype of each individual 
	 */ 
	private void generateGenotype() {
		for(Individual i : individuals)
			i.generateGenes();
	}
	
	/**
	 * Create a new population, fitter to solve the problem
	 * @return a new population with better individuals
	 */
	public Population evolve() {
		Population newPopulation = new Population();
		newPopulation.create(this.numberOfIndividuals());
		if(this.shouldUseElistism()) 
			newPopulation.individualAtPut(1, this.fittestIndividual());
		
		int elitismOffset = this.shouldUseElistism()?1:0;
		
		//Loop iver the population size and create new individual with crossover
		for(int index = elitismOffset; index < this.numberOfIndividuals(); index++) {
			Individual newIndividual = this.tournamentSelection().crossOverWith(this.tournamentSelection());
			newPopulation.individualAtPut(index, newIndividual);
		}
		
		//Mutate population
		for(int index = elitismOffset; index < this.numberOfIndividuals(); index++)
			newPopulation.individualAt(index).mutate();

		return newPopulation;
	}

	/**
	 * Pick randomly some individuals from the population, and pick the fittest individual 
	 * @return the fittest individual from the subset of the population
	 */
	private Individual tournamentSelection() {
		Population newPopulation = new Population();
		newPopulation.create(this.tournamentSize());
		for(int i = 0; i < this.tournamentSize(); i++) {
			int randomIndex = (int)(Math.random()*this.numberOfIndividuals());
			newPopulation.individualAtPut(i, (this.individualAt(randomIndex)));
		}
		return newPopulation.fittestIndividual();
	}

	/**
	 * Return the number of individual for a tournament
	 * @return the number of individual for a tournament
	 */
	private int tournamentSize() {
		return TOURNAMENT_SIZE;
	}

	/**
	 * Set a particular individual
	 * @param index			position of the individual
	 * @param individual	individual to insert in the population
	 */
	private void individualAtPut(int index, Individual individual) {
		individuals.set(index, individual);
	}

	/**
	 * Return an individual
	 * @param index position of the individual
	 * @return	individual at position index
	 */
	private Individual individualAt(int index) {
		return individuals.get(index);
	}

	/** 
	 * Return the fittest individual of the population
	 * @return the fittest individual
	 */
	public Individual fittestIndividual() {
		Individual fittest = individuals.get(0);
		for(Individual current : individuals) {
			if(current.fitness() > fittest.fitness()) fittest = current;
		}
		return fittest;
	}

	/**
	 * Should an elite be used in the algorithm?  
	 */
	private boolean shouldUseElistism() {
		return true;
	}
	
	/**
	 * @return the size of the population
	 */
	public int numberOfIndividuals() {
		return individuals.size();
	}
}