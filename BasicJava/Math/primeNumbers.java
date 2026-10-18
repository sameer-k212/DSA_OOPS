
import java.util.Scanner;

public class primeNumbers {
    boolean Prime(int n)
    {
        boolean prime=true;

        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                prime=false;
            }
        }
        return prime;
    }
    void primeRange(int n1)
    {
        for(int i=2;i<=n1;i++)
        {
            if(Prime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the range of the number:");
        int i = scan.nextInt();
        primeNumbers obj=new primeNumbers();
        obj.primeRange(i);
    }
}
