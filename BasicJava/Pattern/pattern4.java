//*
//* *
//* * *
//* * * *
//* * * * *



public class pattern4 {
    public static void main(String args[])
    {
        int n=5;
        int row=1;
        while(row<=5)
        {
            int star=1;
            while(star<=row)
            {
                System.out.print("* ");
                star+=1;
            }
            System.out.println();
            row+=1;
        }
    }
}
