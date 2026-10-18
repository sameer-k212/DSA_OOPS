
public class Pattern21 {
    public static void main(String args[])
    {
        int i=1;
        int n=5;
        while(i<=n)
        {
            int star=1;
            while(star<=i) {
                System.out.print("* ");
                star++;
            }
            int space=1;
            while(space<=(n-i))
            {
                System.out.print("  ");
                space+=1;
            }
            int space2=1;
            while(space2<=n-i){
                System.out.print("  ");
                space2+=1;
            }
            int star3=1;
            while(star3<=i)
            {
                System.out.print("* ");
                star3+=1;
            }

            System.out.println();
            i++;
        }
    }
}
