package DSA_OOPS.DSA.Algorithm.SlidingWindow._01_MaxSumSubarray;

public class MaxSumSubarray {
    public static int maxSumFixedWindow(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return -1;
        
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Max sum: " + maxSumFixedWindow(arr, k));
    }
}
