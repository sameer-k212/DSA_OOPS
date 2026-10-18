
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // return recurrsion(m-1, n-1);

        // int dp[][] = new int[m][n];
        // for(int arr[] : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return memo(dp, m-1, n-1);

        // return tabulation(m, n);

        return space(m, n);
    }
    // Recursive Approach : Top Down
    public int recurrsion(int i, int j){
        // Step-1 Base Case
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }

        // Step-2 Traversal On All Possible Path
        int up = recurrsion(i-1, j);
        int left = recurrsion(i, j-1);


        // Step-3 Sum Up All Paths
        return up + left;
    }
    // Memoization: Just Because, When You See The Tree Of This Problem You Will See Overlaping Sub Problems.
    // 2D DP Because, There Is Two Varing Variables.
    public int memo(int dp[][], int i, int j){
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = memo(dp, i-1, j);
        int left = memo(dp, i, j-1);

        return dp[i][j] = up + left;
    }

    // Tabulation : (Bottom Up Approach: You Start From Base Case)
    public int tabulation(int m, int n){
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                else{
                    int up = 0;
                    int left = 0;
                    if(i > 0){
                        up = dp[i-1][j];
                    }
                    if(j > 0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
    // Space Optimization
    public int space(int m, int n){
        int prev[] = new int[n];

        for(int i = 0 ; i < m; i++){

            int curr[] = new int[n];
            for(int j = 0 ; j < n; j++){
                if(i == 0 && j == 0){
                    curr[j] = 1;
                }else {
                    int up = 0, left = 0;
                    if(i > 0){
                        up = prev[j];
                    }
                    if(j > 0){
                        left = curr[j-1];
                    }
                    curr[j] = up + left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

}
