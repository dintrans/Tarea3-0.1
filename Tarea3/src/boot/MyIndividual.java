package boot;

//import java.util.ArrayList;
//import java.util.List;

public class MyIndividual extends Individual<MyGene>{
	
	//private int amountOFGenes=8;
	//private double mutationFraction=0.015;
	//private double crossoverProportion=0.5;
	
	private String fittestWord="dintrans";
	
	public MyIndividual() {
		super(8,0.015,0.5);
	}

	@Override
	void mutate() {
		for(int index = 0; index < this.numberOfGenes; index++)
			if(Math.random() < this.mutationRate)
				genes.get(index).mutation();
	}

	@Override
	int fitness() {
		int k=0;
		for(int index = 0; index < this.numberOfGenes; index++){
			//System.out.println(index);
			if(this.genes.get(index).compareTo(fittestWord.charAt(index)+"")==0){
				k++;
			}
			//System.out.println(k);
		}
		return k;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int index = 0; index < this.numberOfGenes; index++){
			sb.append(this.genes.get(index).geneContent);
		}
		return sb.toString();
	}

	@Override
	Individual<MyGene> crossOverWith(Individual<MyGene> a) {
		MyIndividual answer = new MyIndividual();
		for(int index = 0; index < this.numberOfGenes; index++){
			if(Math.random() < this.crossoverRatio ){
				answer.genes.add(this.genes.get(index).getACopy());
			}
			else{
				answer.genes.add(a.genes.get(index).getACopy());
			}
		}
		return answer;
	}

	@Override
	void generateGenes() {
		for(int index = 0; index < this.numberOfGenes; index++){
			this.genes.add(new MyGene());
		}
	}

}
