//12345
//1234
//123
//12
//1

public class pattern3 {
    public static void main(String args[])
    {
        int n=5;
        int row=1;
        while(row<=n)
        {
            int colm=1;
            while(colm<=((n+1)-row))
            {
                System.out.print(colm);
                colm+=1;
            }
            System.out.println();
            row+=1;
        }

    }
}
