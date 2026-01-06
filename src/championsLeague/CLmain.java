/**
 * 
 */
package championsLeague;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class CLmain {

	public static ArrayList<WinningTeam> chickenDinners = new ArrayList<WinningTeam>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readFile();
		
		drawMenu();

		System.out.println("APP CLOSING...");
	}
	
	/**
	 * 1. Print all winners
2. Filter by team name
3. Filter by country
0. Exit
	 */
	private static void drawMenu() {
		int choice;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("========CHAMPIONS LEAGUE DATABASE========\n");
			System.out.println("1. Print all winners");
			System.out.println("2. Filter by team name");
			System.out.println("3. Filter by country");
			System.out.println("0. Exit");
			System.out.println("\nEnter Choice: ");
			
			while(!scanner.hasNextInt()) {
				System.out.println("Not and int, try again!");
				scanner.next();//REMEMBER
			}
			choice=scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {
			case 1:
				printWinners();
				break;
			case 2:
				System.out.println("Filter by team name\nEnter team name:");
				String teamName= scanner.nextLine();
				ArrayList<WinningTeam> resultsTeam = filterTeam(teamName);
				
				printResults(resultsTeam);
				break;
			case 3: 
				System.out.println("Filter by country\nEnter country:");
				String country= scanner.nextLine();
				ArrayList<WinningTeam> resultsCountry = filterCountry(country);
				
				printResults(resultsCountry);
				break;
			case 0:
				System.out.println("GOODBYE");
				break;
			default:
				System.out.println("Not an option - try again");
			}
			try {
				Thread.sleep(250);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}while(choice!=0);
		scanner.close();
	}

	
	

	private static ArrayList<WinningTeam> filterCountry(String country) {
		ArrayList<WinningTeam> results = new ArrayList<WinningTeam>();
		country=country.trim();
		if(country.length()>0) {
			for(WinningTeam winners : chickenDinners) {
				if(winners.getCountry().equalsIgnoreCase(country)) {
					results.add(winners);
				}
			}
		}else {
			System.err.println("ENTERED NOTHING");
		}

		return results;
	}

	/**
	 * class to read data from csv file and store into chickenDinners array list
	 * should skip line if not enough data or if not a number at start
	 */
	public static void readFile(){
		File file = new File("champions_league_winners.csv");
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			//try with resources - closes for you
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr);
//			
			br.readLine();
			String nextLine = br.readLine();
			
			while((nextLine=br.readLine())!=null) {
				try {
					String[] parsed = nextLine.split(",");
					if(parsed.length>=3) {
						chickenDinners.add(new WinningTeam(Integer.parseInt(parsed[0]), parsed[1], parsed[2]));
					}else {
						System.err.println("Error with parsed length");
					}
				}catch(NumberFormatException e) {
					System.err.println("Error with year processing");
				}
//				nextLine= br.readLine();
			}
			
//			br.close();
//			fr.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void printWinners() {
		for(WinningTeam winners : chickenDinners) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			winners.displayYearTeam();
			System.out.println();
		}
		
	}
	
	public static void printResults(ArrayList<WinningTeam> results) {
		if(results.size()>0) {
		for(WinningTeam winner : results) {
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			winner.displayAll();
			System.out.println();
		}
		}else {
			System.out.println("No results");
		}
	}
	
	public static ArrayList<WinningTeam> filterTeam(String teamKey){
		ArrayList<WinningTeam> results = new ArrayList<WinningTeam>();
		teamKey=teamKey.trim();
		if(teamKey.length()>0) {
			for(WinningTeam winners : chickenDinners) {
				if(winners.getTeamName().equalsIgnoreCase(teamKey)) {
					results.add(winners);
				}
			}
		}else {
			System.err.println("ENTERED NOTHING ");
		}

		return results;
	}
	
	
	
	
}
