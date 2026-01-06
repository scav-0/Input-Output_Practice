package clientServerTing;

public class Starter {

	public static void main(String[] args) {
		ServerSim serverSim = new ServerSim();
		ClientRequestSim clientRequestSim = new ClientRequestSim(serverSim);
		clientRequestSim.sendRequests(100);
	}
}
