
public class WaysToGetTargetUsingCoinsOfINFAmount {
    // In Just How "Many Ways" Question  we have to return either 1 or 0(Based on target Achived or not).
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // return recursion(coins, n-1, amount);

        // int[][] dp = new int[n][amount + 1];
        // for (int arr[] : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // return memo(coins, n - 1, amount, dp);

        // return tabulation(coins, amount);

        return spaceOpt(coins, amount);
    }

    public int recursion(int coins[], int idx, int k) {
        // Base Case Done.
        if (idx == 0) {
            if (k % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // recurence (go through all the path)
        int notTake = recursion(coins, idx - 1, k);
        int take = 0;
        if (coins[idx] <= k) {
            take = recursion(coins, idx, k - coins[idx]);
        }

        return take + notTake;
    }

    // Top Down
    public int memo(int coins[], int idx, int k, int[][] dp) {
        // Base Case Done.
        if (idx == 0) {
            if (k % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[idx][k] != -1)
            return dp[idx][k];

        // recurence (go through all the path)
        int notTake = memo(coins, idx - 1, k, dp);
        int take = 0;
        if (coins[idx] <= k) {
            take = memo(coins, idx, k - coins[idx], dp);
        }

        return dp[idx][k] = take + notTake;
    }

    public int tabulation(int coins[], int k) {
        int n = coins.length;
        int dp[][] = new int[n][k + 1];

        // Base Case Done.
        for (int target = 0; target <= k; target++) {
            if (target % coins[0] == 0)
                dp[0][target] = 1;
            else
                dp[0][target] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= k; target++) {

                int notTake = dp[i-1][target];
                int take = 0;
                if (coins[i] <= target){
                    take = dp[i][target-coins[i]];
                }

                dp[i][target] = take + notTake;
            }
        }

        return dp[n-1][k];
    }
    public int spaceOpt(int coins[], int k){
        int n = coins.length;
        int prev[] = new int[k + 1];

        // Base Case Done.
        for (int target = 0; target <= k; target++) {
            if (target % coins[0] == 0)
                prev[target] = 1;
            else
                prev[target] = 0;
        }

        for (int i = 1; i < n; i++) {
            int curr[] = new int[k+1];
            for (int target = 0; target <= k; target++) {

                int notTake = prev[target];
                int take = 0;
                if (coins[i] <= target){
                    take = curr[target-coins[i]];
                }

                curr[target] = take + notTake;
            }
            prev = curr;
        }

        return prev[k];
    }
}
