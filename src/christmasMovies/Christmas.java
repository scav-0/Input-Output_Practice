package christmasMovies;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class Christmas {
	public static ArrayList<Movie> movies = new ArrayList<Movie>();

	public static void main(String args[]) {
		try {
			readFile();
			drawMenu();
		} catch (Exception e) {
			System.out.println("Problem");
		}
	}

	private static void drawMenu() {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {

			System.out.println("\n___________________________");
			System.out.println("Movies menu");
			System.out.println("1. Show all movies");
			System.out.println("2. x");
			System.out.println("3. y");
			System.out.println("0. Quit");
			System.out.println();
			System.out.print("Enter choice: ");

			// check for int entry
			while (!sc.hasNextInt()) {
				System.out.print("Please enter a number: ");
				sc.next(); // discard invalid input
			}
			choice = sc.nextInt();
			sc.nextLine(); // clear newline

			switch (choice) {
			case 1:
				showAllMovies();
				break;
			case 2:

				break;
			case 3:

				break;
			case 0:
				System.out.println("Goodbye!");
				break;
			default:
				System.out.println("Invalid choice — try again.");
				break;
			}

			System.out.println(); // spacing

		} while (choice != 0);

		sc.close();
	}

	private static void showAllMovies() {
		for(Movie movie: movies) {
			movie.display();
		}
		
	}

	private static void readFile() {
		File file = new File("christmas_movies.csv");
		// MovieId,Title,Year,Rating,Genre,FamilyFriendly

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			System.out.println(br.readLine());
			String nextLine = br.readLine();
			while (nextLine != null) {
				String[] data = nextLine.split(",");
				if (data.length == 6) {
					// start with String values
					Movie movie = new Movie();
					movie.setTitle(data[1]);
					try {
						movie.setMovieId(Integer.parseInt(data[0]));
						movie.setYear(Integer.parseInt(data[2]));
						movie.setFamilyFriendly(BooleanfromString(data[5]));
						movie.setRating(RatingfromString(data[3]));
						movie.setGenre(GenreFromString(data[4]));
						movies.add(movie);
					} catch (NumberFormatException e) {
						System.err.println("error parsing int: " + nextLine);
						nextLine = br.readLine();
						continue;
					} catch (DataFormatException e) {
						System.err.println(e.getMessage() + " : " + nextLine);
						nextLine = br.readLine();
						continue;
					}

				} else {
					System.err.println("Error with splitting: " + nextLine);
				}
				nextLine = br.readLine();
			}
		} catch (IOException e) {
			System.err.println("Error reading file");
		}
		System.out.println("MOVIES SCANNED: " + movies.size());
	}

	public static boolean BooleanfromString(String boole) throws DataFormatException {
		switch (boole) {
		case "True":
			return true;
		case "False":
			return false;
		default:
			System.err.println(boole);
			throw new DataFormatException("Error Paring Boolean");
		}
	}

	public static Rating RatingfromString(String rating) throws DataFormatException {
		switch (rating) {
		case "PG-13":
			return Rating.PG_13;
		case "PG":
			return Rating.PG;
		case "U":
			return Rating.U;
		case "15":
			return Rating.fifteen;
		case "G":
			return Rating.G;
		case "12":
			return Rating.twelve;
		default:
			System.err.println(rating);
			throw new DataFormatException("Error parsing Rating");
		}
	}

	public static Genre GenreFromString(String genre) throws DataFormatException {
		switch (genre) {
		case "Comedy":
			return Genre.COMEDY;
		case "Romance":
			return Genre.ROMANCE;
		case "Drama":
			return Genre.DRAMA;
		case "Animation":
			return Genre.ANIMATION;
		case "Family":
			return Genre.FAMILY;
		case "Musical":
			return Genre.MUSICAL;
		case "War":
			return Genre.WAR;
		case "Fantasy":
			return Genre.FANTASY;
		default:
			System.err.println(genre);
			throw new DataFormatException("Error Parsing Genre");

		}
	}
}
