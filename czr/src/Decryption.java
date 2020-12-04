import java.util.Arrays;

public class Decryption extends Encryption {
	//this class extends the encryption class, uses the same constructor too. I could have condensed it but did it this way for the purposes of the class/project
	    
	public Decryption(int shift, String text) {
		super(shift, text);
	}
	
	
	/* This method uses the same idea for the array and text, its pretty much the same as the other one 
	 * the only difference is that this method uses a binary search instead of a 2nd for loop
	 * it compares the characters from both input and the array then checks if the value is less negative, and if it is then it would add the array length to it 
	 * the rest is the same as the other method
	 */
	public  String Decrypt() {
		 char[] arr = "abcdefghijklmnopqrstuvwxyz".toCharArray(); 
        String uncoded = "";
        for (int i = 0; i < super.getText().length(); i++)
        {
            int index = Arrays.binarySearch(arr, super.getText().charAt(i));
            int val = (index - super.getShift()) % 26;
            if (val < 0){
              val = arr.length + val;
              }
            char decrypted = Character.toLowerCase(arr[val]);
            uncoded += decrypted;
        }
        return uncoded;
    }

}
