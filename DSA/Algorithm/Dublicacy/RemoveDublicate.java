import java.util.*;
// from sorted array;  {1,2,2,2,3,4,4}
public class RemoveDublicate {
    public static int removeDuplicates(int[] nums) {
            int j = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[j] = nums[i];
                    j++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return j;
    }

    public static void main(String[] args) {
        System.out.println
         ("Size of sorted without duplicate element array:"+removeDuplicates(new int[]{1,2,2,2,3,4,4}));
    }
}
