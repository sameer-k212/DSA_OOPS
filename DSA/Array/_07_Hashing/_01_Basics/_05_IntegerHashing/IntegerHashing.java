package DSA.Array._07_Hashing._01_Basics._05_IntegerHashing;

import java.util.*;

public class IntegerHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size:");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // Pre-computation
        int[] hash = new int[1000]; // Assuming elements < 1000
        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        
        // Query
        System.out.println("Enter number to query (or -1 to exit):");
        while (true) {
            int num = sc.nextInt();
            if (num == -1) break;
            System.out.println("Frequency: " + hash[num]);
        }
    }
}
