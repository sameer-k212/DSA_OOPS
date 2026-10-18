
// max value in arr 100;
// max value of k 100;
public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {100, 2, 3, 1, 2};
        int n = arr.length;
        int k = 100;
        SubsetSum obj = new SubsetSum();
        System.out.println(obj.subsetSum(arr, n, k));
    }
    public  boolean subsetSum(int[] arr, int n, int k){
//        return recursion(arr, n-1, k);

//        int[][] dp = new int[arr.length][k+1];
//        for(int[] nums : dp){
//            Arrays.fill(nums, -1);
//        }
//        return memo(arr, n-1, k, dp);

//        return tabulation(arr, k);

        return spcaeOpt(arr, k);
    }
    public boolean recursion(int[] arr, int idx, int k){
        if(idx == 0){
            return arr[0] == k;
        }
        if(k == 0){
            return true;
        }
        boolean not_take = recursion(arr, idx-1, k);
        boolean take = false;
        if(arr[idx] <= k){
            take = recursion(arr, idx-1, k-arr[idx]);
        }

        return take || not_take;
    }
    public boolean memo(int[] arr, int idx, int k, int[][] dp){
        if(idx == 0){
            return arr[0] == k;
        }
        if(k == 0){
            return true;
        }

        if(dp[idx][k] != -1){
            if(dp[idx][k] == 1){
                return true;
            }else{
                return false;
            }
        }

        boolean not_take = memo(arr, idx-1, k,dp);
        boolean take = false;
        if(arr[idx] <= k){
            take = memo(arr, idx-1, k-arr[idx], dp);
        }

        boolean result =  take || not_take;
        if(result){
            dp[idx][k] = 1;
        }else{
            dp[idx][k] = 0;
        }
        return result;
    }
    public boolean tabulation(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][k + 1];

        // Base case initialization
        for (int i = 0; i < n; i++) {
            dp[i][0] = true; // sum 0 is always possible
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[i - 1][target];
                boolean take = false;
                if (target >= arr[i]) {
                    take = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = take || notTake;
            }
        }
        return dp[n - 1][k];
    }

    public boolean spcaeOpt(int[] arr, int k){
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if (arr[0] <= k) prev[arr[0]] = true;

        for(int i = 1 ; i < arr.length; i++){
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int target = 1; target <= k; target++){
                boolean take = prev[target];
                boolean not_take = false;
                if(target >= arr[i]){
                    not_take = prev[target-arr[i]];
                }

                curr[target] = take || not_take;
            }
            prev = curr;
        }
        return prev[k];
    }
}
