package boot;

public abstract class Gene<T> implements Comparable<T>{
	public abstract int compareTo(T arg0);
	public void mutation(){
		//TODO
	}
	abstract T generateGene();
}
