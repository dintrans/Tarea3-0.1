package boot;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que guarda individuos hechos de genes genéricos
 * @author dintrans(at)dcc
 * @version 0.1.3
 */
public abstract class Individual<T extends Gene<?>> implements Comparable<Individual<T>> {
	List<T> genes;
	int numberOfGenes;
	double mutationRate;
	double crossoverRatio;
	
	
	abstract void mutate();
	protected abstract int fitness();
	public abstract String toString();
	abstract Individual<T> crossOverWith(Individual<T> a);
	public Individual(int n,double MutRate,double cRatio){
		this.numberOfGenes=n;
		this.mutationRate=MutRate;
		this.crossoverRatio=cRatio;
		this.genes=new ArrayList<T>();
	}
	
	/**
	 * Compara dos individuos según su aptitud evolutiva
	 * @param arg Segundo individuo a comparar
	 * @return la diferencia computada entre los individuos
	 */
	@Override
	public int compareTo(Individual<T> arg) {
		return arg.fitness()-this.fitness();
	}
	
	abstract void generateGenes();

}
