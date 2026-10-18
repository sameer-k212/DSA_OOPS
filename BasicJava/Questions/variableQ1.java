
// Question 3: Enter cost of 3 items from the user (using float data type) - a pencil, a pen and
//an eraser. You have to output the total cost of the items back to the user as their bill.
//(Add on : You can also try adding 18% gst tax to the items in the bill as an advanced problem)

import java.util.Scanner;

public class variableQ1 {
    public static void bill(int x,int y,int z)
    {
        float gst=0.18f;
        System.out.println("toal billl will be: "+ (x*gst+y*gst+z*gst));

    }
    public static void main(String args[])
    {
        int n,m,o;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the cost price of item 1:");
        n=sc.nextInt();
        System.out.println("enter the cost price of item 2:");
        m=sc.nextInt();
        System.out.println("enter the cost price of item 3:");
        o=sc.nextInt();
        bill(n,m,o);
    }
}
