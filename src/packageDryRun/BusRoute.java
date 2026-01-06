package packageDryRun;

public class BusRoute {
	private int routeID;
	private String departure;
	private String arrival;
	private int travelMinutes;
	private Operator operator;
	
	public BusRoute() {
		
	}
	
	
	
	
	/**
	 * @param routeID
	 * @param departure
	 * @param arrival
	 * @param travelMinutes
	 * @param operator
	 */
	public BusRoute(int routeID, String departure, String arrival, int travelMinutes, Operator operator) {
		this.routeID = routeID;
		this.departure = departure;
		this.arrival = arrival;
		this.travelMinutes = travelMinutes;
		this.operator = operator;
	}




	/**
	 * @return the routeID
	 */
	public int getRouteID() {
		return routeID;
	}
	/**
	 * @param routeID the routeID to set
	 */
	public void setRouteID(int routeID) {
		this.routeID = routeID;
	}
	/**
	 * @return the departure
	 */
	public String getDeparture() {
		return departure;
	}
	/**
	 * @param departure the departure to set
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	/**
	 * @return the arrival
	 */
	public String getArrival() {
		return arrival;
	}
	/**
	 * @param arrival the arrival to set
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	/**
	 * @return the travelMinutes
	 */
	public int getTravelMinutes() {
		return travelMinutes;
	}
	/**
	 * @param travelMinutes the travelMinutes to set
	 */
	public void setTravelMinutes(int travelMinutes) {
		this.travelMinutes = travelMinutes;
	}
	/**
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}
	/**
	 * @param operator the operator to set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public void displayAll(){
		System.out.println("Route ID       :"+this.routeID);
		System.out.println("Departure Stop :"+this.departure);
		System.out.println("Arrival Stop   :"+this.arrival);
		System.out.println("Travel time    :"+this.travelMinutes+" minutes");
		System.out.println("Operator       :"+this.operator.toString());
		System.out.println();
	}
	
	
}
