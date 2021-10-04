package INSPracitcals;
import java.util.Arrays;
import java.util.Scanner;

public class Railfence {
    public static void Encrypt(String str, int n)
    {
        //if depth = 1
         if (n == 1)  
            { 
                System.out.print(str); 
                return ; 
            } 
         char[] str1 = str.toCharArray();//"youneedtostudy" = {"y","o","u","n"....}
         int len = str.length(); //len = columns
         String[] arr = new String[n]; //n = key = rows
         Arrays.fill(arr, ""); 
         int row = 0; //pointer to the row
         boolean down = true;  
         //LEN = NO OF COLUMNS OR PLAINTEXT SIZE
         for (int i = 0; i < len; i++)  //i becomes pointer of columns
            { 
                arr[row] = arr[row] + (str1[i]);  //str1 = {I,L,I,V,E,I,N,M,U,M..}
                if (row == n - 1)  //2 == 2
                { 
                    down = false; 
                }  
                else if (row == 0)  //2 == 0
                { 
                    down = true; 
                } 
                if (down) 
                { 
                    row++; 
                }  
                else 
                { 
                    row--; 
                } 
            } 

            for (int i = 0; i < n; i++)  
            { 
                System.out.print(arr[i]); 
            } 
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String str = new String();  
        str = sc.next(); //plaintext from user
        int n = 3;  //key / rows
        System.out.println("Encrypted String:"); 
        Encrypt(str, n);
    }
}
