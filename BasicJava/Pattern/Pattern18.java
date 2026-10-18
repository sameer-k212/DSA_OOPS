
public class Pattern18 {
    public static void main(String args[])
    {
        int n=10;
        int row=0;
        while(row<n)
        {
            int colmn=0;
            while(colmn<n)
            {
                if(row==0&&colmn<=(n-1)/2 || colmn==0&&row<=(n-1)/2 || row+colmn<=(n-1)/2||
                row==0&&colmn>=(n-1)/2 || colmn==n-1&&row<=(n-1)/2 || colmn-row>=(n-1)/2
                || colmn==0&&row>=(n-1)/2 || row==n-1&&colmn<=(n-1)/2 || row-colmn>=(n-1)/2
                 || row==n-1&&colmn>(n-1)/2 || colmn==n-1&&row>=(n-1)/2||
                        row+colmn>=(n-1)/2+(n-1))
                {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                colmn++;
            }
            row+=1;
            System.out.println();
        }

    }
}
