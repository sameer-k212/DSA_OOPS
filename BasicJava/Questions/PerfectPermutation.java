

import java.util.Scanner;

public class PerfectPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[4];
        if(n%2!=0){
            System.out.println(-1);
        }
        else{
            int i=0;
            int m = 1;
            while(i<=n){
                arr[i]=m;
                i++;
                m++;
            }

        }
        for(int j=0;j<n;j++){
            System.out.println(arr[j]+" ");
        }
    }
}
