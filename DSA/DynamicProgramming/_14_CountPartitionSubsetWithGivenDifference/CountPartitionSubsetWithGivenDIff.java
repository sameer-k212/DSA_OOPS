import java.util.Arrays;

public class CountPartitionSubsetWithGivenDIff {
    int mod = 1000000009;
    public static void main(String[] args) {
        int[] numbs = {1, 2, 3, 4};
        int diff = 2;
        function(numbs, diff);
    }
    public static void function(int[] nums, int diff){
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums ){
            totalSum += num;
        }
        if(totalSum - diff < 0) return;

        if((totalSum - diff) % 2 == 0){
            int target = (totalSum - diff) / 2;
            int[][] dp = new int[n][target+1];
            for(int[] arr : dp){
                Arrays.fill(arr, -1);
            }
//            System.out.println(memo(nums, target, n - 1, dp));
            System.out.println(tabulation(nums, target));
        }else{
            return;
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
