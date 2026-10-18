
import java.util.Scanner;

public class Function3 {
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
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        float N = factorial(n);
        int r=scan.nextInt();
        float R = factorial(r);
        float N_R=factorial(n-r);
        double B=(double)(N/(R*(N_R)));
        System.out.println(B);

    }

}
