package tourDeFrance;

import java.time.LocalTime;
import java.util.Comparator;

public class CompareTime implements Comparator<Cyclist> {

	public CompareTime() {
		
	}

	@Override
	public int compare(Cyclist o1, Cyclist o2) {
		LocalTime time1 = o1.getTime();
		LocalTime time2= o2.getTime();
		return time1.compareTo(time2);
		
	}

}
