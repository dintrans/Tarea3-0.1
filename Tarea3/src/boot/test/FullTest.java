/**
 * 
 */
package boot.test;

import static org.junit.Assert.*;
import org.junit.Test;

import boot.Main;

/**
 * Unit Test para la creación de 
 * @author dintrans(at)dcc
 *
 */
public class FullTest {

//	/**
//	 * @throws java.lang.Exception
//	 */
//	@Before
//	public void setUp() throws Exception {
//		Main.execute();
//	}

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
		assertTrue((k/400.0)>0.8); //los genes logran ajustarse, en sólo 20 ciclos, en más de un 80% de los casos. Eso se considera aceptable.
	}

}
