package beer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class beerMain {
	private static final String fileName="beer_data.csv";
	private static final double PERCENTAGE = 6.0;
	private static ArrayList<Beer> beers = new ArrayList<Beer>();
	public static void main(String[] args) {
		readBeerData();
		/**
		Please select an option:
		1. Show all beers
		2. Order by name
		3. Output to file all beers over 6% alcohol percentage
		4. Quit
		*/
		showMenu();
//		displayBeers();
	}

	
	private static void showMenu() {
		int choice;
		Scanner scanner = new Scanner(System.in);
		do {
			try {
				Thread.sleep(750);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("BEERS");
			System.out.println("==================");
			System.out.println("Please select an option:\n1. Show all beers\n2. Order by name\n3. Output to file all beers over 6% alcohol percentage\n0. Quit");
			
			while(!scanner.hasNextInt()) {
				System.out.println("Enter a number");
				scanner.next();
			}
			choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("DISPLAY ALL BEERS");
				displayBeers();
				break;
			case 2:
				orderByName();
				break;
			case 3:
				writeToFile();
				break;
			case 0:
				break;
			default:
				
			
			}
		}while(choice!=0);
		scanner.close();
	}


	private static void writeToFile() {
		System.out.println("WRITING TO FILE");
		File file = new File("outputBeers.txt");
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
			for(Beer beer: beers) {
				if(beer.getPercentage()>=PERCENTAGE){
					bw.write(beer.getName()+"\n");
				}
			}
			System.out.println("IT IS WROTE");
		}catch(IOException e) {
			System.err.println("ERROR WRITING TO FILE");
			e.printStackTrace();
		}
		
	}


	private static void orderByName() {
		System.out.println("SORTING BEERS....");
		try {
			Thread.sleep(500);
			System.out.println(".......");
			Thread.sleep(500);
			Collections.sort(beers,new BeerCompareName());
			System.out.println("SORTED");
		}catch(InterruptedException e) {
			e.printStackTrace();
			System.err.println("UH OH");
		}
		
		
	}


	private static void displayBeers() {
		for(Beer beer : beers) {
			beer.displayAll();
		}
	}
	
	private static void readBeerData() {
		File file = new File(fileName);
//		if(file.exists()) {
//			System.out.println("EXISTS");
//		}
		//Beer Name,Beer Style,Country,Alcohol Percentage
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			br.readLine();
			String nextLine = br.readLine();
		
			while(nextLine!=null) {
				String[] data = nextLine.split(",");
				Beer beer = new Beer();
				if(data.length>=4) {
					beer.setName(data[0]);
					beer.setStyle(data[1]);
					beer.setCountry(data[2]);
					try {
						beer.setPercentage(Double.parseDouble(data[3]));
					}catch(NumberFormatException e) {
						System.err.println("Error with percentage, skipping :"+data[3]);
						nextLine=br.readLine();
						continue;
					}
					
					beers.add(beer);
					
				}else {
					System.err.println("error with array length"+ nextLine);
				}
				nextLine=br.readLine();
			}
			
			
			
		}catch(IOException e) {
			System.err.println("Error Reading file");
			e.printStackTrace();
		}
	}

}
