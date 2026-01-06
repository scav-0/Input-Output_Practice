package threadPractice;

public class OlympicRunner implements Runnable {

	private int time;
	private String name;
	public OlympicRunner(String name, int time) {
		this.time=time;
		this.name=name;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(this.time);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%S finished the race with a time of %.2f seconds\n",name,(double)time/1000);
	}

}
