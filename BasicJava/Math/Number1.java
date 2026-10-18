
// Reversing of a Number.

import java.util.Scanner;

public class Number1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("n:");
        int n=sc.nextInt();
        int sum=0;
        while(n!=0)
        {
            int rem=n%10;
            sum=sum*10+rem;
            n=n/10;
        }
        System.out.println(sum);

    }
}
