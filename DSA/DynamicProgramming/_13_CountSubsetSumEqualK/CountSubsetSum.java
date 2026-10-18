
public class CountSubsetSum {
    public static void main(String[] args) {
        int[] numbs = {1, 2, 3};
        int n = numbs.length;
        int target = 3;

//        System.out.println(recursion(numbs, target, n - 1));

//        int[][] dp = new int[n][target+1];
//        for(int[] arr : dp){
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(memo(numbs, target, n - 1, dp));

//        System.out.println(tabulation(numbs, target));


        System.out.println(spaceOpt(numbs, target, n - 1));
    }

    public static int recursion(int[] numbs, int k, int idx) {
        if (idx == 0) {
            if(k == 0 && numbs[0] == 0) return 2;
            if(k == 0 || k == numbs[0]) return 1;
            return 0;
        }

        int notPick = recursion(numbs, k, idx - 1);
        int pick = 0;
        if (numbs[idx] <= k) {
            pick = recursion(numbs, k - numbs[idx], idx - 1);
        }

        return pick + notPick;
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

    public static int tabulation(int[] numbs, int k) {
        int n = numbs.length;
        int[][] dp = new int[n][k+1];
        // First Task is to fill the base case.
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }

        if(numbs[0] == 0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
            if(numbs[0] <= k) {
                dp[0][numbs[0]] = 1;
            }
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
    public static int spaceOpt(int[] numbs, int k, int idx) {
        int n = numbs.length;
        int[] prev = new int[k+1];

        if(numbs[0] == 0) {
            prev[0] = 2;
        } else {
            prev[0] = 1;
            if(numbs[0] <= k){
                prev[numbs[0]] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[k+1];
            curr[0] = 1;
            for(int j = 0; j <= k; j++){
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
