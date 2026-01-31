package DSA.Array_Restructured._02_Rotation_And_Sorting._03_MinSwapsToSort;

import java.util.*;

public class MinSwapsToSort {
    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(arr[i], i);
        }
        
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != sorted[i]) {
                swaps++;
                int curPos = pos.get(sorted[i]);
                pos.put(arr[i], curPos);
                arr[curPos] = arr[i];
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println("Min swaps: " + minSwaps(arr));
    }
}
