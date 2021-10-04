package INSPracitcals;
import java.util.Scanner;

public class Columnar {
    
    public static void Encrypt(String plainText, String key)
    {
        //make string arrays of key and plaintext
        String pt[]=plainText.split(""); //blue = {"b","l","u","e"}
        String ky[]=key.split(""); //ab = {"a","b"}     
        //get the no of columns and rows to build matrix
        int columns = key.length();
        int rows;
        if(plainText.length() % columns == 0)
        {
            rows = (plainText.length())/columns + 1;
        }
        else
        {
            rows = (plainText.length()/columns) + 2; //
        }
        
        String[][] mat = new String[rows][columns];
        String var="";
        int c = 0;
        
        
        //enter key in first row of matrix
        for(int i = 0; i < columns; i++)
        {
            mat[0][i]  = ky[i];
        }
        
        //fill up the matrix with plaintext
        for(int i = 1; i < rows; i++)
        {
            for(int j = 0; j< columns; j++)
            {
                if(c != plainText.length()) // C = 2 , plaintext = 18
                {
                var = pt[c]; // N
                mat[i][j]=var; //
                //System.out.print(mat[i][j]+"\t");
                c++;
                }
                else
                    break;
            }
            //System.out.println();
        }   
        
        //pad the empty spaces with either numeric values or characters
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j< columns; j++)
            {
                if(mat[i][j] == null)
                {
                    mat[i][j]="X";
                }               
            }
        }
        
        //display the matrix
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j< columns; j++)
            {
                System.out.print(mat[i][j]+"\t");               
            }
            System.out.println();
        }
        
        //COLUMNAR LOGIC
        
        
        //display the encrypted string
        String output="";
        for(int i = 0; i < columns; i++)
        {
            for(int j = 1; j< rows  ; j++)
            {
                output=output+mat[j][i];
                
            }           
        }
        System.out.println("Encrypted String: "+output);
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String str = new String();  
        str = sc.next();
        System.out.println("Enter the key for Encryption: ");
        String key = new String();  
        key = sc.next();
        Encrypt(str,key);       
    }

}
