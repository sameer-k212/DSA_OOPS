# Shortest Common Supersequence

## Problem Statement
Find the shortest string that has both str1 and str2 as subsequences.

**Example:**
- Input: str1 = "abac", str2 = "cab"
- Output: "cabac" (length = 5)

## Intuition
**Formula:** Length of SCS = m + n - LCS(str1, str2)
- Include all characters from both strings
- Don't duplicate common subsequence characters

## Recursion Tree (str1="ab", str2="ac")

```
                    scs(0, 0)
                    /        \
            s1[0]==s2[0]?    NO
                /              \
        Take from s1      Take from s2
            /                    \
    'a' + scs(1,0)          'a' + scs(0,1)
         /    \                  /    \
    s1[1]==s2[0]? NO      s1[0]==s2[1]? NO
        /      \              /      \
   'b'+scs(2,0) 'a'+scs(1,1) ...    ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public String shortestCommonSupersequence(String s1, String s2) {
    return scs(s1, s2, 0, 0);
}

private String scs(String s1, String s2, int i, int j) {
    if (i == s1.length()) return s2.substring(j);
    if (j == s2.length()) return s1.substring(i);
    
    if (s1.charAt(i) == s2.charAt(j))
        return s1.charAt(i) + scs(s1, s2, i + 1, j + 1);
    
    String op1 = s1.charAt(i) + scs(s1, s2, i + 1, j);
    String op2 = s2.charAt(j) + scs(s1, s2, i, j + 1);
    
    return op1.length() < op2.length() ? op1 : op2;
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public String shortestCommonSupersequence(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    String[][] dp = new String[m + 1][n + 1];
    return scs(s1, s2, 0, 0, dp);
}

private String scs(String s1, String s2, int i, int j, String[][] dp) {
    if (i == s1.length()) return s2.substring(j);
    if (j == s2.length()) return s1.substring(i);
    if (dp[i][j] != null) return dp[i][j];
    
    if (s1.charAt(i) == s2.charAt(j))
        return dp[i][j] = s1.charAt(i) + scs(s1, s2, i + 1, j + 1, dp);
    
    String op1 = s1.charAt(i) + scs(s1, s2, i + 1, j, dp);
    String op2 = s2.charAt(j) + scs(s1, s2, i, j + 1, dp);
    
    return dp[i][j] = (op1.length() < op2.length() ? op1 : op2);
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP) - Optimal
```java
public String shortestCommonSupersequence(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    // Build LCS table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    
    // Build SCS from LCS table
    StringBuilder result = new StringBuilder();
    int i = m, j = n;
    
    while (i > 0 && j > 0) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            result.append(s1.charAt(i - 1));
            i--; j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            result.append(s1.charAt(i - 1));
            i--;
        } else {
            result.append(s2.charAt(j - 1));
            j--;
        }
    }
    
    while (i > 0) result.append(s1.charAt(--i));
    while (j > 0) result.append(s2.charAt(--j));
    
    return result.reverse().toString();
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized
```java
public String shortestCommonSupersequence(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = 1 + dp[i - 1][j - 1];
            else
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    
    StringBuilder sb = new StringBuilder();
    int i = m, j = n;
    
    while (i > 0 && j > 0) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            sb.append(s1.charAt(i - 1));
            i--; j--;
        } else if (dp[i - 1][j] > dp[i][j - 1]) {
            sb.append(s1.charAt(i - 1));
            i--;
        } else {
            sb.append(s2.charAt(j - 1));
            j--;
        }
    }
    
    while (i > 0) sb.append(s1.charAt(--i));
    while (j > 0) sb.append(s2.charAt(--j));
    
    return sb.reverse().toString();
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

## Visualization (s1="abac", s2="cab")

```
s1: a b a c
s2: c a b

LCS: "ab" (length = 2)

SCS Construction:
- Take 'c' from s2
- Take 'a' from both (LCS)
- Take 'b' from both (LCS)
- Take 'a' from s1
- Take 'c' from s1

Result: "cabac"
Length: 4 + 3 - 2 = 5
```

## Key Formula
```
Length of SCS = m + n - LCS
```

## Related Problems
- Longest Common Subsequence
- Edit Distance
- Interleaving String
