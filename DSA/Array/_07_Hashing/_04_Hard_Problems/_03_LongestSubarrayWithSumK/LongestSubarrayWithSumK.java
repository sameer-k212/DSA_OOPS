package DSA.Array._07_Hashing._04_Hard_Problems._03_LongestSubarrayWithSumK;

import java.util.*;

public class LongestSubarrayWithSumK {
    public int longestSubarrayWithSumK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0, maxLen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK obj = new LongestSubarrayWithSumK();
        System.out.println(obj.longestSubarrayWithSumK(new int[]{10,5,2,7,1,9}, 15)); // 4
        System.out.println(obj.longestSubarrayWithSumK(new int[]{-1,2,3}, 6)); // 0
        System.out.println(obj.longestSubarrayWithSumK(new int[]{1,2,3,4,5}, 9)); // 3
    }
}
