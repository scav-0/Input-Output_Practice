package tourDeFrance;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ReadFileTourDeFrance {
	public static ArrayList<Cyclist> cyclists = new ArrayList<Cyclist>();

	public static void main(String[] args) {
		readFile();
		drawMenu();
//		displayAll();
	}

	private static void drawMenu() {
		/**
		 * Please select an option: 1. Show results - ordered by time (faster stage time
		 * first etc) 2. Update rider time (add 5 mins penalty) - using Matthew Collins
		 * as example 3. Output to file (using separte Thread) all riders that are +30
		 * minutes (inclusive) after the winners time. 0. Quit
		 */
		Scanner scanner = new Scanner(System.in);
		int choice;
		do {
			System.out.println();
			System.out.println("TOUR DE FRANCE DATA MENU\n========================");
			System.out.println("1. Show results - ordered by time");
			System.out.println("2. Update rider time (add 5 mins penalty)");
			System.out.println("3. Output to file all riders that are +30 minutes after the winners time.");
			System.out.println("0. Quit");
			System.out.println();
			System.out.println("Enter choice!");
			while (!scanner.hasNextInt()) {
				System.out.println("Enter a number dingus");
				scanner.next();
			}
			choice = scanner.nextInt();

			switch (choice) {
			case 0:
				System.out.println("Goodbye..");
				break;
			case 1:
				System.out.println("SHOW RESULTS - ORDERED BY TIME");
				System.out.println();
				Collections.sort(cyclists, new CompareTime());
				displayAll();
				break;
			case 2:
				System.out.println("UPDATE RIDER TIME");
				updateRiderTime("Matthew Collins");
				break;
			case 3:
				System.out.println("WRITE TO FILE");
				runThread();
				break;
			default:
				System.out.println("Not a valid option fella - try again");
			}
		} while (choice != 0);
		scanner.close();
	}

	private static void runThread() {
		Thread thread = new Thread(new WriteCyclists(cyclists));
		thread.run();
	}

	private static void updateRiderTime(String name) {
		String[] names = name.split(" ");
		for (Cyclist cyclist : cyclists) {
			if (cyclist.getFirstName().equals(names[0])) {
				cyclist.setTime(cyclist.getTime().plusMinutes(5));
				System.out.println(name + " time update");
				System.out.println("New Time: " + cyclist.getTime());
				break;
			}
		}

	}

	private static void displayAll() {
		for (Cyclist cyclist : cyclists) {
			cyclist.display();
		}
	}

	/**
	 * Method for reading through file and turning the data into Cyclist objects
	 * objects are then added to the cyclists arraylist method skips any lines that
	 * dont split correctly
	 */
	private static void readFile() {
		File file = new File("stage_results-1.csv");
		// First Name,Last Name,Nationality,Team Abbreviation,Time
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();// SKIP HEADER
			String nextLine = br.readLine();
			while (nextLine != null) {
				String[] data = nextLine.split(",");
				if (data.length == 5) {
					if (data[3].equals("Microsoft")) {
						System.err.println("SKIPPING " + data[0] + " " + data[1] + ", MICROSOFT");
						nextLine = br.readLine();
						continue;
					}
					Cyclist cyclist = new Cyclist();
					cyclist.setFirstName(data[0]);
					cyclist.setLastName(data[1]);
					cyclist.setNationality(data[2]);
					cyclist.setTeamAbbr(data[3]);
					try {
						String[] time = data[4].split(":");
						if (time.length >= 3) {
							LocalTime result = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]),
									Integer.parseInt(time[2]));
							cyclist.setTime(result);
						} else {
							System.err.println("ERROR WITH TIME ARRAY LENGTH - SKIPPING");
							nextLine = br.readLine();
							continue;
						}
					} catch (NumberFormatException e) {
						System.err.println("ERROR WITH TIME - SKIPPING ENTRY");
						nextLine = br.readLine();
						continue;
					}

					cyclists.add(cyclist);
				} else {
					System.err.println("ERROR WITH SPLITTING: " + nextLine);
				}
				nextLine = br.readLine();
			}
		} catch (IOException e) {
			System.err.println("ERROR READING FILE");
			e.printStackTrace();
		}

	}

}
