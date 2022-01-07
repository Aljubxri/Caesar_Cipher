
import java.util.Arrays;
public class Encryption {
	private int shift;
	private String text;
	
	public Encryption (int shift, String text) {
		this.shift=shift;
		this.text=text;
	}
	public String getText() {
		return text;
	}
	public int getShift() {
		return shift;
	}
	
	/* This algorithm uses an array of all the letters and the index of each letter is used as a value
	 * it takes the string (input) and runs it through a for loop, to get each character out of the string
	 * compares the chars from the input and the array, then when found it takes the value (aka index)
	 * uses the formula for the cipher
	 * then puts the new characters back into a string and returns in
	 */
	public  String Encrypt() {
		 char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray(); 
		 String coded = "";
		 for (int i=0; i<text.length(); i++) {
			 char chars = text.charAt(i);
			 for (int j=0; j<arr.length;j++) {
				if (chars == arr[j]) {
					 int ind= (shift + j)%26;
					 char encrypted = Character.toUpperCase(arr[ind]);
					 coded+=encrypted;
			 }
		 
			 }
			 
		 }
		return coded;
	
	}

}

