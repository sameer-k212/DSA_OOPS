
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // return recursion(obstacleGrid, m-1, n-1);

        // int dp[][] = new int[m][n];
        // for (int arr[] : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // return memo(obstacleGrid, m - 1, n - 1, dp);

        // return tabulation(obstacleGrid, m, n);

        return space(obstacleGrid, m, n);
    }

    // DSA.Recursion (Top Down)
    public int recursion(int grid[][], int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        int up = recursion(grid, i - 1, j);
        int left = recursion(grid, i, j - 1);

        return up + left;
    }

    // Memo
    public int memo(int grid[][], int i, int j, int dp[][]) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (grid[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = memo(grid, i - 1, j, dp);
        int left = memo(grid, i, j - 1, dp);

        return dp[i][j] = up + left;
    }
    // tabulation
    public int tabulation(int grid[][], int m, int n){
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else if( i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
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
    // Space Optimizatio
    public int space(int grid[][], int m, int n){
        int prev[] = new int[n];

        for(int i = 0; i < m; i++){
            int curr[] = new int[n];
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 1){
                    curr[j] = 0;
                }else if( i == 0 && j == 0){
                    curr[j] = 1;
                }else{
                    int up = 0;
                    int left = 0;
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
