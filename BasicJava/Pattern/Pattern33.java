
public class Pattern33 {
    public static void main(String args[])
    {
        int n=10;
        int i=1;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(j==1&& i!=j || i==1&&i!=j&&j<=(n-1) || j==n&&i!=1&&i<(n-1)/2+1
                 || i==(n-1)/2+1&&j!=n || i>=(n-1)/2+1 && j>(n-1)/2+1
                && i==j)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
