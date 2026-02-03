# Maximum Sum of Non-Adjacent Elements (House Robber)

## Problem Statement
Given an array of integers, find the maximum sum of non-adjacent elements. You cannot pick two adjacent elements.

**Example:**
- Input: arr = [2, 1, 4, 9]
- Output: 11 (Pick 2 and 9)

## Intuition
At each house, you have 2 choices:
1. **Rob current house** → Can't rob previous, add current + dp[i-2]
2. **Skip current house** → Take maximum till previous house dp[i-1]

**Formula:** `dp[i] = max(arr[i] + dp[i-2], dp[i-1])`

## Recursion Tree (arr=[2,1,4,9])

```
                    rob(3)
                    /        \
            9 + rob(1)      rob(2)
                /    \         /    \
        1+rob(-1) rob(0)  4+rob(0) rob(1)
            |        |       |         |
            1        2       6        1
         = 10                      = 6

Max = 11 (2 + 9)
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int maxSum(int[] arr) {
    return rob(arr, arr.length - 1);
}

private int rob(int[] arr, int i) {
    if (i < 0) return 0;
    if (i == 0) return arr[0];
    
    int pick = arr[i] + rob(arr, i - 2);
    int notPick = rob(arr, i - 1);
    
    return Math.max(pick, notPick);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int maxSum(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return rob(arr, n - 1, dp);
}

private int rob(int[] arr, int i, int[] dp) {
    if (i < 0) return 0;
    if (i == 0) return arr[0];
    if (dp[i] != -1) return dp[i];
    
    int pick = arr[i] + rob(arr, i - 2, dp);
    int notPick = rob(arr, i - 1, dp);
    
    return dp[i] = Math.max(pick, notPick);
}
```
**Time:** O(n) | **Space:** O(n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int maxSum(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    
    int[] dp = new int[n];
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);
    
    for (int i = 2; i < n; i++) {
        int pick = arr[i] + dp[i - 2];
        int notPick = dp[i - 1];
        dp[i] = Math.max(pick, notPick);
    }
    
    return dp[n - 1];
}
```
**Time:** O(n) | **Space:** O(n)

---

### 4️⃣ Space Optimized
```java
public int maxSum(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    
    int prev2 = arr[0];
    int prev1 = Math.max(arr[0], arr[1]);
    
    for (int i = 2; i < n; i++) {
        int curr = Math.max(arr[i] + prev2, prev1);
        prev2 = prev1;
        prev1 = curr;
    }
    
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

## Visualization (arr=[2,1,4,9])

```
Index:  0   1   2   3
Array: [2,  1,  4,  9]

dp[0] = 2
dp[1] = max(2, 1) = 2
dp[2] = max(4+2, 2) = 6
dp[3] = max(9+2, 6) = 11 ✅

Picked: arr[0]=2, arr[3]=9
```

## Related Problems
- House Robber II (Circular)
- Delete and Earn
- Maximum Sum with No Three Consecutive

![img.png](img.png)