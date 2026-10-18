
public class Pattern30 {
    public static void main(String[] args) {
        int n=5;
        int i=1,m=13;
        while(i<=n)
        {
            int j=1;
            while(j<=m)
            {
                if(i+j==n+1 || i==1&&j>=n &&j<=n+(n-1) || i==n&&j<=n || i+j==n*2)
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
