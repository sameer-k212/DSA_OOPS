package DSA.Hashing._03_Medium_Problems._06_LongestConsecutiveSequence;

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) { // Start of sequence
                int curr = num;
                int len = 1;
                
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(new int[]{100,4,200,1,3,2})); // 4
        System.out.println(obj.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1})); // 9
    }
}
