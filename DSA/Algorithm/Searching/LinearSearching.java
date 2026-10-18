// Searching linearly
import java.util.Scanner;

public class LinearSearching {
    static int linearSearching(int array[],int key){
        for(int i=0;i<array.length;i++){
            if(array[i]==key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of an array:");
        int size_array = sc.nextInt();
        int array[] = new int[size_array];
        System.out.println("Enter the elements in an array:");
        for(int i=0;i<size_array;i++){
            array[i]= sc.nextInt();
        }
        System.out.print("Enter the key:");
        int key = sc.nextInt();

        int index = LinearSearching.linearSearching(array,key);



        if(index==-1){
            System.out.println("Index not found.");
        }
        else{
            System.out.print("Index is: " + index);
        }


    }
}
