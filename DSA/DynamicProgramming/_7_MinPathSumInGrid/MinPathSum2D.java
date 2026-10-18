
public class MinPathSum2D {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // return recursion(grid, m-1, n-1);

        // int dp[][] = new int[m][n];
        // for(int arr[] : dp){
        //     Arrays.fill(arr, -1);
        // }
        // return memo(grid, m-1, n-1, dp);

        // return tabulation(grid, m, n);

        return spaceOpt(grid, m, n);
    }
    // DSA.Recursion
    public int recursion(int grid[][], int i, int j){
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(i < 0 || j < 0){
            return Integer.MAX_VALUE/100;
        }

        int up = grid[i][j] + recursion(grid, i - 1, j);
        int left = grid[i][j] + recursion(grid, i, j-1);

        return Math.min(up, left);
    }
    // recursion + Memo (top down)
    public int memo(int grid[][], int i, int j, int dp[][]){
        if(i < 0 || j < 0) return Integer.MAX_VALUE/100;

        if(i == 0 && j == 0) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int up = grid[i][j] + memo(grid, i - 1, j, dp);
        int left = grid[i][j] + memo(grid, i, j-1, dp);

        return dp[i][j]=Math.min(up, left);
    }
    // tabulation (bottom up)
    public int tabulation(int grid[][], int m, int n){
        int[][] dp = new int[m][n];

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                }
                else{
                    int up = grid[i][j];
                    if(i > 0){
                        up += dp[i-1][j];
                    }else{
                        up += Integer.MAX_VALUE/100;
                    }

                    int left = grid[i][j];
                    if(j > 0){
                        left += dp[i][j-1];
                    }
                    else{
                        left += Integer.MAX_VALUE/100;
                    }

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    // Space Optimization
    public int spaceOpt(int grid[][], int m, int n){
        int[] prev = new int[n];

        for(int i = 0 ; i < m; i++){
            int[] curr = new int[n];

            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0){
                    curr[j] = grid[i][j];
                }
                else{
                    int up = grid[i][j];
                    // Prev row's j column.
                    if(i > 0) up += prev[j];
                    else up += Integer.MAX_VALUE/100;

                    int left = grid[i][j];
                    // curr row's j-1 column.
                    if(j > 0) left += curr[j-1];
                    else left += Integer.MAX_VALUE/100;

                    curr[j] = Math.min(up, left);
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }
}
