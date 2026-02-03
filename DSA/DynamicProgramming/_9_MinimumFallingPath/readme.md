# Minimum Falling Path Sum

## Problem Statement
Given n x n matrix, find minimum sum of falling path. Falling path starts at any element in first row and chooses element in next row that is directly below or diagonally left/right.

**Example:**
- Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
- Output: 13 (Path: 1→5→7 = 13)

## Intuition
From position (i,j), you can move to:
- (i+1, j-1) - diagonal left
- (i+1, j) - directly below  
- (i+1, j+1) - diagonal right

**Formula:** `dp[i][j] = matrix[i][j] + min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1])`

## Recursion Tree (matrix=[[1,2],[3,4]])

```
                    minFall(0,0)          minFall(0,1)
                    /          \          /          \
            1+minFall(1,0) 1+minFall(1,1) 2+minFall(1,0) 2+minFall(1,1)
                  |              |              |              |
                  3              4              3              4
                = 4            = 5            = 5            = 6
                
Min from row 0: min(4, 5) = 4
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int min = Integer.MAX_VALUE;
    
    for (int j = 0; j < n; j++)
        min = Math.min(min, minPath(matrix, 0, j));
    
    return min;
}

private int minPath(int[][] mat, int i, int j) {
    int n = mat.length;
    if (j < 0 || j >= n) return Integer.MAX_VALUE;
    if (i == n - 1) return mat[i][j];
    
    int down = minPath(mat, i + 1, j);
    int diagLeft = minPath(mat, i + 1, j - 1);
    int diagRight = minPath(mat, i + 1, j + 1);
    
    return mat[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
}
```
**Time:** O(3^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];
    for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
    
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++)
        min = Math.min(min, minPath(matrix, 0, j, dp));
    
    return min;
}

private int minPath(int[][] mat, int i, int j, int[][] dp) {
    int n = mat.length;
    if (j < 0 || j >= n) return Integer.MAX_VALUE;
    if (i == n - 1) return mat[i][j];
    if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
    
    int down = minPath(mat, i + 1, j, dp);
    int diagLeft = minPath(mat, i + 1, j - 1, dp);
    int diagRight = minPath(mat, i + 1, j + 1, dp);
    
    return dp[i][j] = mat[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[][] dp = new int[n][n];
    
    // Base case: last row
    for (int j = 0; j < n; j++)
        dp[n-1][j] = matrix[n-1][j];
    
    // Fill from bottom to top
    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j < n; j++) {
            int down = dp[i+1][j];
            int diagLeft = (j > 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;
            int diagRight = (j < n-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;
            
            dp[i][j] = matrix[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
        }
    }
    
    // Find minimum in first row
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++)
        min = Math.min(min, dp[0][j]);
    
    return min;
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int minFallingPathSum(int[][] matrix) {
    int n = matrix.length;
    int[] prev = new int[n];
    
    // Base case: last row
    for (int j = 0; j < n; j++)
        prev[j] = matrix[n-1][j];
    
    for (int i = n - 2; i >= 0; i--) {
        int[] curr = new int[n];
        for (int j = 0; j < n; j++) {
            int down = prev[j];
            int diagLeft = (j > 0) ? prev[j-1] : Integer.MAX_VALUE;
            int diagRight = (j < n-1) ? prev[j+1] : Integer.MAX_VALUE;
            
            curr[j] = matrix[i][j] + Math.min(down, Math.min(diagLeft, diagRight));
        }
        prev = curr;
    }
    
    int min = Integer.MAX_VALUE;
    for (int j = 0; j < n; j++)
        min = Math.min(min, prev[j]);
    
    return min;
}
```
**Time:** O(n²) | **Space:** O(n)

---

## Visualization (matrix=[[2,1,3],[6,5,4],[7,8,9]])

```
Matrix:            DP Table (bottom-up):
  2  1  3            13 12 15
  6  5  4            13 11 12
  7  8  9             7  8  9

Min path: 1→5→7 = 13
```

## Key Pattern
```
Falling Path:
- Start from any column in first row
- Three choices at each step
- Find minimum among all starting points
```

## Related Problems
- Triangle
- Minimum Path Sum
- Cherry Pickup

![img_1.png](img_1.png)
![img.png](img.png)