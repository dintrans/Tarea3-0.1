package boot;

public class Maze extends Individual<Cell>{

	//private int amountOFGenes=100;
	//private double mutationFraction=0.015;
	//private double crossoverProportion=0.5
	
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
