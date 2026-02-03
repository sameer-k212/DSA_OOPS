package DSA_OOPS.DSA.BitManipulation._02_Basic_Problems._03_SingleNumber;

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
    
    public static int[] singleNumberTwo(int[] nums) {
        int xor = 0;
        for (int num : nums) xor ^= num;
        
        int rightmostBit = xor & -xor;
        int num1 = 0, num2 = 0;
        
        for (int num : nums) {
            if ((num & rightmostBit) != 0) num1 ^= num;
            else num2 ^= num;
        }
        return new int[]{num1, num2};
    }
    
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2, 1, 2};
        System.out.println("Single number: " + singleNumber(nums1));
        
        int[] nums2 = {1, 2, 1, 3, 2, 5};
        int[] result = singleNumberTwo(nums2);
        System.out.println("Two single numbers: " + result[0] + ", " + result[1]);
    }
}
