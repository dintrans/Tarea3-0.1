package boot;

/**
 * Clase principal que permite la ejecución del algoritmo genético para proximidad de palabras
 * @author dintrans(at)dcc
 * @version 0.1.3
 */
public class Main {

	/**
	 * Ejecuta un algoritmo genético para la proximidad de palabras
	 * @param args Pila de variables de ejecución de la consola
	 */
	public static void main(String[] args) {
		Population pop = execute();
		System.out.println(pop.fittestIndividual().toString());
	}

	/**
	 * Crea una poblacion de 50 palabras y las hace evolucionar durante 20 ciclos vitales.
	 * @return Una poblacion evolucionada
	 */
	public static Population execute() {
		Population pop = new Population();
		pop.createAndGenerateIndividual(50);
		
		for(int loop = 0; loop < 20; loop++) {
			//System.out.println("Loop: "+loop);
			//System.out.println(pop.fittestIndividual().toString());
			//System.out.println(pop.fittestIndividual().fitness());
			pop = pop.evolve();
		}
		return pop;
	}

}
