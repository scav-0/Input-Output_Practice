/**
 * 
 */
package packageDryRun;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */
public class FileReading {

	private static ArrayList<BusRoute> routes = new ArrayList<BusRoute>();

	/**
	 * routeId,departureStop,arrivalStop,travelMinutes,operator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		readBusJourneys();

		drawMenu();

		System.out.println("Journey app done");
//		for (BusRoute route : routes) {
//			route.displayAll();
//		}
//		
		// show menu

		// 1. show all routes
		// 2. show a destination - show all routes to destination
		// 0. exit

	}

	private static void drawMenu() {

		System.out.println("MENU");

		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("\n___________________________");
			System.out.println("Route menu");
			System.out.println("1. Show all routes");
			System.out.println("2. Search for destination");
			System.out.println("0. Quit");
			System.out.println();
			System.out.print("Enter choice: ");
			/**
			 * this is important!!
			 */
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a number: ");
				sc.next();
			}
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				displayBusRoutes();
				break;
			case 2:

				System.out.print("Enter destination to search for: ");
				String dest = sc.nextLine().trim();

				if (dest.length()>0) {
					List<BusRoute> destinations = searchForDestination(dest);

					if (destinations.size() == 0) {
						System.out.println("No routes to " + dest);
					} else {
						for (BusRoute busRoute : destinations) {
							busRoute.displayAll();
							try {
								Thread.sleep(250);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}else {
					System.out.println("Cant search for nothing - try again");
					
				}
				break;

			case 0:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid option, try again");
			}

			System.out.println();

		} while (choice != 0);
		sc.close();
	}

	private static void displayBusRoutes() {

		for (BusRoute route : routes) {
			route.displayAll();
			try {
				Thread.sleep(250);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static List<BusRoute> searchForDestination(String dest) {
		List<BusRoute> answers = new ArrayList<BusRoute>();
		for (int index = 0; index < routes.size(); index++) {

			if (routes.get(index).getArrival().equalsIgnoreCase(dest)) {
				answers.add(routes.get(index));
			}
		}
		return answers;
	}

	private static void readBusJourneys() {
		File file = new File("FILES/routes.csv");

		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			br.readLine();
			String newLine = br.readLine();

			while (newLine != null) {
				String[] parsed = newLine.split(",");
				if (parsed.length >= 5) {
					BusRoute busRoute = new BusRoute();
					try {
						busRoute.setRouteID(Integer.parseInt(parsed[0]));

					} catch (NumberFormatException e) {
						System.err.println("Error with route ID");
						newLine = br.readLine();
						continue;
					}

					busRoute.setDeparture(parsed[1]);
					busRoute.setArrival(parsed[2]);

					/**
					 * important
					 */
					try {
						busRoute.setTravelMinutes(Integer.parseInt(parsed[3]));
					} catch (NumberFormatException e) {
						System.err.println("Error with travel time");
						newLine = br.readLine();
						continue;
					}
					busRoute.setOperator(fromString(parsed[4]));

					routes.add(busRoute);
				} else {
					System.err.println("Error with parsed len");
				}
				newLine = br.readLine();

			}
			fr.close();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Operator fromString(String operator) {
		switch (operator) {
		case "Bus Eireann":
			return Operator.BUS_EIREANN;

		case "Translink":
			return Operator.TRANSLINK;

		case "Ulsterbus":
			return Operator.ULSTERBUS;

		default:
			return Operator.OTHER;
		}
	}
}
