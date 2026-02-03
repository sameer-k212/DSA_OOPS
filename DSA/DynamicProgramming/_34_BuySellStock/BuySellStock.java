package DSA_OOPS.DSA.DynamicProgramming._34_BuySellStock;

public class BuySellStock {
    // Single Transaction
    public static int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
    
    // Unlimited Transactions
    public static int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    
    // At Most K Transactions
    public static int maxProfitK(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        
        int[][] dp = new int[k + 1][n];
        for (int t = 1; t <= k; t++) {
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }
        return dp[k][n - 1];
    }
    
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (1 txn): " + maxProfit1(prices));
        System.out.println("Max Profit (unlimited): " + maxProfit2(prices));
        System.out.println("Max Profit (2 txn): " + maxProfitK(2, prices));
    }
}
