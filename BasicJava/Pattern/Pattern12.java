
public class Pattern12 {
    public static void main(String args[])
    {
        int row=1;
        int n=5;
        while(row<=n)
        {
            int space=1;
            while(space<=n-row)
            {
                System.out.print(" ");
                space+=1;
            }
            int star=1;
            while(star<=1)
            {
                System.out.print("*");
                star+=1;
            }
            row+=1;
            System.out.println();
        }
    }
}
