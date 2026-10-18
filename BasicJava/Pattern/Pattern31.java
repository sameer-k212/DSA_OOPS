
public class Pattern31 {
    public static void main(String args[])
    {
        int n=10;
        int i=1;
        while(i<=n)
        {
            int j=1;
            while(j<=n)
            {
                if(i==1&&j<=(n-1)/2+1 || j==1&&i<=(n-1)/2+1 || i+j<=(n-1)/2+2)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
                j++;
            }
            System.out.println();
            i++;
        }
    }
}
