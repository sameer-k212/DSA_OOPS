
import java.util.Scanner;

public class funPrime {
    public static boolean Prime(int n)
    {
        boolean isPrime=true;
        if(n==2)
        {
           isPrime=true;
        }
        else
        {
            for(int i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    isPrime=false;
                }
            }
        }
        return isPrime;
    }
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number:");
        n=sc.nextInt();
        boolean  a =Prime(n);
        if(a==true)
        {
            System.out.println("Prime");
        }
        else{
            System.out.println("Not Prime");
        }
    }
}

