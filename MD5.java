package INSPracitcals;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    
     public static String getMd5(String input) throws NoSuchAlgorithmException
        {
          
                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("SHA-1");
      
                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest(input.getBytes());
      
                // Convert byte array into signum representation - convert byte array to a positive magnitute
                BigInteger no = new BigInteger(1, messageDigest);
      
                // Convert message digest into hex value
                String hashtext = no.toString(16);
                return hashtext;
            
        }
      
        // Driver code
        public static void main(String args[]) throws NoSuchAlgorithmException
        {
            String s = "Nishant";
            System.out.println("Your HashCode Generated by MD5 is: " + getMd5(s));
        }

}

