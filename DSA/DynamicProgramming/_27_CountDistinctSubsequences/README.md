# Distinct Subsequences

## Problem Statement
Given two strings s and t, return the number of distinct subsequences of s which equals t.

**Example:**
- Input: s = "rabbbit", t = "rabbit"
- Output: 3 (Explanation: "rabb**b**it", "rab**b**bit", "ra**b**bbit")

## Intuition
For each character in s, we have two choices:
1. Match with current character in t (if they're equal)
2. Skip the character in s

## Recursion Tree (s="rab", t="ra")

```
                    count(0, 0)
                    /          \
            s[0]==t[0]? YES     
                /                \
        Match 'r'              Skip 'r'
            /                      \
    count(1,1) + count(1,0)    count(1,0)
        /    \                     /    \
   s[1]==t[1]? YES          s[1]==t[0]? NO
      /      \                   /      \
  Match 'a' Skip 'a'        Skip 'a'   ...
     /         \               /
count(2,2)  count(2,1)   count(2,0)
   = 1         ...           ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int numDistinct(String s, String t) {
    return count(s, t, 0, 0);
}

private int count(String s, String t, int i, int j) {
    if (j == t.length()) return 1;  // Found a match
    if (i == s.length()) return 0;  // No match possible
    
    int result = count(s, t, i + 1, j);  // Skip s[i]
    
    if (s.charAt(i) == t.charAt(j))
        result += count(s, t, i + 1, j + 1);  // Match s[i] with t[j]
    
    return result;
}
```
**Time:** O(2^m) | **Space:** O(m)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    return count(s, t, 0, 0, dp);
}

private int count(String s, String t, int i, int j, int[][] dp) {
    if (j == t.length()) return 1;
    if (i == s.length()) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    
    int result = count(s, t, i + 1, j, dp);
    
    if (s.charAt(i) == t.charAt(j))
        result += count(s, t, i + 1, j + 1, dp);
    
    return dp[i][j] = result;
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    long[][] dp = new long[m + 1][n + 1];
    
    // Base case: empty t matches with any s
    for (int i = 0; i <= m; i++)
        dp[i][0] = 1;
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            dp[i][j] = dp[i - 1][j];  // Skip s[i-1]
            
            if (s.charAt(i - 1) == t.charAt(j - 1))
                dp[i][j] += dp[i - 1][j - 1];  // Match
        }
    }
    
    return (int) dp[m][n];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    long[] prev = new long[n + 1];
    prev[0] = 1;
    
    for (int i = 1; i <= m; i++) {
        long[] curr = new long[n + 1];
        curr[0] = 1;
        
        for (int j = 1; j <= n; j++) {
            curr[j] = prev[j];
            
            if (s.charAt(i - 1) == t.charAt(j - 1))
                curr[j] += prev[j - 1];
        }
        prev = curr;
    }
    
    return (int) prev[n];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

### 5️⃣ Further Space Optimized (In-place)
```java
public int numDistinct(String s, String t) {
    int m = s.length(), n = t.length();
    long[] dp = new long[n + 1];
    dp[0] = 1;
    
    for (int i = 1; i <= m; i++) {
        for (int j = n; j >= 1; j--) {
            if (s.charAt(i - 1) == t.charAt(j - 1))
                dp[j] += dp[j - 1];
        }
    }
    
    return (int) dp[n];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

## Visualization (s="rabbbit", t="rabbit")

```
DP Table:
       ""  r  a  b  b  i  t
    "" 1   0  0  0  0  0  0
    r  1   1  0  0  0  0  0
    a  1   1  1  0  0  0  0
    b  1   1  1  1  0  0  0
    b  1   1  1  2  1  0  0
    b  1   1  1  3  3  0  0
    i  1   1  1  3  3  3  0
    t  1   1  1  3  3  3  3

Answer: 3 ways to form "rabbit" from "rabbbit"
```

## Key Patterns
- **Two Pointer Pattern** (i for s, j for t)
- **Choice Pattern** (match or skip)
- **Counting DP** (sum of ways)

## Related Problems
- Longest Common Subsequence
- Edit Distance
- Regular Expression Matching
