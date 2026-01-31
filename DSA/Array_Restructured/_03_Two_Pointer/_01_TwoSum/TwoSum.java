package DSA.Array_Restructured._03_Two_Pointer._01_TwoSum;

import java.util.*;

public class TwoSum {
    // HashMap approach - O(n) time, O(n) space
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] result = twoSum(arr, 9);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
