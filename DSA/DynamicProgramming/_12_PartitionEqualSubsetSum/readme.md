# Partition Equal Subset Sum

## Problem Statement
Given an array, determine if it can be partitioned into two subsets with equal sum.

**Example:**
- Input: arr = [1, 5, 11, 5]
- Output: true (Partition: [1,5,5] and [11])

## Intuition
**Key Insight:** If total sum is odd, can't partition equally.
If sum is even, find if subset with sum = totalSum/2 exists.

**This reduces to Subset Sum problem!**

## Recursion Tree (arr=[1,5,5], target=11/2=5)

```
                    canPartition(2, 5)
                    /              \
            Take arr[2]=5      Don't take
                /                    \
        canPartition(1,0)      canPartition(1,5)
              TRUE                  /        \
                              Take arr[1]=5  Don't
                                   /            \
                          canPartition(0,0) canPartition(0,5)
                              TRUE            FALSE
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public boolean canPartition(int[] arr) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if (sum % 2 != 0) return false;
    
    return subsetSum(arr, arr.length - 1, sum / 2);
}

private boolean subsetSum(int[] arr, int i, int target) {
    if (target == 0) return true;
    if (i < 0) return false;
    
    if (arr[i] <= target)
        return subsetSum(arr, i - 1, target - arr[i]) || 
               subsetSum(arr, i - 1, target);
    
    return subsetSum(arr, i - 1, target);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public boolean canPartition(int[] arr) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if (sum % 2 != 0) return false;
    
    int target = sum / 2;
    Boolean[][] dp = new Boolean[arr.length][target + 1];
    return subsetSum(arr, arr.length - 1, target, dp);
}

private boolean subsetSum(int[] arr, int i, int target, Boolean[][] dp) {
    if (target == 0) return true;
    if (i < 0) return false;
    if (dp[i][target] != null) return dp[i][target];
    
    boolean notTake = subsetSum(arr, i - 1, target, dp);
    boolean take = false;
    if (arr[i] <= target)
        take = subsetSum(arr, i - 1, target - arr[i], dp);
    
    return dp[i][target] = take || notTake;
}
```
**Time:** O(n×sum) | **Space:** O(n×sum)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public boolean canPartition(int[] arr) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if (sum % 2 != 0) return false;
    
    int target = sum / 2;
    int n = arr.length;
    boolean[][] dp = new boolean[n][target + 1];
    
    // Base case: target = 0
    for (int i = 0; i < n; i++)
        dp[i][0] = true;
    
    // Base case: first element
    if (arr[0] <= target)
        dp[0][arr[0]] = true;
    
    for (int i = 1; i < n; i++) {
        for (int t = 1; t <= target; t++) {
            boolean notTake = dp[i-1][t];
            boolean take = false;
            if (arr[i] <= t)
                take = dp[i-1][t - arr[i]];
            
            dp[i][t] = take || notTake;
        }
    }
    
    return dp[n-1][target];
}
```
**Time:** O(n×sum) | **Space:** O(n×sum)

---

### 4️⃣ Space Optimized (1D Array)
```java
public boolean canPartition(int[] arr) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if (sum % 2 != 0) return false;
    
    int target = sum / 2;
    boolean[] prev = new boolean[target + 1];
    prev[0] = true;
    
    if (arr[0] <= target)
        prev[arr[0]] = true;
    
    for (int i = 1; i < arr.length; i++) {
        boolean[] curr = new boolean[target + 1];
        curr[0] = true;
        
        for (int t = 1; t <= target; t++) {
            boolean notTake = prev[t];
            boolean take = false;
            if (arr[i] <= t)
                take = prev[t - arr[i]];
            
            curr[t] = take || notTake;
        }
        prev = curr;
    }
    
    return prev[target];
}
```
**Time:** O(n×sum) | **Space:** O(sum)

---

## Visualization (arr=[1,5,11,5], sum=22, target=11)

```
DP Table:
       0   1   2   3   4   5   6   7   8   9  10  11
    ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
  1 │ T │ T │ F │ F │ F │ F │ F │ F │ F │ F │ F │ F │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  5 │ T │ T │ F │ F │ F │ T │ T │ F │ F │ F │ F │ F │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
 11 │ T │ T │ F │ F │ F │ T │ T │ F │ F │ F │ F │ T │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  5 │ T │ T │ F │ F │ F │ T │ T │ F │ F │ F │ T │ T │
    └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘

Answer: TRUE (can make sum 11)
```

## Key Formula
```
Partition Equal Subset = Subset Sum with target = totalSum/2
```

## Related Problems
- Subset Sum Equal K
- Partition with Minimum Difference
- Target Sum

![img.png](img.png)