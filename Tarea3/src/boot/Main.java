package boot;

public class Main {

	public static <T> void main(String[] args) {
		// asdads
		Population<T> pop = new Population<T>();
		pop.createAndGenerateIndividual(50);
		
		for(int loop = 0; loop < 20; loop++) {
			System.out.println(pop.fittestIndividual().fitness());
			pop = pop.evolve();
		}
		System.out.println(pop.fittestIndividual().toString());
	}

}
