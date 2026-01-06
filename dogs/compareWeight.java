package dogs;

import java.util.Comparator;

public class compareWeight implements Comparator<Dog> {

	public compareWeight() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Dog o1, Dog o2) {
		if (o1.getWeight() < o2.getWeight()) {
            return 1;
        } else if (o1.getWeight() > o2.getWeight()) {
            return -1;
        } else {
            return 0;
        }
	}

}
