package boot;

import java.util.ArrayList;
import java.util.List;

public abstract class Individual<T extends Gene<?>> {
	List<T> genes;
	
	abstract void mutate();
	abstract int fitness();
	public abstract String toString();
	abstract Individual<T> crossOver(Individual<T> a);
}
