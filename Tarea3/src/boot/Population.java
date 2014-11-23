package boot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Population {
	/** List of individual making the population */
	private List<MyIndividual> individuals;
	
	private boolean elite = true;
	
	private int eliteSize = 1;
	
	/** Number of individuals that may form a tournament */
	private final int TOURNAMENT_SIZE = 5;
	
	/** 
	 * Create a list of individuals
	 * @param size	number of individual to consider
	 */
	public void create(int numberOfIndividuals) {
		individuals = new ArrayList<MyIndividual>();
		for(int i = 0; i < numberOfIndividuals; i++){
			individuals.add(new MyIndividual());
		}
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
		for(MyIndividual i : individuals)
			i.generateGenes();
	}
	
	/**
	 * Create a new population, fitter to solve the problem
	 * @return a new population with better individuals
	 */
	public Population evolve() {
		Population newPopulation = new Population();
		newPopulation.create(this.numberOfIndividuals());
		Collections.sort(this.individuals);
		if(this.elite){
			for(int i=0;i<this.eliteSize;i++){
				newPopulation.individualAtPut(i, this.individualAt(i));
			}
		}
		int elitismOffset = this.elite?this.eliteSize:0;
		//Loop over the population size and create new individual with crossover
		for(int index = elitismOffset; index < this.numberOfIndividuals(); index++) {
			MyIndividual newIndividual = (MyIndividual) this.tournamentSelection().crossOverWith(this.tournamentSelection()); //OJO, casteo feo, arreglar :(
			newPopulation.individualAtPut(index, newIndividual);
		}
		//Mutate population
		for(int index = elitismOffset; index < this.numberOfIndividuals(); index++){
			newPopulation.individualAt(index).mutate();
		}
		Collections.sort(newPopulation.individuals);
		return newPopulation;
	}

	/**
	 * Pick randomly some individuals from the population, and pick the fittest individual 
	 * @return the fittest individual from the subset of the population
	 */
	private MyIndividual tournamentSelection() {
		Population newPopulation = new Population();
		newPopulation.create(this.tournamentSize());
		for(int i = 0; i < this.tournamentSize(); i++) {
			int randomIndex = (int)(Math.random()*this.numberOfIndividuals());
			newPopulation.individualAtPut(i,this.individualAt(randomIndex));
		}
		Collections.sort(newPopulation.individuals);
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
	private void individualAtPut(int index, MyIndividual individual) {
		individuals.set(index, individual);
	}

	/**
	 * Return an individual
	 * @param index position of the individual
	 * @return	individual at position index
	 */
	private MyIndividual individualAt(int index) {
		return individuals.get(index);
	}

	/** 
	 * Return the fittest individual of the population
	 * @return the fittest individual
	 */
	public MyIndividual fittestIndividual() {
		return this.individualAt(0);
	}
	
	/**
	 * @return the size of the population
	 */
	public int numberOfIndividuals() {
		return individuals.size();
	}
}