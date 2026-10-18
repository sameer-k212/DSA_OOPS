
public class Pattern41 {
    public static void main(String args[])
    {
        int n=5;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=2*i-2;j++)
            {
                System.out.print(" ");
            }
            for(int k=1;k<=n-i+1;k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=1;i<=n-1;i++)
        {
            for(int j=1;j<=n+1-2*i+2;j++)
            {
                System.out.print(" ");
            }
            for(int k=1;k<=2*i-i+1;k++)
            {
                System.out.print("*");
            }
            System.out.println();

        }

    }
}
