package boot;

import java.util.Random;
/**
 * Clase que guarda un gen específico para el agoritmo genetico de proximidad de palabras
 * @author dintrans(at)dcc
 * @version 0.1.2
 */
public class MyGene extends Gene<String>{
	
	/**
	 * Produce la mutación aleatoria del gen actual
	 */
	@Override
	public void mutation() {
		this.geneContent=this.getRandomCharacter()+"";
	}

	/**
	 * Genera un caracter aleatorio para un gen y lo devuelve
	 * @return caracter aleatorio
	 */
	@Override
	String generateGene() {
		String c=this.getRandomCharacter()+"";
		return c;
	}

	/**
	 * Compara lexicográficamente dos genes
	 * @param arg Segundo gen a comparar
	 * @return la diferencia computada entre los genes
	 */
	@Override
	public int compareTo(String arg) {
		return this.geneContent.compareTo(arg);
	}
	
	private char getRandomCharacter(){
		Random r = new Random();
		char c = (char)(r.nextInt(26) + 'a');
		return c;
	}

	/**
	 * Devuelve una copia del gen actual
	 * @return Una copia del gen actual.
	 */
	@Override
	public MyGene getACopy() {
		MyGene tmp = new MyGene();
		tmp.geneContent=this.geneContent;
		return tmp;
	}

}
