package strings;

public class reverseString {

	public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod";
	int length = palindrome.length();
	char[] tempCharArray = new char[length];
	char[] charArray = new char[length];
	String reversed="";
	// put original string in an array of chars
	for(int index=0;index<length;index++) {
		charArray[index]=palindrome.charAt(index);
		tempCharArray[length-1-index]=palindrome.charAt(index);
	}
	// reverse array of chars
	for (int index=0;index<length;index++) {
		reversed+=tempCharArray[index];
	}
	System.out.println(reversed);
	if(reversed.equalsIgnoreCase(palindrome)) {
		System.out.println("PALINDROME");
	}
        // check if the original string was a palindrome
	
	
	
	StringBuilder sb = new StringBuilder(palindrome);
	sb.reverse();
	System.out.println(sb);
	}

}
