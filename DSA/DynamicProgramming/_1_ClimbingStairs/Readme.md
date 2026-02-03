# Climbing Stairs

## Problem Statement
You are climbing a staircase with n steps. You can climb 1 or 2 steps at a time. Find the number of distinct ways to reach the top.

**Example:**
- Input: n = 3
- Output: 3 (Ways: 1+1+1, 1+2, 2+1)

## Intuition
At each step, you have 2 choices:
1. Come from (n-1)th step by taking 1 step
2. Come from (n-2)th step by taking 2 steps

**Formula:** ways(n) = ways(n-1) + ways(n-2)

This is essentially the Fibonacci sequence!

## Recursion Tree (n=4)

```
                    climb(4)
                    /        \
            climb(3)          climb(2)
            /      \          /      \
      climb(2)  climb(1)  climb(1) climb(0)
       /    \       |         |        |
  climb(1) climb(0) 1         1        1
      |        |
      1        1

Total ways = 5
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    return climbStairs(n - 1) + climbStairs(n - 2);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int climbStairs(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, -1);
    return climb(n, dp);
}

private int climb(int n, int[] dp) {
    if (n <= 1) return 1;
    if (dp[n] != -1) return dp[n];
    return dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
}
```
**Time:** O(n) | **Space:** O(n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    
    for (int i = 2; i <= n; i++)
        dp[i] = dp[i - 1] + dp[i - 2];
    
    return dp[n];
}
```
**Time:** O(n) | **Space:** O(n)

---

### 4️⃣ Space Optimized (Constant Space)
```java
public int climbStairs(int n) {
    if (n <= 1) return 1;
    
    int prev2 = 1, prev1 = 1;
    
    for (int i = 2; i <= n; i++) {
        int curr = prev1 + prev2;
        prev2 = prev1;
        prev1 = curr;
    }
    
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

## Visualization

```
n = 5

Step 0: ways = 1
Step 1: ways = 1
Step 2: ways = 2  (1+1)
Step 3: ways = 3  (2+1)
Step 4: ways = 5  (3+2)
Step 5: ways = 8  (5+3)

Pattern: Fibonacci Sequence!
```

## Images
![img_1.png](img_1.png)
![img.png](img.png)

## Related Problems
- Fibonacci Number
- Min Cost Climbing Stairs
- House Robber
- Decode Ways
