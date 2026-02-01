package DSA.Hashing._02_Easy_Problems._01_TwoSum;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = obj.twoSum(arr, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
