# Edit Distance (Levenshtein Distance)

## Problem Statement
Find the minimum number of operations (insert, delete, replace) required to convert string s1 to string s2.

**Example:**
- Input: s1 = "horse", s2 = "ros"
- Output: 3 (horse → rorse → rose → ros)

## Intuition
At each position, we have 3 choices:
1. **Replace:** if characters don't match
2. **Insert:** add character from s2
3. **Delete:** remove character from s1

## Recursion Tree (s1="ab", s2="ac")

```
                    edit(0, 0)
                    /         \
            s1[0]==s2[0]? YES  
                /               
        edit(1, 1)              
            /    |    \         
    s1[1]==s2[1]? NO            
        /        |        \     
   Replace    Insert    Delete  
      |          |          |   
  1+edit(2,2) 1+edit(1,2) 1+edit(2,1)
     = 1         ...        ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minDistance(String s1, String s2) {
    return edit(s1, s2, 0, 0);
}

private int edit(String s1, String s2, int i, int j) {
    if (i == s1.length()) return s2.length() - j;  // Insert remaining
    if (j == s2.length()) return s1.length() - i;  // Delete remaining
    
    if (s1.charAt(i) == s2.charAt(j))
        return edit(s1, s2, i + 1, j + 1);
    
    int insert = 1 + edit(s1, s2, i, j + 1);
    int delete = 1 + edit(s1, s2, i + 1, j);
    int replace = 1 + edit(s1, s2, i + 1, j + 1);
    
    return Math.min(insert, Math.min(delete, replace));
}
```
**Time:** O(3^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minDistance(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    return edit(s1, s2, 0, 0, dp);
}

private int edit(String s1, String s2, int i, int j, int[][] dp) {
    if (i == s1.length()) return s2.length() - j;
    if (j == s2.length()) return s1.length() - i;
    if (dp[i][j] != -1) return dp[i][j];
    
    if (s1.charAt(i) == s2.charAt(j))
        return dp[i][j] = edit(s1, s2, i + 1, j + 1, dp);
    
    int insert = 1 + edit(s1, s2, i, j + 1, dp);
    int delete = 1 + edit(s1, s2, i + 1, j, dp);
    int replace = 1 + edit(s1, s2, i + 1, j + 1, dp);
    
    return dp[i][j] = Math.min(insert, Math.min(delete, replace));
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minDistance(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[][] dp = new int[m + 1][n + 1];
    
    // Base cases
    for (int i = 0; i <= m; i++) dp[i][0] = i;
    for (int j = 0; j <= n; j++) dp[0][j] = j;
    
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                dp[i][j] = dp[i - 1][j - 1];
            else {
                int insert = dp[i][j - 1];
                int delete = dp[i - 1][j];
                int replace = dp[i - 1][j - 1];
                dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
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
public int minDistance(String s1, String s2) {
    int m = s1.length(), n = s2.length();
    int[] prev = new int[n + 1];
    
    for (int j = 0; j <= n; j++) prev[j] = j;
    
    for (int i = 1; i <= m; i++) {
        int[] curr = new int[n + 1];
        curr[0] = i;
        
        for (int j = 1; j <= n; j++) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1))
                curr[j] = prev[j - 1];
            else
                curr[j] = 1 + Math.min(curr[j - 1], 
                                       Math.min(prev[j], prev[j - 1]));
        }
        prev = curr;
    }
    
    return prev[n];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

## Visualization (s1="horse", s2="ros")

```
DP Table:
       ""  r  o  s
    "" 0   1  2  3
    h  1   1  2  3
    o  2   2  1  2
    r  3   2  2  2
    s  4   3  3  2
    e  5   4  4  3

Operations:
1. horse → rorse (replace h with r)
2. rorse → rose  (delete r)
3. rose  → ros   (delete e)

Answer: 3
```

## Key Operations
```
1. Insert:  dp[i][j-1] + 1
2. Delete:  dp[i-1][j] + 1
3. Replace: dp[i-1][j-1] + 1
4. Match:   dp[i-1][j-1] (no cost)
```

## Related Problems
- Longest Common Subsequence
- Minimum ASCII Delete Sum
- One Edit Distance
- Delete Operation for Two Strings
