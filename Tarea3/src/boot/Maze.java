package boot;

/**
 * Clase que guarda individuos (Cuasi-Soluciones de un laberinto) para la resolución del mismo mediante un algoritmo genético
 * @author dintrans(at)dcc
 * @version 0.1.3
 */
public class Maze extends Individual<Cell>{

	//private int amountOFGenes=100;
	//private double mutationFraction=0.015;
	//private double crossoverProportion=0.5
	
	/**
	 * Construye un laberinto con los siguientes parametros:
	 * Tanaño: 100 cuadros (10x10)
	 * Probabilidad de mutación: 1.5%
	 * Proporcion de cruce: 50/50
	 * @return la diferencia computada entre los genes
	 */
	public Maze() {
		super(100, 0.015, 0.5);
	}

	@Override
	void mutate() {
		for(int index = 0; index < this.numberOfGenes; index++)
			if(Math.random() < this.mutationRate)
				genes.get(index).mutation();
	}

	@Override
	protected int fitness() {
		// TODO Calcular proximidad a la salida?
		return 0;
	}

	/**
	 * Devuelve una representación fisica del laberinto
	 * @return String que contiene una representacion fisica del laberinto
	 */
	@Override
	public String toString() {
		return "";
	}

	@Override
	Individual<Cell> crossOverWith(Individual<Cell> a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void generateGenes() {
		// TODO Auto-generated method stub
		
	}

}
