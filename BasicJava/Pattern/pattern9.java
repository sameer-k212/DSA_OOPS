
public class pattern9{
    public static void main(String args[])
    {
        int row=1;
        int n=5;
        while(row<=n)
        {
            int space=1;
            while(space<=((4*row)-4))
            {
                System.out.print(" ");
                space+=1;
            }
            int star=1;
            while(star<=(n+1)-row)
            {
                System.out.print("* ");
                star+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}
