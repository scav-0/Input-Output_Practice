/**
 * 
 */
package dogs;

import java.util.Comparator;

/**
 * 
 */
public class compareHeight implements Comparator<Dog> {

	/**
	 * 
	 */
	public compareHeight() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Dog o1, Dog o2) {
		if (o1.getHeight() < o2.getHeight()) {
            return -1;
        } else if (o1.getHeight() > o2.getHeight()) {
            return 1;
        } else {
            return 0;
        }
	}

}
