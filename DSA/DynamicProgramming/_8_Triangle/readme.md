# Triangle - Minimum Path Sum

## Problem Statement
Given a triangle array, find minimum path sum from top to bottom. Each step, move to adjacent number on row below.

**Example:**
- Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
- Output: 11 (Path: 2→3→5→1 = 11)

## Intuition
From position (i,j), you can move to:
- (i+1, j) - directly below
- (i+1, j+1) - diagonally below

**Formula:** `dp[i][j] = triangle[i][j] + min(dp[i+1][j], dp[i+1][j+1])`

## Recursion Tree (triangle=[[2],[3,4],[6,5,7]])

```
                    minPath(0,0)
                    /          \
            2 + minPath(1,0)  2 + minPath(1,1)
                /      \          /      \
        3+minPath(2,0) 3+minPath(2,1) 4+minPath(2,1) 4+minPath(2,2)
              |              |              |              |
              6              5              5              7
            = 11           = 10           = 11           = 13
            
Min = 11
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minimumTotal(List<List<Integer>> triangle) {
    return minPath(triangle, 0, 0);
}

private int minPath(List<List<Integer>> tri, int i, int j) {
    if (i == tri.size() - 1) return tri.get(i).get(j);
    
    int down = minPath(tri, i + 1, j);
    int diagonal = minPath(tri, i + 1, j + 1);
    
    return tri.get(i).get(j) + Math.min(down, diagonal);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    for (int[] row : dp) Arrays.fill(row, -1);
    return minPath(triangle, 0, 0, dp);
}

private int minPath(List<List<Integer>> tri, int i, int j, int[][] dp) {
    if (i == tri.size() - 1) return tri.get(i).get(j);
    if (dp[i][j] != -1) return dp[i][j];
    
    int down = minPath(tri, i + 1, j, dp);
    int diagonal = minPath(tri, i + 1, j + 1, dp);
    
    return dp[i][j] = tri.get(i).get(j) + Math.min(down, diagonal);
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[][] dp = new int[n][n];
    
    // Base case: last row
    for (int j = 0; j < n; j++)
        dp[n-1][j] = triangle.get(n-1).get(j);
    
    // Fill from bottom to top
    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            int down = dp[i+1][j];
            int diagonal = dp[i+1][j+1];
            dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        }
    }
    
    return dp[0][0];
}
```
**Time:** O(n²) | **Space:** O(n²)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] prev = new int[n];
    
    // Base case: last row
    for (int j = 0; j < n; j++)
        prev[j] = triangle.get(n-1).get(j);
    
    for (int i = n - 2; i >= 0; i--) {
        int[] curr = new int[n];
        for (int j = 0; j <= i; j++) {
            int down = prev[j];
            int diagonal = prev[j+1];
            curr[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
        }
        prev = curr;
    }
    
    return prev[0];
}
```
**Time:** O(n²) | **Space:** O(n)

---

### 5️⃣ In-Place (Modify Input)
```java
public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    
    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j <= i; j++) {
            int down = triangle.get(i+1).get(j);
            int diagonal = triangle.get(i+1).get(j+1);
            int min = triangle.get(i).get(j) + Math.min(down, diagonal);
            triangle.get(i).set(j, min);
        }
    }
    
    return triangle.get(0).get(0);
}
```
**Time:** O(n²) | **Space:** O(1)

---

## Visualization (triangle=[[2],[3,4],[6,5,7],[4,1,8,3]])

```
Triangle:          DP Table (bottom-up):
     2                  11
    3 4                9  10
   6 5 7              7  6  10
  4 1 8 3            4  1  8  3

Min path: 2→3→5→1 = 11
```

## Key Differences
```
1. Not a regular grid - triangle shape
2. Two choices: down or diagonal
3. Better to solve bottom-up (from last row)
4. Each row has i+1 elements
```

## Related Problems
- Minimum Path Sum
- Minimum Falling Path Sum
- Pascal's Triangle

![img.png](img.png)