package arsenalChallenge;

public class Team {
	private int goalsFor;
	private int goalsAgainst;
	private String teamName;
	private int wins;
	private int losses;
	private int draws;
	
	
	public Team() {
		this.wins=0;
		this.losses=0;
		this.draws=0;
		this.goalsAgainst=0;
		this.goalsFor=0;
	}
	
	


	/**
	 * @param teamName
	 */
	public Team(String teamName) {
		
		this.teamName = teamName;
		this.wins=0;
		this.losses=0;
		this.draws=0;
		this.goalsAgainst=0;
		this.goalsFor=0;
	}




	/**
	 * @return the totalGamesPlayed
	 */
	public int getTotalGamesPlayed() {
		return this.wins+this.losses+this.draws;
	}


	

	/**
	 * @return the goalsFor
	 */
	public int getGoalsFor() {
		return goalsFor;
	}


	/**
	 * @param goalsFor the goalsFor to set
	 */
	public void setGoalsFor(int goalsFor) {
		this.goalsFor+=goalsFor;
	}


	/**
	 * @return the goalsAgainst
	 */
	public int getGoalsAgainst() {
		return goalsAgainst;
	}


	/**
	 * @param goalsAgainst the goalsAgainst to set
	 */
	public void setGoalsAgainst(int goalsAgainst) {
		this.goalsAgainst += goalsAgainst;
	}


	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}


	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	/**
	 * @return the wins
	 */
	public int getWins() {
		return wins;
	}


	/**
	 * @param wins the wins to set
	 */
	public void incrementWins() {
		this.wins +=1;
	}


	/**
	 * @return the losses
	 */
	public int getLosses() {
		return losses;
	}


	/**
	 * @param losses the losses to set
	 */
	public void incrementLosses() {
		this.losses +=1;
	}


	/**
	 * @return the draws
	 */
	public int getDraws() {
		return draws;
	}


	/**
	 * @param draws the draws to set
	 */
	public void incrementDraws() {
		this.draws+=1;
	}
	
	public int getPoints() {
		return this.wins*3 + this.draws;
	}
	
	
	public void displayAllVertical() {
		System.out.println("Team name:     "+this.teamName);
		System.out.println("Total games:   "+this.getTotalGamesPlayed());
		System.out.println("Wins:          "+this.wins);
		System.out.println("Losses:        "+this.losses);
		System.out.println("Draws:         "+this.draws);
		System.out.println("Goals for:     "+this.goalsFor);
		System.out.println("Goals against: "+this.goalsAgainst);
		System.out.println();
	}
	
	public void displayAllOneLine() {
		String gap =(this.teamName.length()>6)?"  \t":"  \t\t";
		System.out.println(this.teamName +gap+this.getTotalGamesPlayed()+"      "+this.goalsFor+"   "+this.goalsAgainst+"     \t"+this.wins+" "+this.losses+" "+this.draws+"\t"+this.getPoints());
	}


}
