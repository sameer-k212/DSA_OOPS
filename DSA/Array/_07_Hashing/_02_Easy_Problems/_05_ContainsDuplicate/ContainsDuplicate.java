package DSA.Array._07_Hashing._02_Easy_Problems._05_ContainsDuplicate;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate obj = new ContainsDuplicate();
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,1})); // true
        System.out.println(obj.containsDuplicate(new int[]{1,2,3,4})); // false
    }
}
