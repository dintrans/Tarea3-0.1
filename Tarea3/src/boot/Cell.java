package boot;

/**
 * Clase que guarda genes (Celdas de un laberinto) para su resolución mediante un algoritmo genético
 * @author dintrans(at)dcc
 * @version 0.1.3
 */
public class Cell extends Gene<int[]>{

	/**
	 * Compara dos genes según su capacidad de resolver el laberinto
	 * @param arg Segundo gen a comparar
	 * @return la diferencia computada entre los genes
	 */
	@Override
	public int compareTo(int[] arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int[] generateGene() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Obtiene una copia del gen actual
	 * @return una copia del gen actual
	 */
	@Override
	public Gene<int[]> getACopy() {
		Cell tmp = new Cell();
		tmp.geneContent=this.geneContent;
		return tmp;
	}

}
