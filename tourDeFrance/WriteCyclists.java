package tourDeFrance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.ArrayList;

public class WriteCyclists implements Runnable {
private ArrayList<Cyclist> cyclists;
	public WriteCyclists(ArrayList<Cyclist> cyclists) {
		this.cyclists=cyclists;
	}

	@Override
	public void run() {
		System.out.println("THREAD RUNNING");
		LocalTime winningTime = findWinningTime();
		ArrayList<Cyclist> losers = listLosers(winningTime);
		writeToFile(losers, winningTime);
		System.out.println("THREAD FINISHED");
	}

	private void writeToFile(ArrayList<Cyclist> losers, LocalTime winningTime) {
		File file = new File("LOSERS");
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))){
			
			bw.write("WINNING TIME: "+winningTime.toString()+"\n");
		
		for(Cyclist cyclist: losers) {
			if(cyclist.getTime().isAfter(winningTime.plusMinutes(30))) {
			bw.write(cyclist.getFirstName()+" "+cyclist.getLastName()+", time : "+cyclist.getTime().toString()+"\n");
			}
		}
		}catch(IOException e) {
			System.err.println("ERROR WRITING TO FILE");
		}
	}

	private ArrayList<Cyclist> listLosers(LocalTime winningTime) {
		ArrayList<Cyclist> losers = new ArrayList<Cyclist>();
		for(Cyclist cyclist: cyclists) {
			if(cyclist.getTime().isAfter(winningTime)) {
				losers.add(cyclist);
			}
		}
		return losers;
	}

	private LocalTime findWinningTime() {
		LocalTime winningTime = LocalTime.MAX;
		for(Cyclist cyclist: cyclists) {
			if(cyclist.getTime().isBefore(winningTime)) {
				winningTime=cyclist.getTime();
			}
		}
		return winningTime;
	}

}
