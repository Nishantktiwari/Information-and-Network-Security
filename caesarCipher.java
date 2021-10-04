package INSPracitcals;
import java.util.Scanner;

public class caesarCipher {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static String Encrypt(String plainText,int Key)
	{
		plainText = plainText.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < plainText.length(); i++)
        {
            int charPositionPT = ALPHABET.indexOf(plainText.charAt(i)); 
            int finalPosition = charPositionPT+Key;
            if(finalPosition > 25)
            {
            	finalPosition = finalPosition - 26;  
            }
            char replaceVal = ALPHABET.charAt(finalPosition);
            cipherText += replaceVal; 
        }		
		return cipherText;		
	}
	public static String Decrypt(String cipherText,int Key)
	{ 
		cipherText = cipherText.toLowerCase();
		String plainText = "";
		for (int i = 0; i < cipherText.length(); i++)
        {
            int charPositionCT = ALPHABET.indexOf(cipherText.charAt(i));
            int finalPosition = charPositionCT-Key;
            if(finalPosition < 0)
            {
            	finalPosition = finalPosition + 26;
            }
            char replaceVal = ALPHABET.charAt(finalPosition);
            plainText += replaceVal;
        }		
		return plainText;		
	}
	
	public static void main(String[] args) {
		
		//To read input from the keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String for Encryption: ");
		String message = new String();	
		message = sc.next();
		System.out.println("Encrypted Text:");
		System.out.println(Encrypt(message, 3));
		System.out.println("Decrypted Text:");
		System.out.println(Decrypt((Encrypt(message, 3)), 3));
		sc.close();
	}

}
