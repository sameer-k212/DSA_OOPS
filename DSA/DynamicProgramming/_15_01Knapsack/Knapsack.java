package DSA_OOPS.DSA.DynamicProgramming._15_01Knapsack;

public class Knapsack {
    static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length;
        // return recursion(val, wt, n-1, W);


        // int dp[][] = new int[n][W+1];
        // for(int arr[] : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return memo(val, wt, n-1, W, dp);

        // return tabulation(val, wt, W);

        // return spaceOpt(val, wt, W);

        return optimalSolution(val, wt, W);

    }
    public static int recursion(int val[], int wt[], int idx, int w){
        // Base Case
        if(idx == 0){
            if(wt[idx] <= w){
                return val[0];
            }else{
                return 0;
            }
        }

        int take = Integer.MIN_VALUE;
        if(wt[idx] <= w){
            take = val[idx] + recursion(val, wt, idx-1, w-wt[idx]);
        }
        int notTake = 0 + recursion(val, wt, idx-1, w);


        return Math.max(take, notTake);
    }
    public static int memo(int val[], int wt[], int idx, int w, int dp[][]){
        // Base Case
        if(idx == 0){
            if(wt[idx] <= w){
                return val[0];
            }else{
                return 0;
            }
        }

        if(dp[idx][w] != -1) return dp[idx][w];

        int take = Integer.MIN_VALUE;
        if(wt[idx] <= w){
            take = val[idx] + recursion(val, wt, idx-1, w-wt[idx]);
        }
        int notTake = 0 + recursion(val, wt, idx-1, w);


        return dp[idx][w] = Math.max(take, notTake);
    }
    public static int tabulation(int val[], int wt[], int maxWeight){
        int n = val.length;
        int dp[][] = new int[n][maxWeight+1];

        // Filling the base case.
        for(int w = wt[0]; w <= maxWeight; w++){
            dp[0][w] = val[0];
        }

        // recurence
        for(int i = 1; i <= n-1; i++){ // for index
            for(int w = 0; w <= maxWeight; w++){ // for w
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + dp[i-1][w-wt[i]];
                }
                int notTake = 0 + dp[i-1][w];

                dp[i][w] = Math.max(take, notTake);
            }
        }
        return dp[n-1][maxWeight];
    }
    public static int spaceOpt(int val[], int wt[], int maxWeight){
        int n = val.length;
        int prev[] = new int[maxWeight+1];

        // Filling the base case.
        for(int w = wt[0]; w <= maxWeight; w++){
            prev[w] = val[0];
        }

        // recurence
        for(int i = 1; i <= n-1; i++){ // for index
            int curr[] = new int[maxWeight+1];
            for(int w = 0; w <= maxWeight; w++){ // for w
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + prev[w-wt[i]];
                }
                int notTake = 0 + prev[w];

                curr[w] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[maxWeight];
    }
    public static int optimalSolution(int val[], int wt[], int maxWeight){
        int n = val.length;
        int prev[] = new int[maxWeight+1];

        // Filling the base case.
        for(int w = wt[0]; w <= maxWeight; w++){
            prev[w] = val[0];
        }

        // recurence
        for(int i = 1; i <= n-1; i++){ // for index
            for(int w = maxWeight; w >= 0; w--){ // for w
                int take = Integer.MIN_VALUE;
                if(wt[i] <= w){
                    take = val[i] + prev[w-wt[i]];
                }
                int notTake = 0 + prev[w];

                prev[w] = Math.max(take, notTake);
            }
        }
        return prev[maxWeight];
    }
    public static void main(String[] args) {
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int maxWeight = 4;
        System.out.println(knapsack(maxWeight, val, wt));
    }
}
