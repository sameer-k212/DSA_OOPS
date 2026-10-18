
public class Pattern14 {
    public static void main(String args[])
    {
        int n=5;
        int row=1;
        while(row<=n)
        {
            int colmn=1;
            while(colmn<=n)
            {
                if(row==((n-1)/2+1)||colmn==1||colmn==n)
                {
                    System.out.print("*");
                    colmn+=1;
                }
                else
                {
                    System.out.print(" ");
                    colmn+=1;
                }
            }
            System.out.println();
            row+=1;
        }
    }
}
