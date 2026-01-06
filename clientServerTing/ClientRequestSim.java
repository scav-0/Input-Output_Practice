package clientServerTing;

public class ClientRequestSim {

	// The server to be used 
	private ServerSim serverSim;

	/**
	 * Create the client and pass in the server to be used
	 * @param serverSim
	 */
	public ClientRequestSim(ServerSim serverSim) {
		this.serverSim = serverSim;
	}

	/**
	 * Sends the requests
	 */
	public void sendRequests(int requestNumber) {

		// sending requests with .1 sec delay between sending
		for (int loop = 1; loop <= requestNumber; loop++) {
			System.out.println("Client : sending Request " + loop);
			serverSim.sendRequest(loop);
			// small delay
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Client : All sent");

	}

}
