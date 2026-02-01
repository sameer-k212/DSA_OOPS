package DSA.Array.Hashing._04_Hard_Problems._02_SubarrayWithZeroSum;

import java.util.*;

public class SubarrayWithZeroSum {
    public boolean hasZeroSumSubarray(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
            
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            
            set.add(sum);
        }
        
        return false;
    }

    public static void main(String[] args) {
        SubarrayWithZeroSum obj = new SubarrayWithZeroSum();
        System.out.println(obj.hasZeroSumSubarray(new int[]{4,2,-3,1,6})); // true
        System.out.println(obj.hasZeroSumSubarray(new int[]{4,2,0,1,6})); // true (0 itself)
        System.out.println(obj.hasZeroSumSubarray(new int[]{-3,2,3,1,6})); // false
    }
}
