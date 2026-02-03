# House Robber II (Circular Houses)

## Problem Statement
All houses are arranged in a circle. You cannot rob two adjacent houses. The first and last houses are adjacent. Find maximum amount you can rob.

**Example:**
- Input: arr = [2, 3, 2]
- Output: 3 (Rob house 2, can't rob both house 1 and 3)

## Intuition
Since houses are circular, first and last are adjacent. We have 2 cases:
1. **Rob houses [0...n-2]** (exclude last house)
2. **Rob houses [1...n-1]** (exclude first house)

Answer = max(case1, case2)

## Recursion Tree (arr=[2,3,2])

```
                    robCircular([2,3,2])
                    /                  \
            rob([2,3])              rob([3,2])
          (exclude last)          (exclude first)
               /    \                 /    \
          3+rob([]) rob([3])    2+rob([]) rob([3])
              = 3      = 3          = 2      = 3
           
Case1: max(3, 3) = 3
Case2: max(2, 3) = 3
Final: max(3, 3) = 3 ✅
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int rob(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    if (n == 2) return Math.max(arr[0], arr[1]);
    
    int case1 = robLinear(arr, 0, n - 2);
    int case2 = robLinear(arr, 1, n - 1);
    
    return Math.max(case1, case2);
}

private int robLinear(int[] arr, int start, int end) {
    if (start > end) return 0;
    if (start == end) return arr[start];
    
    int pick = arr[end] + robLinear(arr, start, end - 2);
    int notPick = robLinear(arr, start, end - 1);
    
    return Math.max(pick, notPick);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int rob(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    if (n == 2) return Math.max(arr[0], arr[1]);
    
    int[] dp1 = new int[n];
    int[] dp2 = new int[n];
    Arrays.fill(dp1, -1);
    Arrays.fill(dp2, -1);
    
    int case1 = robLinear(arr, 0, n - 2, dp1);
    int case2 = robLinear(arr, 1, n - 1, dp2);
    
    return Math.max(case1, case2);
}

private int robLinear(int[] arr, int start, int end, int[] dp) {
    if (start > end) return 0;
    if (start == end) return arr[start];
    if (dp[end] != -1) return dp[end];
    
    int pick = arr[end] + robLinear(arr, start, end - 2, dp);
    int notPick = robLinear(arr, start, end - 1, dp);
    
    return dp[end] = Math.max(pick, notPick);
}
```
**Time:** O(n) | **Space:** O(n)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int rob(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    if (n == 2) return Math.max(arr[0], arr[1]);
    
    int case1 = robLinear(arr, 0, n - 2);
    int case2 = robLinear(arr, 1, n - 1);
    
    return Math.max(case1, case2);
}

private int robLinear(int[] arr, int start, int end) {
    int prev2 = 0;
    int prev1 = arr[start];
    
    for (int i = start + 1; i <= end; i++) {
        int curr = Math.max(arr[i] + prev2, prev1);
        prev2 = prev1;
        prev1 = curr;
    }
    
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

### 4️⃣ Space Optimized (Cleaner)
```java
public int rob(int[] arr) {
    int n = arr.length;
    if (n == 1) return arr[0];
    if (n == 2) return Math.max(arr[0], arr[1]);
    
    return Math.max(robRange(arr, 0, n - 2), 
                    robRange(arr, 1, n - 1));
}

private int robRange(int[] arr, int start, int end) {
    int prev2 = 0, prev1 = 0;
    
    for (int i = start; i <= end; i++) {
        int curr = Math.max(arr[i] + prev2, prev1);
        prev2 = prev1;
        prev1 = curr;
    }
    
    return prev1;
}
```
**Time:** O(n) | **Space:** O(1)

---

## Visualization (arr=[2,3,2])

```
Case 1: Rob [2, 3] (exclude last)
  dp[0] = 2
  dp[1] = max(3+0, 2) = 3 ✅

Case 2: Rob [3, 2] (exclude first)
  dp[0] = 3
  dp[1] = max(2+0, 3) = 3 ✅

Final: max(3, 3) = 3
```

## Key Insight
```
Circular Array Problem:
- Can't include both first and last
- Split into 2 linear problems
- Take maximum of both
```

## Related Problems
- House Robber I (Linear)
- Delete and Earn
- Paint House

![img.png](img.png)