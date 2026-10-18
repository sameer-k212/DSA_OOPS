

public class Pattern15 {
    public static void main(String  args[])
    {
        int row=1;
        int n=10;
        while(row<=n)
        {
            int colmn=1;
            while(colmn<=n)
            {
               if(((row==1 && colmn>1) && (colmn<((n-1)/2+1)))||(colmn==1 && row>1)||(row==((n-1)/2+1) && colmn<((n-1)/2+1)) ||(colmn==((n-1)/2+1) && row>1))
               {
                   System.out.print("*");
               }
               else {
                   System.out.print(" ");
               }
               colmn++;
            }
            System.out.println();
            row++;
        }
    }
}
