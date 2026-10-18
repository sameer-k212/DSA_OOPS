
public class Pattern34 {
    public static void main(String args[])
    {
        int i=1;
        int n=10;
        while(i<=n){
            int j=1;
            while(j<=i)
            {
                System.out.print(" ");
                j++;
            }
            j=1;
            while(j<=2*n-2*i+1)
            {
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
