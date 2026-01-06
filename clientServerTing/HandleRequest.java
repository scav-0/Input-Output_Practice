package clientServerTing;

public class HandleRequest implements Runnable {
	private ServerSim server;
	public HandleRequest(ServerSim server) {
		this.server=server;
	}
	@Override
	public void run() {
		for(;;) {
			if(ServerSim.requestQueue.peek()!=null) {
				server.processRequest(ServerSim.requestQueue.remove());
			}else {
				try {
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
