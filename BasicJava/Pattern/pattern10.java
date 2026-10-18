
public class pattern10 {
    public static void main(String args[])
    {
        int row =1;
        int n=5;
        while(row<=n)
        {
            int space=1;
            while(space<=n-row)
            {
                System.out.print(" ");
                space=space+1;
            }
            int star=1;
            while(star<=row)
            {
                System.out.print("* ");
                star+=1;
            }
            row+=1;
            System.out.println();
        }
        while(row<=(2*n-1)) {
            int space1 = 1;
            while(space1 <=(row-n)){
                System.out.print(" ");
                space1+=1;
            }
            int star1=1;
            while(star1<=2*n-row)
            {
                System.out.print("* ");
                star1+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}
