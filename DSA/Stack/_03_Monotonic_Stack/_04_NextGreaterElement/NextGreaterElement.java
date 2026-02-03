package DSA_OOPS.DSA.Stack._03_Monotonic_Stack._04_NextGreaterElement;

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 10, 8};
        int[] result = nextGreaterElements(nums);
        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}
