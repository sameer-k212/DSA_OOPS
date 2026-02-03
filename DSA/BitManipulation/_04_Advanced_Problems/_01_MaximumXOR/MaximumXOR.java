package DSA_OOPS.DSA.BitManipulation._04_Advanced_Problems._01_MaximumXOR;

public class MaximumXOR {
    public static int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            java.util.Set<Integer> set = new java.util.HashSet<>();
            
            for (int num : nums) {
                set.add(num & mask);
            }
            
            int temp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR: " + findMaximumXOR(nums));
    }
}
