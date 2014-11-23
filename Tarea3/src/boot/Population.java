package boot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que pobla el algoritmo genético de proximidad de palabras y otorga funciones evolutivas. Se pudo refactorizar, pero no se hizo
 * @author dintrans(at)dcc
 * @version 0.1.3
 */
public class Population {
	/** List of individual making the population */
	private List<MyIndividual> individuals;
	
	private boolean elite = true;
	
	private int eliteSize = 1;
	
	/** Number of individuals that may form a tournament */
	private final int TOURNAMENT_SIZE = 5;
	
	/** 
	 * Crea una lista de individuos
	 * @param numberOfIndividuals numero de individuos que tendrá la lista
	 */
	public void create(int numberOfIndividuals) {
		individuals = new ArrayList<MyIndividual>();
		for(int i = 0; i < numberOfIndividuals; i++){
			individuals.add(new MyIndividual());
		}
	}
	
	/**
	 * Crea individuos y genera sus genotipos para cada uno
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
	 * Crea una nueva población a partir de la evolución de a actual
	 * @return una nueva población más evolucionada
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
	 * Retorna el individuo mas apto de la población
	 * @return el individuo mas apto
	 */
	public MyIndividual fittestIndividual() {
		return this.individualAt(0);
	}
	
	/**
	 * Retorna el tamaño de la población
	 * @return El tamaño de la población
	 */
	public int numberOfIndividuals() {
		return individuals.size();
	}
}