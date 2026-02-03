# Interleaving String

## Problem Statement
Given strings s1, s2, and s3, determine if s3 is formed by interleaving s1 and s2. Interleaving means characters from s1 and s2 are in same relative order in s3.

**Example:**
- Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
- Output: true

## Intuition
At each position in s3, character must come from either s1 or s2:
- If s3[k] == s1[i], try taking from s1
- If s3[k] == s2[j], try taking from s2
- k = i + j (position in s3)

## Recursion Tree (s1="ab", s2="cd", s3="acbd")

```
                    isInterleave(0,0,0)
                    /              \
            s3[0]=='a'?          s3[0]=='c'?
            s1[0]=='a' YES       s2[0]=='c' YES
                /                      \
        isInterleave(1,0,1)      isInterleave(0,1,1)
            /        \                /        \
    s3[1]=='c'?  s3[1]=='c'?   s3[1]=='c'?  s3[1]=='c'?
    s1[1]=='b'   s2[0]=='c'    s1[0]=='a'   s2[1]=='d'
       NO          YES            NO           NO
                    |
            isInterleave(1,1,2)
                   ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    return solve(s1, s2, s3, 0, 0, 0);
}

private boolean solve(String s1, String s2, String s3, int i, int j, int k) {
    if (k == s3.length()) return true;
    
    boolean takeS1 = false, takeS2 = false;
    
    if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
        takeS1 = solve(s1, s2, s3, i + 1, j, k + 1);
    
    if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
        takeS2 = solve(s1, s2, s3, i, j + 1, k + 1);
    
    return takeS1 || takeS2;
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length()) return false;
    
    Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
    return solve(s1, s2, s3, 0, 0, dp);
}

private boolean solve(String s1, String s2, String s3, int i, int j, Boolean[][] dp) {
    if (i + j == s3.length()) return true;
    if (dp[i][j] != null) return dp[i][j];
    
    boolean takeS1 = false, takeS2 = false;
    
    if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j))
        takeS1 = solve(s1, s2, s3, i + 1, j, dp);
    
    if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j))
        takeS2 = solve(s1, s2, s3, i, j + 1, dp);
    
    return dp[i][j] = takeS1 || takeS2;
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if (m + n != s3.length()) return false;
    
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    
    // First column (only s1)
    for (int i = 1; i <= m; i++)
        dp[i][0] = dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
    
    // First row (only s2)
    for (int j = 1; j <= n; j++)
        dp[0][j] = dp[0][j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            boolean fromS1 = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1);
            boolean fromS2 = dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            dp[i][j] = fromS1 || fromS2;
        }
    }
    
    return dp[m][n];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if (m + n != s3.length()) return false;
    
    boolean[] prev = new boolean[n + 1];
    prev[0] = true;
    
    for (int j = 1; j <= n; j++)
        prev[j] = prev[j-1] && s2.charAt(j-1) == s3.charAt(j-1);
    
    for (int i = 1; i <= m; i++) {
        boolean[] curr = new boolean[n + 1];
        curr[0] = prev[0] && s1.charAt(i-1) == s3.charAt(i-1);
        
        for (int j = 1; j <= n; j++) {
            boolean fromS1 = prev[j] && s1.charAt(i-1) == s3.charAt(i+j-1);
            boolean fromS2 = curr[j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            curr[j] = fromS1 || fromS2;
        }
        prev = curr;
    }
    
    return prev[n];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

## Visualization (s1="aabcc", s2="dbbca", s3="aadbbcbcac")

```
DP Table:
       ""  d   b   b   c   a
    ┌───┬───┬───┬───┬───┬───┐
 "" │ T │ F │ F │ F │ F │ F │
    ├───┼───┼───┼───┼───┼───┤
 a  │ T │ F │ F │ F │ F │ F │
    ├───┼───┼───┼───┼───┼───┤
 a  │ T │ T │ F │ F │ F │ F │
    ├───┼───┼───┼───┼───┼───┤
 b  │ F │ T │ T │ T │ F │ F │
    ├───┼───┼───┼───┼───┼───┤
 c  │ F │ F │ T │ T │ T │ T │
    ├───┼───┼───┼───┼───┼───┤
 c  │ F │ F │ F │ T │ T │ T │
    └───┴───┴───┴───┴───┴───┘

Answer: TRUE
```

## Key Pattern
```
String DP with Two Sources:
- dp[i][j] = can form s3[0..i+j-1] using s1[0..i-1] and s2[0..j-1]
- Character at s3[i+j-1] must match either s1[i-1] or s2[j-1]
```

## Related Problems
- Edit Distance
- Longest Common Subsequence
- Shortest Common Supersequence

![img.png](img.png)
![img_1.png](img_1.png)