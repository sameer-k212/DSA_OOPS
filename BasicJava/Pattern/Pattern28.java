
public class Pattern28 {
    public static void main(String args[])
    {
        int i=1;
        int n=11;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(i==(n-1)/2+1 || i+j>=(n-1)/2+2&&i<=(n-1)/2+1&&j-i<=n/2 ||
                        i-j<=(n-1)/2&&i>=(n-1)/2+1&&i+j<=(n+1)+(n-1)/2)
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
