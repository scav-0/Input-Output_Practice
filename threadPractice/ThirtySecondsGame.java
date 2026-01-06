/**
 * 
 */
package threadPractice;

import java.util.Scanner;

/**
 * 
 */
public class ThirtySecondsGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Timer timer = new Timer();
		Thread t = new Thread(timer);
		
		System.out.println("TIMER BEGINNING - CLICK ENTER TO GUESS 30 SECONDS");
		
		t.start();
		//blocj until user hits enter
		scanner.nextLine();
		
		t.interrupt();
		
		System.out.println("DONE");
		
	
		
		
		scanner.close();
	}

}
