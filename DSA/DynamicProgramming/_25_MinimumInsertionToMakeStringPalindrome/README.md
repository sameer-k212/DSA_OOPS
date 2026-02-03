# Minimum Insertion to Make String Palindrome

## Problem Statement
Find the minimum number of insertions needed to make a string palindrome.

**Example:**
- Input: s = "abcda"
- Output: 2 (Insert 'd' and 'c' to make "adcbcda")

## Intuition
**Key Insight:** Minimum Insertions = n - LPS(s)
- Characters already in LPS don't need insertion
- Remaining characters need to be inserted

## Recursion Tree (for s = "abc")

```
                    minInsert(0, 2) "abc"
                    /              \
            s[0]==s[2]?           NO
                /                    \
        Need to insert           Need to insert
        at end or start          at end or start
            /                          \
    1 + minInsert(0,1)          1 + minInsert(1,2)
        "ab"                         "bc"
         |                            |
    s[0]==s[1]? NO              s[1]==s[2]? NO
         |                            |
    1 + minInsert(0,0)          1 + minInsert(1,1)
         = 1                          = 1
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minInsertions(String s) {
    return minInsert(s, 0, s.length() - 1);
}

private int minInsert(String s, int i, int j) {
    if (i >= j) return 0;
    
    if (s.charAt(i) == s.charAt(j))
        return minInsert(s, i + 1, j - 1);
    
    return 1 + Math.min(minInsert(s, i + 1, j), minInsert(s, i, j - 1));
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minInsertions(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return minInsert(s, 0, n - 1, dp);
}

private int minInsert(String s, int i, int j, int[][] dp) {
    if (i >= j) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    
    if (s.charAt(i) == s.charAt(j))
        return dp[i][j] = minInsert(s, i + 1, j - 1, dp);
    
    return dp[i][j] = 1 + Math.min(minInsert(s, i + 1, j, dp), 
                                    minInsert(s, i, j - 1, dp));
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minInsertions(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j))
                dp[i][j] = dp[i + 1][j - 1];
            else
                dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
        }
    }
    return dp[0][n - 1];
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 4️⃣ Using LPS (Optimal Approach)
```java
public int minInsertions(String s) {
    int n = s.length();
    int lps = longestPalindromeSubseq(s);
    return n - lps;
}

private int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];
    
    for (int i = 0; i < n; i++)
        dp[i][i] = 1;
    
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

## Visualization (s = "abcda")

```
Original: a b c d a
LPS:      a _ _ d a  (length = 3)
Missing:  _ b c _ _  (2 characters)

Result: Insert 'c' and 'b' → "abcdcba" or similar
Minimum Insertions = 5 - 3 = 2
```

## Key Formula
```
Minimum Insertions = n - LPS(s)
```

## Related Problems
- Longest Palindromic Subsequence
- Minimum Deletion to Make String Palindrome
- Palindrome Partitioning II
