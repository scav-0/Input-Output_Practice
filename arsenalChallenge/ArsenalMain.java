package arsenalChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ArsenalMain {
	private static Map<String, Team> teams = new HashMap<String, Team>();
	private static ArrayList<Team> teamsList = new ArrayList<Team>();
	public static void main(String[] args) {
		
		readFile();
		
		for(String key: teams.keySet()) {
			teamsList.add(teams.get(key));
		}
		
		Collections.sort(teamsList,new ComparePoints());
		displayAll();
	}
	
	public static void displayAll() {
		System.out.println("TEAM   \t\tTotal  For Against \tW D L \tPoints");
		for(Team team: teamsList) {
			team.displayAllOneLine();
		}
	}
	
	
	public static void readFile() {
		File file = new File("Results.txt");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			
			String nextLine=br.readLine();;
			while(nextLine!=null) {
			
			String[] parsed = nextLine.split(" ");
			//want to catch all errors
			//start with this array - we assume it is at least 4 long
			if(parsed.length>=4) {
				String forTeamName = parsed[0].trim();
				//catch parse error
				try {
					int forScore= Integer.parseInt(parsed[1]);
					int againstScore = Integer.parseInt(parsed[2]);
					String againstTeamName = parsed[3].trim();
					//is team in list
					if(!teams.containsKey(againstTeamName)) {
						teams.put(againstTeamName, new Team(againstTeamName));
					}
					if(!teams.containsKey(forTeamName)) {
						teams.put(forTeamName, new Team(forTeamName));
					}
					
					//Recording wins and losses for teams
					if(forScore>againstScore) {
						teams.get(forTeamName).incrementWins();;
						teams.get(againstTeamName).incrementLosses();;
					}else if(againstScore>forScore) {
						teams.get(againstTeamName).incrementWins();;
						teams.get(forTeamName).incrementLosses();;
					}else {
						teams.get(againstTeamName).incrementDraws();
						teams.get(forTeamName).incrementDraws();
					}
					
					//recording goals for teams
					teams.get(forTeamName).setGoalsFor(forScore);
					teams.get(againstTeamName).setGoalsAgainst(againstScore);
					
				}catch(NumberFormatException e) {
					System.err.println("Error parsing int - skipping :"+nextLine);
					nextLine= br.readLine();
					continue;
				}
				
			
			}else {
				System.err.println("Error - skipping one :"+nextLine);
				
			}
			nextLine= br.readLine();
			};
			
		}catch(IOException e){
			System.err.println("Error reading file");
			e.printStackTrace();
		}
		
		
	}
	

}
