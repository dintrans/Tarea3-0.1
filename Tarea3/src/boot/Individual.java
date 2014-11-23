package boot;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public int compareTo(Individual<T> arg) {
		return arg.fitness()-this.fitness();
	}
	
	abstract void generateGenes();

}
