package draculaBaby;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DraculaTime {
public static Queue<String> dracula = new LinkedList<String>();
	public static void main(String[] args) {
		readFile();
		Thread t1 = new Thread(new ReadingTime(dracula));
		t1.start();
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		t1.interrupt();
		
		scanner.close();
	}

//	private static void readBook() {
//		while(!dracula.isEmpty()) {
//			System.out.println(dracula.remove());
//		}
//		
//	}

	private static void readFile() {
		File file = new File("Dracula.txt");
//		if(file.exists()) {
//			System.out.println("Exists");
//		}
		try(BufferedReader br = new BufferedReader(new FileReader(file) )){
			String nextLine = br.readLine();
			while(nextLine!=null) {
				dracula.add(nextLine);
				nextLine = br.readLine();
			}
		}catch(IOException e) {
			
		}
	}

}
