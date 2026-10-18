import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // return recursion(triangle, 0, 0, n);

        int dp[][] = new int[n][n];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return memo(triangle, 0, 0, n, dp);

        // return tabulation(triangle, n);

        // return spaceOpt(triangle, n);
    }

    // DSA.Recursion
    public int recursion(List<List<Integer>> list, int i, int j, int n) {
        if (i == n - 1)
            return list.get(i).get(j);

        int down = list.get(i).get(j) + recursion(list, i + 1, j, n);
        int digonal = list.get(i).get(j) + recursion(list, i + 1, j + 1, n);

        return Math.min(down, digonal);
    }

    // Memo (Top Down)
    public int memo(List<List<Integer>> list, int i, int j, int n, int dp[][]) {
        if (i == n - 1)
            return list.get(i).get(j);

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = list.get(i).get(j) + memo(list, i + 1, j, n, dp);
        int digonal = list.get(i).get(j) + memo(list, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(down, digonal);
    }

    // Tabulation (Bottom Up)
    public int tabulation(List<List<Integer>> list, int n) {
        int dp[][] = new int[n][n];

        // Base Case Done.
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = list.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--){

                int down = list.get(i).get(j) + dp[i + 1][j];
                int digonal = list.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, digonal);
            }

        }
        return dp[0][0];
    }
    // Space Optimization
    public int spaceOpt(List<List<Integer>> list, int n){
        int prev[] = new int[n];

        for (int j = 0; j < n; j++) {
            prev[j] = list.get(n - 1).get(j);
        }


        for (int i = n - 2; i >= 0; i--) {

            int curr[] = new int[n];
            for (int j = i; j >= 0; j--){

                int down = list.get(i).get(j) + prev[j];
                int digonal = list.get(i).get(j) + prev[j+1];
                curr[j] = Math.min(down, digonal);
            }

            prev = curr;

        }
        return prev[0];
    }
}
