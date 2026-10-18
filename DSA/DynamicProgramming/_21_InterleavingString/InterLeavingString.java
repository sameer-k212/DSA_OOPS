import java.util.*;
public class InterLeavingString {
        public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (n3 != n1 + n2)
            return false;
        if ((n1 == 0 || n2 == 0) && n3 != 0) {
            return s1.equals(s3) || s2.equals(s3);
        }

//        int dp[][] = new int[n1 + 1][n2 + 1];
//        for (int arr[] : dp) {
//            Arrays.fill(arr, -1);
//        }
        int dp[][][] = new int[n1+1][n2+1][n3+1];
        for(int arr[][] : dp){
            for(int temp[] : arr){
                Arrays.fill(temp, -1);
            }
        }

//        return memo(0, 0, 0, s1, s2, s3, dp);

        return tabulation(s1, s2, s3);
    }
    public boolean memo(int i, int j, int k, String s1, String s2, String s3, int dp[][][]) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (k == n3) {
            return i == n1 && j == n2;
        }

        if(dp[i][j][k] != -1){
            if(dp[i][j][k] == 1) return true;
            else return false;
        }

        boolean s1b = false;
        boolean s2b = false;
        if (i < n1 && s1.charAt(i) == s3.charAt(k)) {
            s1b = memo(i + 1, j, k + 1, s1, s2, s3, dp);
        }
        if (!s1b && j < n2 && s2.charAt(j) == s3.charAt(k)) {
            s2b = memo(i, j + 1, k + 1, s1, s2, s3, dp);
        }

        boolean result =  s1b || s2b;
        if(result == true){
            dp[i][j][k] = 1;
        }else{
            dp[i][j][k] = 0;
        }
        return result;
    }

    public boolean memo(int i, int j, String s1, String s2, String s3, int dp[][]) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        if (i + j == n3) {
            return i == n1 && j == n2;
        }

        if(dp[i][j] != -1){
            if(dp[i][j] == 1) return true;
            else return false;
        }

        boolean s1b = false;
        boolean s2b = false;
        if (i < n1 && s1.charAt(i) == s3.charAt(i+j)) {
            s1b = memo(i + 1, j, s1, s2, s3, dp);
        }
        if (!s1b && j < n2 && s2.charAt(j) == s3.charAt(i+j)) {
            s2b = memo(i, j + 1, s1, s2, s3, dp);
        }

        boolean result =  s1b || s2b;
        if(result == true){
            dp[i][j] = 1;
        }else{
            dp[i][j] = 0;
        }
        return result;
    }

    public boolean tabulation(String s1, String s2, String s3) {
        int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
        boolean dp[][] = new boolean[n1 + 1][n2 + 1];

        // base case ho gya.
        // dp[n1][n2] = true;

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                if (i == n1 && j == n2) {
                    dp[i][j] = true;
                } else {
                    boolean s1b = false;
                    if (i < n1 && s1.charAt(i) == s3.charAt(i + j)) {
                        s1b = dp[i + 1][j];
                    }

                    boolean s2b = false;
                    if (!s1b && j < n2 && s2.charAt(j) == s3.charAt(i + j)) {
                        s2b = dp[i][j + 1];
                    }

                    dp[i][j] = s1b || s2b;
                }

            }

        }
        for(int i = 0 ; i <= n1; i++){
            for(int j = 0 ; j <= n2; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][0];
    }
}
