
public class Pattern40 {
    public static void main(String args[])
    {
        int n=7;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(i==1 || j==1 || i==n || j==n || i==2&&j==2 || i==(n-1)&&j==2 ||
                i==2&&j==(n-1) || i==(n-1)&&j==(n-1))
                {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
