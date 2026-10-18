
public class WildcardMatching {
    public static void main(String[] args) {
        String str1 = "ab*fg"; int n = str1.length();
        String str2 = "abcdefg"; int m = str2.length();

        System.out.println(recursion(str1, n-1, str2, m-1));

    }
    public static boolean recursion(String pattern, int i, String str2, int j) {
        if (i < 0 && j < 0) return true;

        if (i < 0 && j >= 0) return false;

        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true; // Fix: return must be here, not in else
        }

        // Try all possible paths
        if (pattern.charAt(i) == str2.charAt(j) || pattern.charAt(i) == '?') {
            return recursion(pattern, i - 1, str2, j - 1); // Fix: must return
        }

        if (pattern.charAt(i) == '*') {
            return recursion(pattern, i - 1, str2, j) || recursion(pattern, i, str2, j - 1);
        }

        return false;
    }
    public boolean memo(String pattern, int i, String str2, int j, Boolean[][] dp) {
        if (i < 0 && j < 0) return true;
        if (i < 0 && j >= 0) return false;

        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if (dp[i][j] != null) return dp[i][j];

        if (pattern.charAt(i) == str2.charAt(j) || pattern.charAt(i) == '?') {
            dp[i][j] = memo(pattern, i - 1, str2, j - 1, dp);  // fixed call
        } else if (pattern.charAt(i) == '*') {
            dp[i][j] = memo(pattern, i - 1, str2, j, dp) || memo(pattern, i, str2, j - 1, dp); // fixed call
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
    public boolean tabulation(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*') dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
