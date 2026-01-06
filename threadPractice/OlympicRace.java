package threadPractice;

import java.util.ArrayList;

public class OlympicRace {
public static ArrayList<String> names = new ArrayList<String>(9);
public static ArrayList<Integer> times = new ArrayList<Integer>(9);
	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<Thread>(9);
		toArray();
		for(int i=0;i<names.size();i++) {
			OlympicRunner ol = new OlympicRunner(names.get(i), times.get(i));
			threads.add(new Thread(ol));
		}
		
		System.out.println("OLYMPIC 100M SPRINT SIMULATION");
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("READY.....");
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("SET...");
		try {
			Thread.sleep(500);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("GO!");
		
		for(Thread t:threads) {
			t.start();
		}
		

	}
	public static void toArray() {
		names.add("Usain BOLT");
		times.add(9810);

		names.add("Justin GATLIN");
		times.add(9890);

		names.add("Andre DE GRASSE");
		times.add(9910);

		names.add("Yohan BLAKE");
		times.add(9930);

		names.add("Akani SIMBINE");
		times.add(9940);

		names.add("Ben Youssef MEITE");
		times.add(9960);

		names.add("Jimmy VICAUT");
		times.add(10040);

		names.add("Trayvon BROMELL");
		times.add(10060);
		
		
		
		
	}
}
