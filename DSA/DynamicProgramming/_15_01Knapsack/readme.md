# 0/1 Knapsack Problem

## Problem Statement
Given N items with weights and values, and a knapsack with capacity W, find the maximum value that can be obtained by selecting items such that the total weight doesn't exceed W. Each item can be taken at most once.

**Example:**
- Input: weights = [1, 2, 3], values = [10, 15, 40], W = 6
- Output: 65 (Take items 2 and 3)

## Intuition
For each item, we have 2 choices:
1. **Include** the item (if weight allows) and add its value
2. **Exclude** the item and move to next

Choose the option that gives maximum value.

## Recursion Tree (wt=[1,2,3], val=[10,15,40], W=6)

```
                    knapsack(2, 6)
                    /              \
            Include item 2      Exclude item 2
            (wt=3, val=40)      
                /                      \
        40 + knapsack(1, 3)        knapsack(1, 6)
            /          \              /          \
    Include item 1  Exclude      Include      Exclude
    (wt=2, val=15)                item 1
        /               \            /            \
 15+knapsack(0,1)  knapsack(0,3) 15+knapsack(0,4) knapsack(0,6)
      /                  |             |              |
 10+knapsack(-1,-1)     10            10             10
      = 10

Max = 65 (40 + 15 + 10)
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int knapsack(int[] wt, int[] val, int W, int n) {
    if (n == 0 || W == 0) return 0;
    
    if (wt[n - 1] > W)
        return knapsack(wt, val, W, n - 1);
    
    int include = val[n - 1] + knapsack(wt, val, W - wt[n - 1], n - 1);
    int exclude = knapsack(wt, val, W, n - 1);
    
    return Math.max(include, exclude);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int knapsack(int[] wt, int[] val, int W, int n) {
    int[][] dp = new int[n + 1][W + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    return solve(wt, val, W, n, dp);
}

private int solve(int[] wt, int[] val, int W, int n, int[][] dp) {
    if (n == 0 || W == 0) return 0;
    if (dp[n][W] != -1) return dp[n][W];
    
    if (wt[n - 1] > W)
        return dp[n][W] = solve(wt, val, W, n - 1, dp);
    
    int include = val[n - 1] + solve(wt, val, W - wt[n - 1], n - 1, dp);
    int exclude = solve(wt, val, W, n - 1, dp);
    
    return dp[n][W] = Math.max(include, exclude);
}
```
**Time:** O(n×W) | **Space:** O(n×W)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int knapsack(int[] wt, int[] val, int W, int n) {
    int[][] dp = new int[n + 1][W + 1];
    
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= W; w++) {
            if (wt[i - 1] <= w) {
                int include = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                int exclude = dp[i - 1][w];
                dp[i][w] = Math.max(include, exclude);
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }
    
    return dp[n][W];
}
```
**Time:** O(n×W) | **Space:** O(n×W)

---

### 4️⃣ Space Optimized (1D Array)
```java
public int knapsack(int[] wt, int[] val, int W, int n) {
    int[] prev = new int[W + 1];
    
    for (int i = 1; i <= n; i++) {
        int[] curr = new int[W + 1];
        for (int w = 1; w <= W; w++) {
            if (wt[i - 1] <= w) {
                int include = val[i - 1] + prev[w - wt[i - 1]];
                int exclude = prev[w];
                curr[w] = Math.max(include, exclude);
            } else {
                curr[w] = prev[w];
            }
        }
        prev = curr;
    }
    
    return prev[W];
}
```
**Time:** O(n×W) | **Space:** O(W)

---

### 5️⃣ Further Space Optimized (Single Array)
```java
public int knapsack(int[] wt, int[] val, int W, int n) {
    int[] dp = new int[W + 1];
    
    for (int i = 0; i < n; i++) {
        for (int w = W; w >= wt[i]; w--) {
            dp[w] = Math.max(dp[w], val[i] + dp[w - wt[i]]);
        }
    }
    
    return dp[W];
}
```
**Time:** O(n×W) | **Space:** O(W)
**Note:** Traverse weight from right to left to avoid using updated values.

---

## Visualization (wt=[1,2,3], val=[10,15,40], W=6)

```
DP Table:
       0   1   2   3   4   5   6
    ┌───┬───┬───┬───┬───┬───┬───┐
  0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │ 0 │
    ├───┼───┼───┼───┼───┼───┼───┤
  1 │ 0 │10 │10 │10 │10 │10 │10 │ (item 1: wt=1, val=10)
    ├───┼───┼───┼───┼───┼───┼───┤
  2 │ 0 │10 │15 │25 │25 │25 │25 │ (item 2: wt=2, val=15)
    ├───┼───┼───┼───┼───┼───┼───┤
  3 │ 0 │10 │15 │40 │50 │55 │65 │ (item 3: wt=3, val=40)
    └───┴───┴───┴───┴───┴───┴───┘

Answer: 65 (Take all items)
```

## Key Patterns
- **Choice Pattern:** Include or Exclude
- **Constraint:** Weight limit
- **Optimization:** Maximize value

## Related Problems
- Subset Sum
- Partition Equal Subset Sum
- Target Sum
- Coin Change
- Rod Cutting

![img.png](img.png)