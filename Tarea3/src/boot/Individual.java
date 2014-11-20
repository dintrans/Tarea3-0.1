package boot;

import java.util.ArrayList;
import java.util.List;

public abstract class Individual<T extends IGene> {
	/** Genotype of the individual */
	private List<T> genes;
	
	/** Rate for the crossover operation */
	private double uniformRate = 0.5;
	
	/** Rate for the mutation operation */
	private double mutationRate = 0.015;
	
	/** Length of the genotype */
	private int numberOfGenes = 64;
	
	/** Public constructor */
	public Individual() {
		genes = this.generateGenes();
	}
	
	/**
	 * Create a genotype, represented as a collection of 0 and 1 
	 * @return the genotype as a collection of T
	 */
	public abstract List<T> generateGenes();

	/**
	 * Perform the mutation operation. 
	 * The mutation is driven by the mutationRate value
	 */
	public void mutate() {
		for(int index = 0; index < this.numberOfGenes; index++)
			if(Math.random() < this.mutationRate) 
				this.geneAtPut(index, Math.random()>=0.5?1:0);
	}

	/**
	 * Perform the crossover operation. The receiver and argument of the message are the two parents
	 * @param individual Individual to which the crossover has to be performed.
	 * @return a new individual, result of the crossover operation
	 */
	public Individual crossOverWith(Individual individual) {
		Individual newIndividual = new Individual();
		for(int index = 0; index < this.numberOfGenes; index++)
			if(Math.random() < uniformRate )
				newIndividual.geneAtPut(index, this.geneAt(index));
			else
				newIndividual.geneAtPut(index, individual.geneAt(index));
		return newIndividual;
	}

	/**
	 * Set a new gene
	 * @param index position of the gene
	 * @param gene  gene to insert
	 */
	private void geneAtPut(Integer index, Integer gene) {
		genes.set(index, gene);
	}

	/**
	 * Return a gene of a given position
	 * @param index	position of the gene
	 * @return the gene located at position index
	 */
	private Integer geneAt(int index) {
		return genes.get(index);
	}

	/**
	 * Compute the fitness function for the individual
	 * @return a number. High number means fit, low number means unfit. Maximum is 64, minimum is 0
	 */
	public int fitness() {
		int score = 0;
		int[] solution = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
		
		for(int index = 0; index < this.numberOfGenes; index++)
			if(solution[index] == this.geneAt(index)) score ++;
		return score;
	}
	
	/**
	 * Return a textual version of the genotype. Useful for debugging and testing purposes
	 * @return a string, describing the genotype
	 */
	public String genesAsString() {
		StringBuilder sb = new StringBuilder();
		for(Integer i : genes) sb.append(i);
		return sb.toString();
	}
}
