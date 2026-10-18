
// sum of n natural number

import java.util.Scanner;

class Sum_Number
{
    static int main(int n)
    {
        int sum=0;
        for(int i =1;i<=n;i++)
        {
            sum=sum+i;
        }
        return sum;
    }
}

class sumOfNaturalNumber {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the number:");
        int n=sc.nextInt();
        int m=Sum_Number.main(n);
        System.out.println(m);
    }
}
