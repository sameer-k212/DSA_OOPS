# Minimum Path Sum in Grid

## Problem Statement
Given m x n grid with non-negative numbers, find path from top-left to bottom-right with minimum sum. Can only move right or down.

**Example:**
- Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
- Output: 7 (Path: 1→3→1→1→1 = 7)

## Intuition
To reach cell (i,j) with minimum cost:
- Come from top (i-1,j) or left (i,j-1)
- Add current cell cost

**Formula:** `dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])`

## Recursion Tree (grid=[[1,2],[3,4]])

```
                    minPath(1,1)
                    /          \
            4 + minPath(0,1)  4 + minPath(1,0)
                   /                  /
            2 + minPath(0,0)   3 + minPath(0,0)
                   |                  |
                   1                  1
                 = 7                = 8
                 
Min = 7
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    return minPath(grid, m - 1, n - 1);
}

private int minPath(int[][] grid, int i, int j) {
    if (i == 0 && j == 0) return grid[0][0];
    if (i < 0 || j < 0) return Integer.MAX_VALUE;
    
    int up = minPath(grid, i - 1, j);
    int left = minPath(grid, i, j - 1);
    
    return grid[i][j] + Math.min(up, left);
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return minPath(grid, m - 1, n - 1, dp);
}

private int minPath(int[][] grid, int i, int j, int[][] dp) {
    if (i == 0 && j == 0) return grid[0][0];
    if (i < 0 || j < 0) return Integer.MAX_VALUE;
    if (dp[i][j] != -1) return dp[i][j];
    
    int up = minPath(grid, i - 1, j, dp);
    int left = minPath(grid, i, j - 1, dp);
    
    return dp[i][j] = grid[i][j] + Math.min(up, left);
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[m][n];
    
    dp[0][0] = grid[0][0];
    
    // First column
    for (int i = 1; i < m; i++)
        dp[i][0] = dp[i-1][0] + grid[i][0];
    
    // First row
    for (int j = 1; j < n; j++)
        dp[0][j] = dp[0][j-1] + grid[0][j];
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        }
    }
    
    return dp[m-1][n-1];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[] prev = new int[n];
    
    for (int i = 0; i < m; i++) {
        int[] curr = new int[n];
        for (int j = 0; j < n; j++) {
            if (i == 0 && j == 0) {
                curr[j] = grid[i][j];
            } else {
                int up = (i > 0) ? prev[j] : Integer.MAX_VALUE;
                int left = (j > 0) ? curr[j-1] : Integer.MAX_VALUE;
                curr[j] = grid[i][j] + Math.min(up, left);
            }
        }
        prev = curr;
    }
    
    return prev[n-1];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

### 5️⃣ In-Place (Modify Input)
```java
public int minPathSum(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    
    for (int i = 1; i < m; i++)
        grid[i][0] += grid[i-1][0];
    
    for (int j = 1; j < n; j++)
        grid[0][j] += grid[0][j-1];
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
        }
    }
    
    return grid[m-1][n-1];
}
```
**Time:** O(m×n) | **Space:** O(1)

---

## Visualization (grid=[[1,3,1],[1,5,1],[4,2,1]])

```
Grid:              DP Table:
  1  3  1            1  4  5
  1  5  1    →       2  7  6
  4  2  1            6  8  7

Min path: 1→3→1→1→1 = 7
```

## Key Pattern
```
Grid DP with Cost:
- Add current cell cost
- Take minimum from top and left
- Build from top-left to bottom-right
```

## Related Problems
- Unique Paths
- Dungeon Game
- Cherry Pickup

![img.png](img.png)