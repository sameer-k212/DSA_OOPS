
// Linear Search

import java.util.Scanner;
public class linearSearch {
    void linear_search(int arr[],int n)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==n)
            {
                System.out.println("Index is: "+i);
            }
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int num=sc.nextInt();
        int n;
        System.out.println("Enter the key:");
        n=sc.nextInt();
        int arr[]=new int[num];
        System.out.println("Enter the number int an array:");
        for(int i=0;i<num;i++)
        {
            arr[i]=sc.nextInt();
        }
        linearSearch obj=new linearSearch();
        obj.linear_search(arr,n);
    }
}
