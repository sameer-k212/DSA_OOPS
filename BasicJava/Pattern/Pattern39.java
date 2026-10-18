
public class Pattern39 {
    public static  void main(String args[])
    {
        int n=5;
        int i=1;
        while(i<=n)
        {
            int j=1;
            while(j<=n-i+1)
            {
                System.out.print("*");
                 j++;
            }
            j=1;
            while(j<=i-1)
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=i-1)
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=n-i+1)
            {
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }
        while(i<=2*n-1)
        {
            int j=1;
            while(j<=i-n+1)
            {
                System.out.print("*");
                j++;
            }
            j=1;
            while(j<=2*n-i-1)
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=2*n-i-1)
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=i-n+1)
            {
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }

    }
}
