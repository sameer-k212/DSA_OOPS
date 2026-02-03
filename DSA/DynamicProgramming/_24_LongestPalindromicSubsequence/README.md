# Longest Palindromic Subsequence (LPS)

## Problem Statement
Find the length of the longest palindromic subsequence in a given string.

**Example:**
- Input: s = "bbbab"
- Output: 4 (Explanation: "bbbb" is the longest palindromic subsequence)

## Intuition
A palindrome reads the same forwards and backwards. The key insight: **LPS(s) = LCS(s, reverse(s))**

## Recursion Tree (for s = "babad")

```
                    lps(0, 4) "babad"
                    /              \
            s[0]==s[4]?           NO
                /                    \
        lps(0,3) "baba"          lps(1,4) "abad"
           /        \               /         \
      s[0]==s[3]?  NO          s[1]==s[4]?   NO
        /      \                 /        \
   lps(0,2)  lps(1,3)      lps(1,3)    lps(2,4)
   "bab"     "aba"         "aba"       "bad"
     |         |             |           |
    ...       ...           ...         ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int longestPalindromeSubseq(String s) {
    return lps(s, 0, s.length() - 1);
}

private int lps(String s, int i, int j) {
    if (i > j) return 0;
    if (i == j) return 1;
    
    if (s.charAt(i) == s.charAt(j))
        return 2 + lps(s, i + 1, j - 1);
    
    return Math.max(lps(s, i + 1, j), lps(s, i, j - 1));
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return lps(s, 0, n - 1, dp);
}

private int lps(String s, int i, int j, int[][] dp) {
    if (i > j) return 0;
    if (i == j) return 1;
    if (dp[i][j] != -1) return dp[i][j];
    
    if (s.charAt(i) == s.charAt(j))
        return dp[i][j] = 2 + lps(s, i + 1, j - 1, dp);
    
    return dp[i][j] = Math.max(lps(s, i + 1, j, dp), lps(s, i, j - 1, dp));
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    
    // Base case: single character
    for (int i = 0; i < n; i++)
        dp[i][i] = 1;
    
    // Fill table for substrings of length 2 to n
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j))
                dp[i][j] = 2 + (len == 2 ? 0 : dp[i + 1][j - 1]);
            else
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
    }
    return dp[0][n - 1];
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 4️⃣ Space Optimized (Using LCS Approach)
```java
public int longestPalindromeSubseq(String s) {
    String rev = new StringBuilder(s).reverse().toString();
    return lcs(s, rev);
}

private int lcs(String s1, String s2) {
    int n = s1.length();
    int[] prev = new int[n + 1];
    
    for (int i = 1; i <= n; i++) {
        int[] curr = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                curr[j] = 1 + prev[j - 1];
            else
                curr[j] = Math.max(prev[j], curr[j - 1]);
        }
        prev = curr;
    }
    return prev[n];
}
```
**Time:** O(n²) | **Space:** O(n)

---

## Key Patterns
- **Two Pointer Pattern** (i from start, j from end)
- **LCS Variant** (LPS = LCS of string and its reverse)
- **Interval DP** (solving for substrings)

## Related Problems
- Longest Common Subsequence
- Minimum Insertion to Make String Palindrome
- Palindrome Partitioning
