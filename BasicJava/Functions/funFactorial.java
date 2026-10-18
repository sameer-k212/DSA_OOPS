
import java.util.Scanner;

public class funFactorial {
    public static int factorial(int n)
    {
        int prod=1;
        for(int i=1;i<=n;i++)
        {
            prod=prod*i;
        }
        return prod;
    }
    public static void main(String args[])
    {
        System.out.println("Welcome to the factorial program sir.");
        System.out.println();
        System.out.println();
        Scanner scan=new Scanner(System.in);
        System.out.println("enter the number whose factorial your want to know:");
        int n= scan.nextInt();
        int fact=factorial(n);
        System.out.println(fact);
    }
}
