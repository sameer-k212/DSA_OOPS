
public class pattern11 {
    public static void main(String args[])
    {
        int row=1;
        int n=4;
        while(row<=n)
        {
            int star=1;
            while(star<=row)
            {
                System.out.print("*");
                star+=1;
            }
            int space=1;
            while(space<=n-row)
            {
                System.out.print(" ");
                space+=1;
            }
            int space3=1;
            while(space3<=n-row)
            {
                System.out.print(" ");
                space3+=1;
            }
            int star4=1;
            while(star4<=row)
            {
                System.out.print("*");
                star4+=1;
            }

            System.out.println();
            row+=1;
        }
        while(row<=2*n)
        {
            int star1=1;
            while(star1<=2*n-row)
            {
                System.out.print("*");
                star1+=1;
            }
            int space4=1;
            while(space4<=row-n)
            {
                System.out.print(" ");
                space4+=1;
            }
            int space5=1;
            while(space5<=row-n)
            {
                System.out.print(" ");
                space5+=1;
            }
            int star5=1;
            while(star5<=2*n-row)
            {
                System.out.print("*");
                star5+=1;
            }
            row+=1;
            System.out.println();
        }
    }
}
