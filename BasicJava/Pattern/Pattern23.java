
public class Pattern23 {
    public static void main (String args[])
    {
        int i=1;
        int n=9;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(i==1 || i==(n-1)/2+1 ||i==n || i+j==n+1 || i==j|| i>=(n)/2&&i+j>=n+1&&i>=j ||
                i<=n/2&&i+j<=n+1&&i<=j)
                {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                j++;
            }
            i++;
            System.out.println();
        }

    }

}
