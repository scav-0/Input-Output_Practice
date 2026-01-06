package draculaBaby;

import java.util.Queue;

public class ReadingTime implements Runnable {

	private Queue<String> wholeText;
	
	public ReadingTime(Queue<String> wholeText) {
		this.wholeText=wholeText;
	}
	@Override
	public void run() {
		while(!wholeText.isEmpty()) {
			if(Thread.currentThread().isInterrupted()) {
				
				break;
		}
			System.out.println(wholeText.remove());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				break;
			}
			
		}
		System.out.println("DONE READING...");
		System.out.println("THREAD FINISHED");
		
	}

	

}
