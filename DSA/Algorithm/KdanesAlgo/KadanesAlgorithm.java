
public class KadanesAlgorithm {

    // Maximum SubArray Sum (Kadane's DSA.Algorithm)
    public static int maxSubArray(int[] nums) {
        int current_sum = nums[0];
        int max_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(nums[i], current_sum + nums[i]);
            max_sum = Math.max(max_sum, current_sum);
        }

        return max_sum;
    }

    // Maximum Circular SubArray Sum
    public static int maxCircularSubArray(int[] nums) {
        int totalSum = nums[0], maxSum = nums[0], minSum = nums[0];
        int currentMax = nums[0], currentMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            totalSum += nums[i];
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);
        }

        if (maxSum < 0) {
            return maxSum; // All elements are negative
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    // Maximum Sum of Two Non-Overlapping Subarrays
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(maxSumTwoHelper(nums, firstLen, secondLen),
                maxSumTwoHelper(nums, secondLen, firstLen));
    }

    private static int maxSumTwoHelper(int[] nums, int L, int M) {
        int[] maxL = new int[nums.length];
        int[] maxM = new int[nums.length];

        int sumL = 0, sumM = 0;
        for (int i = 0; i < L; i++) {
            sumL += nums[i];
        }
        maxL[L - 1] = sumL;

        for (int i = L; i < nums.length; i++) {
            sumL += nums[i] - nums[i - L];
            maxL[i] = Math.max(maxL[i - 1], sumL);
        }

        for (int i = 0; i < M; i++) {
            sumM += nums[i];
        }
        maxM[M - 1] = sumM;

        for (int i = M; i < nums.length; i++) {
            sumM += nums[i] - nums[i - M];
            maxM[i] = Math.max(maxM[i - 1], sumM);
        }

        int result = Integer.MIN_VALUE;
        for (int i = L + M - 1; i < nums.length; i++) {
            result = Math.max(result, maxL[i - M] + maxM[i]);
        }

        return result;
    }

    // Largest Sum Contiguous Subarray with At Least K Elements
    public static int maxSumWithAtLeastK(int[] nums, int K) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int maxSum = Integer.MIN_VALUE;
        int currentMax = prefixSum[K - 1];
        for (int i = K; i < n; i++) {
            currentMax = Math.max(currentMax, prefixSum[i - K]);
            maxSum = Math.max(maxSum, prefixSum[i] - currentMax);
        }

        return maxSum;
    }

    // Minimum Subarray Sum (Modified Kadane's DSA.Algorithm)
    public static int minSubArray(int[] nums) {
        int current_sum = nums[0];
        int min_sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.min(nums[i], current_sum + nums[i]);
            min_sum = Math.min(min_sum, current_sum);
        }
        return min_sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Max Subarray Sum: " + maxSubArray(nums));

        int[] circularNums = {5, -3, 5};
        System.out.println("Max Circular Subarray Sum: " + maxCircularSubArray(circularNums));

        int[] nums2 = {3, 8, 1, 3, 2, 1, 8, 9, 0};
        System.out.println("Max Sum of Two Non-Overlapping Subarrays: " + maxSumTwoNoOverlap(nums2, 3, 2));

        int[] nums3 = {1, 2, 3, -10, 4, 5, 6};
        System.out.println("Max Sum with At Least K Elements: " + maxSumWithAtLeastK(nums3, 3));

        int[] nums4 = {1, -2, 3, -4, 5};
        System.out.println("Min Subarray Sum: " + minSubArray(nums4));
    }
}

