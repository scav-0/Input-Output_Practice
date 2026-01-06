package arsenalChallenge;

import java.util.Comparator;

public class ComparePoints implements Comparator<Team> {


	@Override
	public int compare(Team o1, Team o2) {
		int o1Points=o1.getPoints(), o2Points=o2.getPoints();
		
		return Integer.compare(o1Points, o2Points);
	}

}
