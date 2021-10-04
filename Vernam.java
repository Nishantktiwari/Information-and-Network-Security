package INSPracitcals;

import java.util.Scanner;

public class Vernam {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static String Encrypt(String plainText,String Key)
    {
        plainText = plainText.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) //i = 2
        {
            int charPositionPT = ALPHABET.indexOf(plainText.charAt(i)); //h = 7
            int charPositionKey = ALPHABET.indexOf(Key.charAt(i)); //n = 13 
            int finalPosition = charPositionPT+charPositionKey;//finalpos = 20
            if(finalPosition > 25)
            {
                finalPosition = finalPosition - 26; //finalpos = 33 - 26 = 7
            }
            char replaceVal = ALPHABET.charAt(finalPosition); // u
            cipherText += replaceVal; //hu
        }       
        return cipherText;      
    }
    public static String Decrypt(String cipherText,String Key)
    { 
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        for (int i = 0; i < cipherText.length(); i++)
        {
            int charPositionCT = ALPHABET.indexOf(cipherText.charAt(i));
            int charPositionKey = ALPHABET.indexOf(Key.charAt(i));
            int finalPosition = charPositionCT-charPositionKey;
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
        //Take the Key as input
        System.out.println("Enter the key for Encryption: ");
        String key = new String();
        key = sc.next();
        if (message.length() == key.length()) {
            System.out.println("Encrypted Text:");
            System.out.println(Encrypt(message, key));
            System.out.println("Decrypted Text:");
            System.out.println(Decrypt((Encrypt(message, key)), key));
        }
        else
            System.out.println("Please enter same length Plaintext and keyword.");
        sc.close();
    }
}
