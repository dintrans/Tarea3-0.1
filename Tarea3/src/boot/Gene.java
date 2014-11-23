package boot;

/**
 * Clase abstracta que guarda un gen genérico
 * @author dintrans(at)dcc
 * @version 0.1.2
 */
public abstract class Gene<T> implements Comparable<T>{
	T geneContent;
	
	/**
	 * Compara lexicográficamente dos genes
	 * @param arg0 Segundo gen a comparar
	 * @return la diferencia computada entre los genes
	 */
	public abstract int compareTo(T arg0);
	abstract T generateGene();
	
	void mutation(){
		this.geneContent=this.generateGene();
	}
	
	/**
	 * Constructor de un gen seteado con el generador de genes definido
	 */
	public Gene(){
		this.geneContent=this.generateGene();
	}
	
	/**
	 * Entrega una copia del gen actual
	 * @return Copia del gen actual
	 */
	public abstract Gene<T> getACopy();
}
