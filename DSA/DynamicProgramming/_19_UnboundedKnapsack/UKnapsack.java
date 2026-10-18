
public class UKnapsack {
    public static void main(String[] args) {
        int val[] = {6, 1, 7, 7};
        int wt[] = {1, 3, 4, 5};
        int capacity = 8;
        System.out.println(knapSack(val, wt, capacity));
    }
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        // return recursion(val, n-1, wt, capacity);

        // int[][] dp = new int[n][capacity+1];
        // for(int[] arr : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return memo(val, n-1, wt, capacity, dp);

        // return tabulation(val, wt, capacity);

        return spaceOpt(val, wt, capacity);

    }
    public static int recursion(int val[], int idx, int wt[], int maxWeight){
        if(idx == 0){
            return (int)(maxWeight/wt[0]) * val[0];
        }


        int notTake = recursion(val, idx-1, wt, maxWeight);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= maxWeight){
            take = val[idx] + recursion(val, idx, wt, maxWeight-wt[idx]);
        }


        return Math.max(take, notTake);
    }
    public static int memo(int val[], int idx, int wt[], int maxWeight, int[][] dp){
        if(idx == 0){
            return (int)(maxWeight/wt[0]) * val[0];
        }

        if(dp[idx][maxWeight] != -1){
            return dp[idx][maxWeight];
        }

        int notTake = memo(val, idx-1, wt, maxWeight, dp);
        int take = Integer.MIN_VALUE;
        if(wt[idx] <= maxWeight){
            take = val[idx] + memo(val, idx, wt, maxWeight-wt[idx], dp);
        }

        return dp[idx][maxWeight] = Math.max(take, notTake);
    }
    public static int tabulation(int val[], int wt[], int maxWeight){
        int n = val.length;
        int[][] dp = new int[n][maxWeight+1];

        // Base Case Filling.
        for(int weight = 0; weight <= maxWeight; weight++){
            dp[0][weight] = (int)(weight/wt[0]) * val[0];
        }

        // Try Out All Possible Path.....
        for(int i = 1; i < n; i++){
            for(int weight = 0; weight <= maxWeight; weight++){

                int notTake = dp[i-1][weight];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= weight){
                    take = val[i] + dp[i][weight-wt[i]];
                }
                dp[i][weight] = Math.max(take, notTake);

            }
        }


        return dp[n-1][maxWeight];
    }
    public static int spaceOpt(int val[], int wt[], int maxWeight){
        int n = val.length;
        int prev[] = new int[maxWeight+1];

        // Base Case Filling.
        for(int weight = 0; weight <= maxWeight; weight++){
            prev[weight] = (int)(weight/wt[0]) * val[0];
        }

        // Try Out All Possible Path.....
        for(int i = 1; i < n; i++){
            int curr[] = new int[maxWeight+1];
            for(int weight = 0; weight <= maxWeight; weight++){

                int notTake = prev[weight];
                int take = Integer.MIN_VALUE;
                if(wt[i] <= weight){
                    take = val[i] + curr[weight-wt[i]];
                }
                curr[weight] = Math.max(take, notTake);

            }
            prev = curr;
        }


        return prev[maxWeight];
    }
}
