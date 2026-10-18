
import java.util.Scanner;
import java.util.*;

public class LeepYear {
    public static int leepYear(int n)
    {
        if(n%400==0||(n%4==0&&n%100!=0))
        {
            return 1;
        }
        else {
            return 0;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the year:");
        int m=sc.nextInt();
        int n=leepYear(m);
        if(n==1)
        {
            System.out.println("Leap Year.");
        }
        else if(n==0)
        {
            System.out.println(" not Leep Year");
        }

    }
}
