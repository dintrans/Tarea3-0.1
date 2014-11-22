package boot;

import java.util.Random;

public class MyGene extends Gene<String>{
	
	@Override
	public void mutation() {
		this.geneContent=this.getRandomCharacter()+"";
	}

	@Override
	String generateGene() {
		String c=this.getRandomCharacter()+"";
		return c;
	}

	@Override
	public int compareTo(String arg) {
		return this.geneContent.compareTo(arg);
	}
	
	private char getRandomCharacter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		return c;
	}

	@Override
	public MyGene getACopy() {
		MyGene tmp = new MyGene();
		tmp.geneContent=this.geneContent;
		return tmp;
	}

}
