# Cherry Pickup II (Two Robots)

## Problem Statement
Two robots start at (0,0) and (0,n-1) in a grid. Both move down simultaneously. At each step, they can move down-left, down, or down-right. Collect maximum cherries. If both robots are at same cell, count cherries only once.

**Example:**
- Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
- Output: 24

## Intuition
3D DP problem:
- State: (i, j1, j2) where i = row, j1 = robot1 col, j2 = robot2 col
- Both robots move together row by row
- Each robot has 3 choices: left-down, down, right-down
- Total 3×3 = 9 combinations per state

## Recursion Tree (Simplified)

```
                    cherry(0, 0, 2)
                    /       |       \
            cherry(1,0,1) cherry(1,0,2) cherry(1,1,2)
                /   |   \      ...          ...
        cherry(2,0,0) ...  ...
              |
             ...
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int cherryPickup(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    return maxCherry(grid, 0, 0, n - 1);
}

private int maxCherry(int[][] grid, int i, int j1, int j2) {
    int m = grid.length, n = grid[0].length;
    
    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
        return Integer.MIN_VALUE;
    
    if (i == m - 1) {
        if (j1 == j2) return grid[i][j1];
        return grid[i][j1] + grid[i][j2];
    }
    
    int max = Integer.MIN_VALUE;
    for (int dj1 = -1; dj1 <= 1; dj1++) {
        for (int dj2 = -1; dj2 <= 1; dj2++) {
            int value = maxCherry(grid, i + 1, j1 + dj1, j2 + dj2);
            max = Math.max(max, value);
        }
    }
    
    if (j1 == j2)
        return grid[i][j1] + max;
    return grid[i][j1] + grid[i][j2] + max;
}
```
**Time:** O(9^m) | **Space:** O(m)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int cherryPickup(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][][] dp = new int[m][n][n];
    for (int[][] row : dp)
        for (int[] col : row)
            Arrays.fill(col, -1);
    return maxCherry(grid, 0, 0, n - 1, dp);
}

private int maxCherry(int[][] grid, int i, int j1, int j2, int[][][] dp) {
    int m = grid.length, n = grid[0].length;
    
    if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n)
        return Integer.MIN_VALUE;
    
    if (i == m - 1) {
        if (j1 == j2) return grid[i][j1];
        return grid[i][j1] + grid[i][j2];
    }
    
    if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
    
    int max = Integer.MIN_VALUE;
    for (int dj1 = -1; dj1 <= 1; dj1++) {
        for (int dj2 = -1; dj2 <= 1; dj2++) {
            int value = maxCherry(grid, i + 1, j1 + dj1, j2 + dj2, dp);
            max = Math.max(max, value);
        }
    }
    
    if (j1 == j2)
        return dp[i][j1][j2] = grid[i][j1] + max;
    return dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
}
```
**Time:** O(m×n²×9) = O(m×n²) | **Space:** O(m×n²)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int cherryPickup(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][][] dp = new int[m][n][n];
    
    // Base case: last row
    for (int j1 = 0; j1 < n; j1++) {
        for (int j2 = 0; j2 < n; j2++) {
            if (j1 == j2)
                dp[m-1][j1][j2] = grid[m-1][j1];
            else
                dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
        }
    }
    
    // Fill from bottom to top
    for (int i = m - 2; i >= 0; i--) {
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                int max = Integer.MIN_VALUE;
                
                for (int dj1 = -1; dj1 <= 1; dj1++) {
                    for (int dj2 = -1; dj2 <= 1; dj2++) {
                        int nj1 = j1 + dj1;
                        int nj2 = j2 + dj2;
                        
                        if (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n)
                            max = Math.max(max, dp[i+1][nj1][nj2]);
                    }
                }
                
                if (j1 == j2)
                    dp[i][j1][j2] = grid[i][j1] + max;
                else
                    dp[i][j1][j2] = grid[i][j1] + grid[i][j2] + max;
            }
        }
    }
    
    return dp[0][0][n-1];
}
```
**Time:** O(m×n²×9) | **Space:** O(m×n²)

---

### 4️⃣ Space Optimized (2D Array)
```java
public int cherryPickup(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] prev = new int[n][n];
    
    // Base case
    for (int j1 = 0; j1 < n; j1++) {
        for (int j2 = 0; j2 < n; j2++) {
            if (j1 == j2)
                prev[j1][j2] = grid[m-1][j1];
            else
                prev[j1][j2] = grid[m-1][j1] + grid[m-1][j2];
        }
    }
    
    for (int i = m - 2; i >= 0; i--) {
        int[][] curr = new int[n][n];
        
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = 0; j2 < n; j2++) {
                int max = Integer.MIN_VALUE;
                
                for (int dj1 = -1; dj1 <= 1; dj1++) {
                    for (int dj2 = -1; dj2 <= 1; dj2++) {
                        int nj1 = j1 + dj1;
                        int nj2 = j2 + dj2;
                        
                        if (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n)
                            max = Math.max(max, prev[nj1][nj2]);
                    }
                }
                
                if (j1 == j2)
                    curr[j1][j2] = grid[i][j1] + max;
                else
                    curr[j1][j2] = grid[i][j1] + grid[i][j2] + max;
            }
        }
        prev = curr;
    }
    
    return prev[0][n-1];
}
```
**Time:** O(m×n²×9) | **Space:** O(n²)

---

## Key Insights
```
3D DP State:
- dp[i][j1][j2] = max cherries at row i with robots at j1 and j2
- Both robots move simultaneously
- 9 possible moves (3×3 combinations)
- If same cell, count cherries once
```

## Related Problems
- Cherry Pickup I
- Minimum Path Sum
- Unique Paths

![img.png](img.png)