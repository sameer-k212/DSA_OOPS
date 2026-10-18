
public class Pattern46 {
    public static void main(String args[])
    {
        int n=5;
        for(int i=1;i<=n-1;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            for(int j=1;j<=2*n-2*i-1;j++)
            {
                System.out.print("  ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        for(int i=1;i<=2*n-1;i++)
        {
            System.out.print("* ");
        }
    }

}
