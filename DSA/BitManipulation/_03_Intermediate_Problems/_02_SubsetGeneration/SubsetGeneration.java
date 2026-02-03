package DSA_OOPS.DSA.BitManipulation._03_Intermediate_Problems._02_SubsetGeneration;

import java.util.*;

public class SubsetGeneration {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n;
        
        for (int mask = 0; mask < totalSubsets; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println("All subsets: " + result);
    }
}
