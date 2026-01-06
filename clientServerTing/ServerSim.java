package clientServerTing;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class ServerSim {
	
	private boolean serverStarted = false; 
	
	private static int Thread_Pool = 10;
	
	protected static Queue<Integer> requestQueue = new LinkedList<Integer>();

	Thread[] threads=new Thread[Thread_Pool];
	public ServerSim() {
		serverStarted = true;
		
		System.out.println("Server : started. ready to receive requests ...."+ currentTimeFormatted());
		for(int i=0 ; i<Thread_Pool;i++) {
			threads[i]= new Thread(new HandleRequest(this));
			threads[i].start();
		}
	}

	public void sendRequest(int num) {
		requestQueue.add(num);
	}
	/**
	 * Public facing method that clients call with their requests
	 * 
	 * @param request
	 */
	public synchronized void processRequest(int num) {
		if (serverStarted) {
			// simulating doing some processing
			try {
				Thread.sleep(new Random().nextInt(1000, 3000));
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			System.err.println("Server : Request complete " + num);
		} else {
			System.out.println("Server not started");
		}
	}

	public void stop() {
		serverStarted = false;
		System.out.println("Server : stopped " + currentTimeFormatted());
	}

	private String currentTimeFormatted() {
		// Define the desired format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime currentTime = LocalTime.now();
		// Format the current time using the defined format
		String formattedTime = currentTime.format(formatter);

		return formattedTime;
	}
}
