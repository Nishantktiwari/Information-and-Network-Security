package INSPracitcals;
import java.util.Scanner;

public class RSA {
    
    public static int pvtkey; //y

    public static void ComputeRSA(int p,int q)
    {
        //Step 1: Calculate RSA Modulus
        int N;
        N = p * q;
        
        //Step 2: Calculate Derived Number
        int m;
        m = (p-1)*(q-1);
        
        //Step 3: Choose a public key that follows the two conditions of 
        // 1< e < m
        // e is a prime number
        int e; //public key
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for public key");
        e = sc.nextInt();
        boolean isPrime = checkForPrime(e);
        //checking if e is greater than 1 and lesser than derived number m
        if (e > 1 && e < m) {
            if (isPrime) { //isPrime for e
                
                //Step 4 : Constructing the table
                int[] a = new int[25];
                int[] b = new int[25];
                int[] d = new int[25];
                int[] k = new int[25];
                
                //Giving the default values
                //1st row
                a[0] = 1; b[0] = 0; d[0] = m; k[0] = 0;
                //2nd row
                a[1] = 0; b[1] = 1; d[1] = e;
                k[1] = d[0] / d[1];
                
                //loop that checks if d = 1 and stops at that point
                System.out.println("a \t b \t d \t k");
                int i = 2;
                while (d[i] != 1) {
                    a[i] = a[i - 2] - (a[i - 1] * k[i - 1]);
                    b[i] = b[i - 2] - (b[i - 1] * k[i - 1]);
                    d[i] = d[i - 2] - (d[i - 1] * k[i - 1]);
                    k[i] = d[i - 1] / d[i];
                    System.out.println(a[i] + "\t " + b[i] + "\t " + d[i] + "\t " + k[i]);

                    if (d[i] == 1) 
                    {
                        pvtkey = b[i];
                        break;
                    } 
                    else 
                    {
                        i++;
                    }

                }
                //Step 5: Applying conditions on your private key
                if (pvtkey > m) {
                    pvtkey = pvtkey % m;
                }
                if (pvtkey < 0) {
                    pvtkey = pvtkey + m;
                }
                
                //Printing the public and private key
                System.out.println();
                System.out.println("*************************************************");
                System.out.println("Public Key: " + e);
                System.out.println("Private Key: " + pvtkey);
                System.out.println("*************************************************");
            }
            else
                System.out.println("The public key you chose is not a prime number.");
        }
        else
            System.out.println("The public key you chose is bigger than derived number " +m);
    }

    public static boolean checkForPrime(int inputNumber)
    {
        boolean isItPrime = true;
     
        if(inputNumber <= 1) 
        {
            isItPrime = false;
            return isItPrime;
        }
        else
        {
            for (int i = 2; i<= inputNumber/2; i++) 
            {
                if ((inputNumber % i) == 0)
                {
                    isItPrime = false;
                    break;
                }
            }
     
            return isItPrime;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for p(prime no. 1)- ");
        int p;
        p = sc.nextInt();
        boolean isPrime = checkForPrime(p);
        if(isPrime) //isPrime = true for p
        {
            System.out.println("Enter value for q(prime no. 2)- ");
            int q;
            q = sc.nextInt();
            isPrime = checkForPrime(q);
            if(isPrime) //isPrime = true for q
            {
                ComputeRSA(p,q);
            }
            else
                System.out.println("q is not a prime number.");
        }
        else
            System.out.println("p is not a prime number.");
    }
}
