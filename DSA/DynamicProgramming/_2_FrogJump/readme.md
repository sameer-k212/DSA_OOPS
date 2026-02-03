# Frog Jump

## Problem Statement
A frog is at step 0 and wants to reach step n-1. The frog can jump 1 or 2 steps at a time. Each step has a height, and the cost of a jump is the absolute difference in heights. Find the minimum cost to reach the last step.

**Example:**
- Input: heights = [10, 20, 30, 10]
- Output: 20 (Jump: 0→1→3, cost = |10-20| + |20-10| = 10+10 = 20)

## Intuition
At each step, the frog has 2 choices:
1. Jump from (i-1)th step with cost |height[i] - height[i-1]|
2. Jump from (i-2)th step with cost |height[i] - height[i-2]|

Choose the minimum cost path.

## Recursion Tree (heights=[10,20,30,10])

```
                    minCost(3)
                    /          \
        10 + minCost(2)      10 + minCost(1)
            /      \              /      \
    10+minCost(1) 20+minCost(0) 10+minCost(0) 20+minCost(-1)
        /    \         |            |            X
 10+minCost(0) ...    0            0
       |
       0

Minimum = 20
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minCost(int[] heights) {
    return jump(heights, heights.length - 1);
}

private int jump(int[] h, int i) {
    if (i == 0) return 0;
    if (i == 1) return Math.abs(h[1] - h[0]);
    
    int one = jump(h, i - 1) + Math.abs(h[i] - h[i - 1]);
    int two = jump(h, i - 2) + Math.abs(h[i] - h[i - 2]);
    
    return Math.min(one, two);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int minCost(int[] heights) {
    int n = heights.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return jump(heights, n - 1, dp);
}

private int jump(int[] h, int i, int[] dp) {
    if (i == 0) return 0;
    if (i == 1) return Math.abs(h[1] - h[0]);
    if (dp[i] != -1) return dp[i];
    
    int one = jump(h, i - 1, dp) + Math.abs(h[i] - h[i - 1]);
    int two = jump(h, i - 2, dp) + Math.abs(h[i] - h[i - 2]);
    
    return dp[i] = Math.min(one, two);
}
```
**Time:** O(n) | **Space:** O(n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int minCost(int[] heights) {
    int n = heights.length;
    if (n == 1) return 0;
    
    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(heights[1] - heights[0]);
    
    for (int i = 2; i < n; i++) {
        int one = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
        int two = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
        dp[i] = Math.min(one, two);
    }
    
    return dp[n - 1];
}
```
**Time:** O(n) | **Space:** O(n)

---

### 4️⃣ Space Optimized
```java
public int minCost(int[] heights) {
    int n = heights.length;
    if (n == 1) return 0;
    
    int prev2 = 0;
    int prev1 = Math.abs(heights[1] - heights[0]);
    
    for (int i = 2; i < n; i++) {
        int one = prev1 + Math.abs(heights[i] - heights[i - 1]);
        int two = prev2 + Math.abs(heights[i] - heights[i - 2]);
        int curr = Math.min(one, two);
        prev2 = prev1;
        prev1 = curr;
    }
    
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

## Frog Jump with K Distance

### Problem
Frog can jump up to K steps at a time. Find minimum cost.

### Recursion Tree (K=3, heights=[10,20,30,10])

```
                    minCost(3)
                /       |        \
        10+minCost(2) 10+minCost(1) 0+minCost(0)
            /    \         |              |
          ...    ...      ...             0
```

### Solution
```java
public int minCostK(int[] heights, int k) {
    int n = heights.length;
    int[] dp = new int[n];
    dp[0] = 0;
    
    for (int i = 1; i < n; i++) {
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k && i - j >= 0; j++) {
            int cost = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
            min = Math.min(min, cost);
        }
        dp[i] = min;
    }
    
    return dp[n - 1];
}
```
**Time:** O(n×k) | **Space:** O(n)

---

## Images
FrogJump with either 1 or 2 step:
![img.png](img.png)

Frog Jump With K Distance:
![img_1.png](img_1.png)

## Related Problems
- Climbing Stairs
- Min Cost Climbing Stairs
- Jump Game
- House Robber