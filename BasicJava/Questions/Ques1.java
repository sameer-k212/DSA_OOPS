import java.util.Scanner;

public class Ques1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[3];
        int sum=0;
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(arr[arr.length-1]==7)
        {
            System.out.println("-1");
        }
        else if(arr[1]==7)
        {
            System.out.println(arr[1+1]);
        }
        else if(arr[0]==7)
        {
            sum=arr[0]+arr[1]+arr[2];
            System.out.println(sum);
        }
        else
        {
            System.out.println(arr[2]+arr[1]+7);
        }


    }
}
