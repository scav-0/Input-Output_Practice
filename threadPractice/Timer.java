package threadPractice;

public class Timer implements Runnable {

	public Timer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		Long startTime=System.currentTimeMillis();
		for(;;) {
		if(Thread.interrupted()) {
			Long timePassed=System.currentTimeMillis()-startTime;
			timePassed/=1000;
			if(timePassed==30) {
				System.out.println("30 SECONDS - GOOD JOB");
			}else if(timePassed<30) {
				System.out.println("TOO EARLY - "+timePassed+" seconds.");
			}else {
				System.out.println("TOO LATE -"+timePassed+" seconds.");
			}
			break;
		}
		}

	}

}
