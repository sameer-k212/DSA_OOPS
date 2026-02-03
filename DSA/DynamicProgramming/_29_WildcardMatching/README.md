# Wildcard Matching

## Problem Statement
Implement wildcard pattern matching with support for '?' and '*'.
- '?' matches any single character
- '*' matches any sequence of characters (including empty)

**Example:**
- Input: s = "adceb", p = "*a*b"
- Output: true

## Intuition
- '?' → must match exactly one character
- '*' → can match 0 or more characters (greedy choice)
- Regular character → must match exactly

## Recursion Tree (s="ab", p="*")

```
                    match(0, 0)
                    /          \
            p[0]=='*'? YES      
                /                \
        Match 0 chars        Match 1+ chars
            /                      \
    match(0, 1)                match(1, 0)
        |                          /      \
    s="" p=""                 p[0]=='*'? YES
      TRUE                       /          \
                          match(1,1)    match(2,0)
                             |              |
                          s="" p=""      s="" p="*"
                            TRUE           TRUE
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public boolean isMatch(String s, String p) {
    return match(s, p, 0, 0);
}

private boolean match(String s, String p, int i, int j) {
    if (j == p.length()) return i == s.length();
    if (i == s.length()) {
        for (int k = j; k < p.length(); k++)
            if (p.charAt(k) != '*') return false;
        return true;
    }
    
    if (p.charAt(j) == '*') {
        return match(s, p, i + 1, j) ||  // Match 1+ chars
               match(s, p, i, j + 1);     // Match 0 chars
    }
    
    if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
        return match(s, p, i + 1, j + 1);
    
    return false;
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    Boolean[][] dp = new Boolean[m + 1][n + 1];
    return match(s, p, 0, 0, dp);
}

private boolean match(String s, String p, int i, int j, Boolean[][] dp) {
    if (j == p.length()) return i == s.length();
    if (i == s.length()) {
        for (int k = j; k < p.length(); k++)
            if (p.charAt(k) != '*') return false;
        return true;
    }
    if (dp[i][j] != null) return dp[i][j];
    
    if (p.charAt(j) == '*') {
        return dp[i][j] = match(s, p, i + 1, j, dp) || 
                          match(s, p, i, j + 1, dp);
    }
    
    if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))
        return dp[i][j] = match(s, p, i + 1, j + 1, dp);
    
    return dp[i][j] = false;
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    
    dp[0][0] = true;
    
    // Handle patterns like *, **, *** at the beginning
    for (int j = 1; j <= n; j++)
        if (p.charAt(j - 1) == '*')
            dp[0][j] = dp[0][j - 1];
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            } else if (p.charAt(j - 1) == '?' || 
                       s.charAt(i - 1) == p.charAt(j - 1)) {
                dp[i][j] = dp[i - 1][j - 1];
            }
        }
    }
    
    return dp[m][n];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public boolean isMatch(String s, String p) {
    int m = s.length(), n = p.length();
    boolean[] prev = new boolean[n + 1];
    prev[0] = true;
    
    for (int j = 1; j <= n; j++)
        if (p.charAt(j - 1) == '*')
            prev[j] = prev[j - 1];
    
    for (int i = 1; i <= m; i++) {
        boolean[] curr = new boolean[n + 1];
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                curr[j] = prev[j] || curr[j - 1];
            } else if (p.charAt(j - 1) == '?' || 
                       s.charAt(i - 1) == p.charAt(j - 1)) {
                curr[j] = prev[j - 1];
            }
        }
        prev = curr;
    }
    
    return prev[n];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

### 5️⃣ Two Pointer (Greedy) - Most Optimal
```java
public boolean isMatch(String s, String p) {
    int i = 0, j = 0;
    int starIdx = -1, match = 0;
    
    while (i < s.length()) {
        if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
            i++; j++;
        } else if (j < p.length() && p.charAt(j) == '*') {
            starIdx = j;
            match = i;
            j++;
        } else if (starIdx != -1) {
            j = starIdx + 1;
            match++;
            i = match;
        } else {
            return false;
        }
    }
    
    while (j < p.length() && p.charAt(j) == '*') j++;
    
    return j == p.length();
}
```
**Time:** O(m×n) worst case, O(m+n) average | **Space:** O(1)

---

## Visualization (s="adceb", p="*a*b")

```
DP Table:
       ""  *  a  *  b
    "" T   T  F  F  F
    a  F   T  T  T  F
    d  F   T  F  T  F
    c  F   T  F  T  F
    e  F   T  F  T  F
    b  F   T  F  T  T

Match: TRUE
```

## Key Patterns
```
1. '*' matches 0 chars:  dp[i][j-1]
2. '*' matches 1+ chars: dp[i-1][j]
3. '?' or exact match:   dp[i-1][j-1]
```

## Related Problems
- Regular Expression Matching
- String Matching
- Pattern Matching
