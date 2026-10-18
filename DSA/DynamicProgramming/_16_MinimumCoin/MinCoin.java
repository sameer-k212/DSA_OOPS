
public class MinCoin {

    public static void main(String[] args) {
        int coins[] = {1};
        int amount = 0;
        int n = coins.length;
        // int cns =  recursion(coins, n-1, amount);

        // int dp[][] = new int[n][amount + 1];
        // for (int arr[] : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // int cns = memo(coins, n - 1, amount, dp);
        // if (cns == (int) Math.pow(10, 9)) {
        //     return -1;
        // } else {
        //     return cns;
        // }

        // return tabulation(coins, amount);

        System.out.println(spaceOpt(coins, amount));
    }
    public static int recursion(int coins[], int idx, int k) {
        // Base Case Done.
        if (idx == 0) {
            if (coins[idx] == k) {
                return 1;
            } else if (k % coins[idx] == 0) {
                return k / coins[idx];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        // recurence (go through all the path)
        // in case of take there is infinite supply of coins but i am taking 1 at a time. Because There is not necessary
        // to take all coins(greedily) that can be achived in the given target because it won't always gives you right ans.
        // You don't decrement idx when taking a coin because you're allowed to reuse it (infinite supply).
        int notTake = 0 + recursion(coins, idx - 1, k);
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= k) {
            take = 1 + recursion(coins, idx, k - coins[idx]);
        }

        return Math.min(take, notTake);
    }

    public static int memo(int coins[], int idx, int k, int[][] dp) {
        // Base Case Done.
        if (idx == 0) {
            if (k % coins[idx] == 0) {
                return k / coins[idx];
            } else {
                return (int) Math.pow(10, 9);
            }
        }

        if (dp[idx][k] != -1)
            return dp[idx][k];

        int notTake = 0 + memo(coins, idx - 1, k, dp);
        int take = Integer.MAX_VALUE;
        if (coins[idx] <= k) {
            take = 1 + memo(coins, idx, k - coins[idx], dp);
        }

        return dp[idx][k] = Math.min(take, notTake);
    }

    public static  int tabulation(int[] coins, int k) {
        int n = coins.length;
        int[][] dp = new int[n][k + 1];
        int INF = (int) 1e9;

        // Base Case
        for (int target = 0; target <= k; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = target / coins[0];
            } else {
                dp[0][target] = INF;
            }
        }

        // Recurrence
        for (int idx = 1; idx < n; idx++) {
            for (int target = 0; target <= k; target++) {

                int notTake = dp[idx - 1][target];
                int take = INF;
                if (coins[idx] <= target) {
                    take = 1 + dp[idx][target - coins[idx]]; // not idx - 1
                }

                dp[idx][target] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][k] >= INF ? -1 : dp[n - 1][k]; // If unreachable
    }
    public  static  int spaceOpt(int[] coins, int k) {
        int n = coins.length;
        int[] prev = new int[k + 1];
        int INF = (int) 1e9;

        // Base Case
        for (int target = 0; target <= k; target++) {
            if (target % coins[0] == 0) {
                prev[target] = target / coins[0];
            } else {
                prev[target] = INF;
            }
        }

        // Recurrence
        for (int idx = 1; idx < n; idx++) {
            int curr[] = new int[k+1];
            for (int target = 0; target <= k; target++) {

                int notTake = prev[target];
                int take = INF;
                if (coins[idx] <= target) {
                    take = 1 + curr[target - coins[idx]]; // not idx - 1. so that it will curr
                }

                curr[target] = Math.min(take, notTake);
            }
            prev = curr;
        }

        return prev[k] >= INF ? -1 : prev[k]; // If unreachable
    }

}