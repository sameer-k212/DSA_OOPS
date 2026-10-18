
public class Pattern25 {
    public static void main(String args[])
    {
        int n=5;
        int i=1;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(i==(n-1)/2+1 || i+j==n-1)
                {
                    System.out.print("* ");
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
