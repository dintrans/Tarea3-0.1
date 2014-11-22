package boot;

public abstract class Gene<T> implements Comparable<T>{
	T geneContent;
	
	public abstract int compareTo(T arg0);
	abstract T generateGene();
	
	void mutation(){
		this.geneContent=this.generateGene();
	}
	
	public Gene(){
		this.geneContent=this.generateGene();
	}
	
	public abstract Gene<T> getACopy();
}
