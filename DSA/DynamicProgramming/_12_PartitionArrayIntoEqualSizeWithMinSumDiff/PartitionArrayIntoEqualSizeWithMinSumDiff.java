// Remember nums[i] >= 0;

public class PartitionArrayIntoEqualSizeWithMinSumDiff {
    // Direct Tabulation method from the Problem no. Partition into equal subset.
    public static int minimumDifference(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        int k = totalSum;
        int n = nums.length;
        boolean[][] dp = new boolean[n][k + 1];

        // Base case initialization
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // sum 0 is always possible
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= nums[i]) {
                    take = dp[i - 1][target - nums[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        for(int i = 0 ; i < dp.length; i++){
            for(int j = 0 ; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int minDiff = Integer.MAX_VALUE;
        // in last row there will all sum value of all possible target
        for(int i = 0; i <= totalSum/2; i++){
            if(dp[n-1][i] == true){
                minDiff = Math.min(minDiff, Math.abs(i - (totalSum-i)));
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        minimumDifference(new int[]{1, 2, 4, 3});
    }
}
