/**
 * 
 */
package dogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 */
public class dogMain {
private static ArrayList<Dog> dogs= new ArrayList<Dog>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		readFile();
		drawMenu();
		
	}

	/**
	 * Please select an option:
1. Show all
2. Order and show by height (smallest first)
3. Order and show by weight (heaviest first)
4. Group and show by country (frequency of breeds from each country)
5. Exit
	 */
	private static void drawMenu() {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("DOG INFO MENU");
			System.out.println("=============");
			System.out.println("Please select an option:");
			System.out.println("1. Show all");
			System.out.println("2. Order and show by height (smallest first)");
			System.out.println("3. Order and show by weight (heaviest first)");
			System.out.println("4. Group and show by country (frequency of breeds from each country)");
			System.out.println("0. Exit");
			
			while(!sc.hasNextInt()) {
				System.out.println("Please enter a number");
				sc.next();
			}
			choice=sc.nextInt();
			
			switch(choice) {
			case 0:
				System.out.println("Goodbye");
				break;
			case 1:
				System.out.println("SHOW ALL");
				displayAll();
				break;
			case 2:
				System.out.println("SORTING BY HEIGHT");
				Collections.sort(dogs,new compareHeight());
				displayAll();
				break;
			case 3:
				System.out.println("SORTING BY WEIGHT");
				Collections.sort(dogs,new compareWeight());
				displayAll();
				break;
			case 4:
				groupByCountry();
				break;
			default:
				System.out.println("INVALID OPTION - TRY AGAIN");
			}
		}while(choice!=0);
		sc.close();
	}

	private static void groupByCountry() {
		HashMap<String, Integer> frequency = new HashMap<String, Integer>();
		ArrayList<String> countries = new ArrayList<String>();
		for(Dog dog: dogs) {
			if(!frequency.containsKey(dog.getCountryOfOrigin())){
				frequency.put(dog.getCountryOfOrigin(), 1);
			}else {
				frequency.put(dog.getCountryOfOrigin(), frequency.get(dog.getCountryOfOrigin())+1);
			}
		}
		for(String country:frequency.keySet()) {
			countries.add(country);
		}
		Collections.sort(countries);
		System.out.println("FREQUENCY");
		for(String country:countries) {
			String gap=(country.length()>7)?"\t":"\t\t";
			System.out.println(country+" "+gap+frequency.get(country));
		}
		
	}

	private static void displayAll() {
		
		for (Dog dog: dogs) {
			dog.displayAll();
		}
		
	}

	private static void readFile() {
		File file = new File("DogData.csv");
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			br.readLine();
			String nextLine = br.readLine();
			while(nextLine!=null) {
				String[] parsed = nextLine.split(",");
				if(parsed.length>=6) {
					Dog dog = new Dog();
					dog.setBreed(parsed[0]);
					dog.setColour(parsed[4]);
					dog.setCountryOfOrigin(parsed[5]);
					try {
						dog.setWeight(Double.parseDouble(parsed[1]));
						dog.setHeight(Double.parseDouble(parsed[2]));
						dog.setLifeExpectency(Double.parseDouble(parsed[3]));
						
					}catch(NumberFormatException e) {
						System.err.println("ERROR PARSING FROM STRING "+nextLine);
						nextLine=br.readLine();
						continue;
					}
					dogs.add(dog);
					
				}else {
					System.err.println("ERROR WITH PARSING INTO ARRAY: "+nextLine);
				}
				nextLine=br.readLine();
			}
			
			
			
			
		}catch(IOException e) {
			System.err.println("ERROR READING FILE ");
			e.printStackTrace();
		}
	}

}
