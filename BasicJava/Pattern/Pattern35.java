
public class Pattern35 {
    public static void main(String args[])
    {
        int n=5;
        int i=1;
        while(i<=n){
            int j=1;
            while(j<=i)
            {
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
        while(i<=2*n)
        {
            int j=1;
            while(j<=2*n-i)
            {
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();

        }
    }
}
