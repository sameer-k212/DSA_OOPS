//1
//22
//333
//4444
//55555

public class patternTwo {
    public static void main(String arg[])
    {
        int row =1;
        int n=5;
        while(row<=n)
        {
            int colm=1;
            while(colm<=row)
            {
                System.out.print(row);
                colm+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}







