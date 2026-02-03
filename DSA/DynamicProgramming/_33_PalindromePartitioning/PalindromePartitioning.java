package DSA_OOPS.DSA.DynamicProgramming._33_PalindromePartitioning;

public class PalindromePartitioning {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || isPalin[j + 1][i - 1])) {
                    isPalin[j][i] = true;
                }
            }
        }
        
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalin[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = i;
                for (int j = 1; j <= i; j++) {
                    if (isPalin[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
    
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts: " + minCut(s));
    }
}
