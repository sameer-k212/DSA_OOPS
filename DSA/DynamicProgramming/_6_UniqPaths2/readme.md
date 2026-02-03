# Unique Paths II (With Obstacles)

## Problem Statement
A robot on m x n grid with obstacles. Robot can only move right or down. Cell with 1 is obstacle. Find number of unique paths from top-left to bottom-right.

**Example:**
- Input: grid = [[0,0,0],[0,1,0],[0,0,0]]
- Output: 2

## Intuition
Same as Unique Paths but:
- If cell has obstacle (grid[i][j] == 1), paths = 0
- Otherwise, paths = dp[i-1][j] + dp[i][j-1]

## Recursion Tree (grid=[[0,0],[0,0]])

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
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
    return paths(grid, m - 1, n - 1);
}

private int paths(int[][] grid, int i, int j) {
    if (i < 0 || j < 0) return 0;
    if (grid[i][j] == 1) return 0;
    if (i == 0 && j == 0) return 1;
    
    int up = paths(grid, i - 1, j);
    int left = paths(grid, i, j - 1);
    
    return up + left;
}
```
**Time:** O(2^(m+n)) | **Space:** O(m+n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
    
    int[][] dp = new int[m][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return paths(grid, m - 1, n - 1, dp);
}

private int paths(int[][] grid, int i, int j, int[][] dp) {
    if (i < 0 || j < 0) return 0;
    if (grid[i][j] == 1) return 0;
    if (i == 0 && j == 0) return 1;
    if (dp[i][j] != -1) return dp[i][j];
    
    int up = paths(grid, i - 1, j, dp);
    int left = paths(grid, i, j - 1, dp);
    
    return dp[i][j] = up + left;
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
    
    int[][] dp = new int[m][n];
    dp[0][0] = 1;
    
    // First column
    for (int i = 1; i < m; i++)
        dp[i][0] = (grid[i][0] == 1) ? 0 : dp[i-1][0];
    
    // First row
    for (int j = 1; j < n; j++)
        dp[0][j] = (grid[0][j] == 1) ? 0 : dp[0][j-1];
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (grid[i][j] == 1)
                dp[i][j] = 0;
            else
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
    }
    
    return dp[m-1][n-1];
}
```
**Time:** O(m×n) | **Space:** O(m×n)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int uniquePathsWithObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;
    
    int[] prev = new int[n];
    prev[0] = 1;
    
    for (int i = 0; i < m; i++) {
        int[] curr = new int[n];
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                curr[j] = 0;
            } else if (i == 0 && j == 0) {
                curr[j] = 1;
            } else {
                int up = (i > 0) ? prev[j] : 0;
                int left = (j > 0) ? curr[j-1] : 0;
                curr[j] = up + left;
            }
        }
        prev = curr;
    }
    
    return prev[n-1];
}
```
**Time:** O(m×n) | **Space:** O(n)

---

## Visualization (grid=[[0,0,0],[0,1,0],[0,0,0]])

```
Grid:              DP Table:
  0  0  0            1  1  1
  0  1  0    →       1  0  1
  0  0  0            1  1  2

Obstacle at (1,1) blocks paths
Total paths = 2
```

## Key Differences from Unique Paths
```
1. Check for obstacles: if grid[i][j] == 1, dp[i][j] = 0
2. Handle first row/column carefully with obstacles
3. Check start and end cells for obstacles
```

## Related Problems
- Unique Paths I
- Minimum Path Sum
- Dungeon Game

![img.png](img.png)
![img_1.png](img_1.png)