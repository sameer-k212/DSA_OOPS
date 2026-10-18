import java.util.*;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        int len = nums.length;
        for(int n : nums){
            totalSum += n;
        }
        if(totalSum - target < 0) return 0;
        if((totalSum - target) % 2 == 0){
            int t = (totalSum - target) / 2;
            int[][] dp = new int[len][t+1];
            for(int[] arr : dp){
                Arrays.fill(arr, -1);
            }
            // return memo(nums, t, len - 1, dp);
            // return tabulation(nums, t);
            return spaceOpt(nums, t);
        }else{
            return 0;
        }
    }
    public static int memo(int[] numbs, int k, int idx , int[][] dp) {
        if (idx == 0) {
            if(k == 0 && numbs[0] == 0) return 2;
            if(k == 0 || k == numbs[0]) return 1;
            return 0;
        }

        if(dp[idx][k] != -1) return dp[idx][k];

        int notPick = memo(numbs, k, idx - 1, dp);
        int pick = 0;
        if (numbs[idx] <= k) {
            pick = memo(numbs, k - numbs[idx], idx - 1, dp);
        }

        return dp[idx][k] = pick + notPick;
    }
    public static int tabulation(int[] numbs, int k){
        int n = numbs.length;
        int[][] dp = new int[n][k+1];

        // First Task is to fill the base case.
        if(numbs[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;


        if(numbs[0] != 0 && numbs[0] <= k){
            dp[0][numbs[0]] = 1;
        }

        // traversal
        for(int i = 1; i < n; i++){ // for index

            for(int j = 0; j <= k; j++){ // for target
                int notPick = dp[i-1][j];
                int pick = 0;
                if (numbs[i] <= j) {
                    pick = dp[i-1][j-numbs[i]];
                }

                dp[i][j] = pick + notPick;
            }
        }

        return dp[n-1][k];
    }
    public static int spaceOpt(int[] numbs, int k){
        int n = numbs.length;
        int[] prev = new int[k+1];

        // First Task is to fill the base case.
        if(numbs[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;


        if(numbs[0] != 0 && numbs[0] <= k){
            prev[numbs[0]] = 1;
        }

        // traversal
        for(int i = 1; i < n; i++){ // for index
            int[] curr = new int[k+1];
            curr[0] = 1;
            for(int j = 0; j <= k; j++){ // for target
                int notPick = prev[j];
                int pick = 0;
                if (numbs[i] <= j) {
                    pick = prev[j-numbs[i]];
                }

                curr[j] = pick + notPick;
            }
            prev = curr;
        }

        return prev[k];
    }
}