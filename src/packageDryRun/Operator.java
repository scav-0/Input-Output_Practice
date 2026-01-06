package packageDryRun;

public enum Operator {
	TRANSLINK, ULSTERBUS, BUS_EIREANN, OTHER;

	@Override
	public String toString() {
		switch(this) {
		case TRANSLINK:
			return "Translink";
		case ULSTERBUS:
			return "Ulsterbus";
		case BUS_EIREANN:
			return "Bus Eireann";
		default:
			return "Other";
		}
	}
	
	
}
