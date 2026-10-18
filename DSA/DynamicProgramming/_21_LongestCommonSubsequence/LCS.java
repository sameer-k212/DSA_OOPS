import java.util.*;
public class LCS {
    public static void main(String[] args) {
        String str1 = "aed"; int n1 = str1.length();
        String str2 = "acd"; int n2 = str2.length();

        System.out.println(recursion(str1, str2, n1-1, n2-1));
        String dp[][] = new String[n1][n2];
    }
    public static int recursion(String str1, String str2, int idx1, int idx2){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }

        if(str1.charAt(idx1) == str2.charAt(idx2)){
            return 1 + recursion(str1, str2, idx1-1, idx2-1);
        }

        return Math.max(recursion(str1, str2, idx1-1, idx2), recursion(str1, str2, idx1, idx2-1));
    }
    public static int tabulation(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        // Fill the dp array using dynamic programming
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }
    static int spaceOpt(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store the LCS lengths
        int prev[] = new int[m + 1];
        int cur[] = new int[m + 1];

        // Iterate through the strings and calculate LCS lengths
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                // If the characters at the current indices are the same, increment the LCS length
                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1))
                    cur[ind2] = 1 + prev[ind2 - 1];
                    // If the characters are different, choose the maximum LCS length by either
                    // excluding a character in s1 or excluding a character in s2
                else
                    cur[ind2] = Math.max(prev[ind2], cur[ind2 - 1]);
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = (int[]) (cur.clone());
        }

        return prev[m]; // Return the length of the Longest Common Subsequence (LCS)
    }
}
