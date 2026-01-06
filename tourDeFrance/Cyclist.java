package tourDeFrance;

import java.time.LocalTime;

public class Cyclist {
	private String firstName;
	private String lastName;
	private String nationality;
	private String teamAbbr;
	private LocalTime time;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the teamAbbr
	 */
	public String getTeamAbbr() {
		return teamAbbr;
	}
	/**
	 * @param teamAbbr the teamAbbr to set
	 */
	public void setTeamAbbr(String teamAbbr) {
		this.teamAbbr = teamAbbr;
	}
	/**
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	public void display() {
		System.out.println("Name : "+this.firstName+" "+this.lastName);
		System.out.println("Nationality : " + this.nationality);
		System.out.println("Team Abbreviation : "+this.teamAbbr);
		System.out.println("Time : "+this.time);
		System.out.println();
	}
}
