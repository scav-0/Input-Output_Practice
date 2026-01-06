package championsLeague;

public class WinningTeam {
	private int year;
	private String teamName;
	private String country;
	
	public WinningTeam() {
		
	}
	
	/**
	 * @param year
	 * @param teamName
	 * @param country
	 */
	public WinningTeam(int year, String teamName, String country) {
		this.year = year;
		this.teamName = teamName;
		this.country = country;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
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
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	public void displayAll() {
		System.out.println(this.year+" - "+this.teamName+" ("+country+")");
	}
	
	public void displayYearTeam() {
		System.out.println(this.year+" - "+this.teamName);
	}
}
