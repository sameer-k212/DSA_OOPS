
public class Pattern32 {
    public static void main(String args[])
    {
        int n=5;
        int i=1;
        while(i<=n)
        {
            int j=1;
            while(j<=i)
            {
                System.out.print(j);
                j++;
            }
            j=1;
            while(j<=(n-i))
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=(n-i))
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=i)
            {
                System.out.print(j);
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
