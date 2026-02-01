package DSA.zSomeImpProblems;

import java.util.*;

public class Merge_K_Sorted_Arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // Number of arrays
        int n = sc.nextInt(); // Number of elements in each array

        // 2D array to store K sorted arrays
        long[][] arr = new long[k][n];

        // Read K sorted arrays
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextLong();
            }
        }

        // List to hold the final merged result
        List<Long> resultList = new ArrayList<>();

        // Merge the K sorted arrays
        for (int i = 0; i < k; i++) {
            resultList = merge(arr[i], resultList);
        }

        // Print the sorted merged array
        for (long num : resultList) {
            System.out.print(num + " ");
        }
    }

    // Function to merge two sorted arrays into a list
    public static List<Long> merge(long[] arr1, List<Long> list) {
        int i = 0; // Pointer for arr1
        int j = 0; // Pointer for list (which will be considered as arr2)

        // Create a temporary array from the existing list
        long[] arr2 = new long[list.size()];
        for (int k = 0; k < list.size(); k++) {
            arr2[k] = list.get(k);
        }

        // Merging process
        List<Long> mergedList = new ArrayList<>();

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedList.add(arr1[i]);
                i++;
            } else {
                mergedList.add(arr2[j]);
                j++;
            }
        }

        // If any elements are left in arr1
        while (i < arr1.length) {
            mergedList.add(arr1[i]);
            i++;
        }

        // If any elements are left in arr2
        while (j < arr2.length) {
            mergedList.add(arr2[j]);
            j++;
        }

        return mergedList;
    }
}
