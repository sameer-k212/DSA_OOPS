
public class Pattern24 {
    public static void main(String args[])
    {
        int i=1;
        int n=10;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(i==j || i+j==n+1 || i<=n/2+1&&i>=j || i+j<=n+1&&i>=(n-1)/2+1 ||
                        i+j>=n+1&&i<=(n-1)/2+1 || i<=j&&i>=(n-1)/2+1 )
                {
                    System.out.print("*");

                }
                else {
                    System.out.print(" ");
                }
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
