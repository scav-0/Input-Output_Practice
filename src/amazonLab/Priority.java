package amazonLab;

public enum Priority {
	HIGH,LOW,NORMAL;
	
	public static Priority fromString(String string) {
		if(string.equalsIgnoreCase("high")) {
			return HIGH;
		}else if(string.equalsIgnoreCase("low")) {
			return LOW;
		}else if(string.equalsIgnoreCase("normal")) {
			return HIGH;
		}else {
			return null;
		}
	}
}
