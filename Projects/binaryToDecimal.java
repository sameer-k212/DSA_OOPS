
// binary to decimal.

import java.util.Scanner;

public class binaryToDecimal {
    int pow(int i,int n) {
        int rem = 1;
        if (i == 0) {
            return 1;
        } else {
            for (int j = 1; j <= i; j++) {
                rem = n * rem;
            }
            return rem;
        }
    }

    void binary_Decimal(int a)
    {
        int i=0;
        int rem;
        int sum=0;
        while(a>0)
        {
            rem=a%10;
            sum=sum+ pow(i,2)*rem;
            i++;
            a=a/10;
        }
        System.out.println(sum);
    }
    public static void main(String args[])
    {
        binaryToDecimal obj= new binaryToDecimal();
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter the number:");
        int n=scan.nextInt();
        obj.binary_Decimal(n);
    }
}
