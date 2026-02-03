package DSA.DynamicProgramming;

public class CoinChange {
    // Recursive..
//    Input: amount = 5, coins = [1,2,5]
//    Output: 4
//    Explanation: there are four ways to make up the amount:
//            5=5
//            5=2+2+1
//            5=2+1+1+1
//            5=1+1+1+1+1
    int count  = 0;
    public void recurr(int amount, int[] coins, int idx) {
        if (amount == 0) {
            count++;
            return ; // Found a valid combination
        }
        if (amount < 0 || idx >= coins.length) {
            return ; // No valid combination
        }
        // Use a for loop to consider all coins starting from `idx`
        for (int i = idx; i < coins.length; i++) {
            recurr(amount - coins[i], coins, i); // Include current coin
        }
    }

    // TD Approach
    public int TD(int amount, int[] coins, int idx, int dp[][]) {
        if (amount == 0) {
            return 1; // Found a valid combination
        }
        if (amount < 0 || idx >= coins.length) {
            return 0; // No valid combination
        }
        if (dp[amount][idx] != -1) {
            return dp[amount][idx]; // Return memoized result
        }

        int ways = 0;
        // Use a for loop to consider all coins starting from `idx`
        for (int i = idx; i < coins.length; i++) {
            ways += TD(amount - coins[i], coins, i, dp); // Include current coin
        }

        dp[amount][idx] = ways; // Store the result
        return dp[amount][idx];
    }
    // BU Approach
    public static int BU(int [] coin,int amt) {
        int[][] dp = new int[coin.length + 1][amt + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int c = 1; c < dp.length; c++) {
            for (int am = 1; am < dp[0].length; am++) {
                int inc = 0;
                int exc = 0;
                if (am >= coin[c - 1]) {
                    inc = dp[c][am - coin[c - 1]];
                }
                exc = dp[c - 1][am];
                dp[c][am] = inc + exc;
            }

        }
        return dp[dp.length - 1][dp.length - 1];
    }
}
