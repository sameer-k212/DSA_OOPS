
public class Pattern17 {
    public static void main(String[] args) {
        int n=15;
        int row=1;
        while(row<=n)
        {
            int colmn=1;
            while(colmn<=n)
            {
                if(row==colmn || row+colmn==n+1 || row==1
                || colmn==1 || row==n || colmn == n
                || row+colmn==(n-1)/2+1 || row-colmn==(n-1)/2 ||
                colmn-row==(n-1)/2 || row+colmn==n+1+(n-1)/2)
                {
                    System.out.print("*");
                    colmn++;
                }
                else {
                    System.out.print(" ");
                    colmn++;
                }
            }
            row++;
            System.out.println();

        }
    }
}
