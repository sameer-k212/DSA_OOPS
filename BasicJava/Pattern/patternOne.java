
public class patternOne {
    public static void main(String args[])
    {
        int n=5;
        int row=1;
        while(row<=5)
        {
            int colm=1;
            while(colm<=5)
            {
                System.out.print(colm);
                colm+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}
