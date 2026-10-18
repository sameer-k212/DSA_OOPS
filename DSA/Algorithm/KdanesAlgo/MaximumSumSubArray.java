
public class MaximumSumSubArray {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, 2, -2, -1, 6, -3};

        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int start = 0;

        int ansStart = -1;
        int ansEnd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (currSum == 0) {
                start = i;
            }

            currSum += arr[i];

            if (currSum > maxSum) {
                maxSum = currSum;
                ansStart = start;
                ansEnd = i;
            }

            if (currSum < 0) {
                currSum = 0;
            }
        }

        System.out.println("Maximum Subarray Sum: " + maxSum);
        System.out.println("Subarray indices: [" + ansStart + ", " + ansEnd + "]");
        System.out.print("Subarray: ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

