# Unique Paths

## Problem Statement
A robot is on an m x n grid at top-left corner. Robot can only move right or down. Find number of unique paths to reach bottom-right corner.

**Example:**
- Input: m = 3, n = 2
- Output: 3
- Paths: Right→Down→Down, Down→Right→Down, Down→Down→Right

## Intuition
To reach cell (i,j), robot must come from:
1. **Left cell** (i, j-1) by moving right
2. **Top cell** (i-1, j) by moving down

**Formula:** `dp[i][j] = dp[i-1][j] + dp[i][j-1]`

## Recursion Tree (m=2, n=2)

```
                    paths(1,1)
                    /          \
            paths(0,1)        paths(1,0)
               /    \            /    \
        paths(-1,1) paths(0,0) paths(0,0) paths(1,-1)
            0           1          1          0
            
Total paths = 2
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int uniquePaths(int m, int n) {
    return paths(m - 1, n - 1);
}

private int paths(int i, int j) {
    if (i == 0 && j == 0) return 1;
    if (i < 0 || j < 0) return 0;
    
    int up = paths(i - 1, j);
    int left = paths(i, j - 1);
    
    return up + left;
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return paths(m - 1, n - 1, dp);
}

private int paths(int i, int j, int[][] dp) {
    if (i == 0 && j == 0) return 1;
    if (i < 0 || j < 0) return 0;
    if (dp[i][j] != -1) return dp[i][j];
    
    int up = paths(i - 1, j, dp);
    int left = paths(i, j - 1, dp);
    
    return dp[i][j] = up + left;
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    
    // Base case: first row and column
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
    }
    
    return dp[m - 1][n - 1];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int uniquePaths(int m, int n) {
    int[] prev = new int[n];
    Arrays.fill(prev, 1);
    
    for (int i = 1; i < m; i++) {
        int[] curr = new int[n];
        curr[0] = 1;
        for (int j = 1; j < n; j++) {
            curr[j] = curr[j - 1] + prev[j];
        }
        prev = curr;
    }
    
    return prev[n - 1];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

### 5️⃣ Combinatorics (Math Formula)
```java
public int uniquePaths(int m, int n) {
    int N = m + n - 2;
    int r = m - 1;
    long result = 1;
    
    for (int i = 1; i <= r; i++) {
        result = result * (N - r + i) / i;
    }
    
    return (int) result;
}
```
**Time:** O(m) | **Space:** O(1)
**Formula:** C(m+n-2, m-1) = (m+n-2)! / ((m-1)! × (n-1)!)

---

## Visualization (m=3, n=3)

```
DP Table:
       0   1   2
    ┌───┬───┬───┐
  0 │ 1 │ 1 │ 1 │
    ├───┼───┼───┤
  1 │ 1 │ 2 │ 3 │
    ├───┼───┼───┤
  2 │ 1 │ 3 │ 6 │
    └───┴───┴───┘

Paths to (2,2) = 6
```

## Key Pattern
```
Grid DP Pattern:
- Start from (0,0)
- Can only move right or down
- Sum paths from top and left
```

## Related Problems
- Unique Paths II (with obstacles)
- Minimum Path Sum
- Dungeon Game

![img.png](img.png)
![img_1.png](img_1.png)