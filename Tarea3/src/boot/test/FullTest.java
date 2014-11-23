/**
 * 
 */
package boot.test;

import static org.junit.Assert.*;
import org.junit.Test;

import boot.Main;

/**
 * Unit Test para la ejecución de un algoritmo genético de búsqueda de palabras.
 * @author dintrans(at)dcc
 *
 */
public class FullTest {

	/**
	 * Ejecuta un test probabilístico.
	 * Para ejecuciones de tan sólo 20 ciclos vitales, los genes logran ajustarse en mas del 80% de los casos
	 * Eso se considera aceptable, pero puede fallar por muy mala suerte.
	 */
	@Test
	public void ProbabilisticTest() {
		int k=0;
		for(int j=0;j<50;j++){
			Main.execute();
			String a = Main.pop.fittestIndividual().toString();
			String b = "dintrans";
			for(int i=0;i<8;i++){
				if(a.charAt(i)==b.charAt(i))k++;
			}
		}
		assertTrue((k/400.0)>0.8);
	}

}
