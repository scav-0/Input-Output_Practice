/**
 * 
 */
package beer;

import java.util.Comparator;

/**
 * 
 */
public class BeerCompareName implements Comparator<Beer> {

	/**
	 * 
	 */
	public BeerCompareName() {
		
	}

	@Override
	public int compare(Beer o1, Beer o2) {
		String name1 = o1.getName();
		String name2 = o2.getName();
		return name1.compareTo(name2);
	}

}
