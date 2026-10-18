
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
    int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
        totalSum += nums[i];
    }
        if(totalSum % 2 != 0) return false;
    // return recursion(nums, nums.length-1, totalSum/2);


    // int dp[][] = new int[nums.length][totalSum/2+1];
    // for(int arr[] : dp){
    //     Arrays.fill(arr, -1);
    // }
    // return memo(nums, nums.length-1, totalSum/2, dp);


    // return tabulation(nums, totalSum/2);


        return spaceOpt(nums, totalSum/2);
}
public boolean recursion(int[] arr, int idx, int k){
    // Base Case Hoga Gya Bhai..
    if(idx == 0) return arr[idx] == k;
    if(k == 0) return true;


    // Now Reurence Relation..
    boolean notTake = recursion(arr, idx-1, k);
    boolean take = false;
    if(arr[idx] <= k){
        take = recursion(arr, idx-1, k-arr[idx]);
    }

    // returning Result.
    return take || notTake;
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
public boolean spaceOpt(int[] arr, int k){
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