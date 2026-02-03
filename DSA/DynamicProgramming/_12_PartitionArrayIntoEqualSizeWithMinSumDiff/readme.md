# Partition Array Into Two Subsets With Minimum Sum Difference

## Problem Statement
Partition array into two subsets such that absolute difference of their sums is minimized.

**Example:**
- Input: arr = [1, 6, 11, 5]
- Output: 1 (Partition: [1,5,6] sum=12 and [11] sum=11, diff=1)

## Intuition
**Key Insight:**
- Total sum = S
- Subset1 sum = S1, Subset2 sum = S2
- S1 + S2 = S
- Minimize |S1 - S2| = |S1 - (S - S1)| = |2×S1 - S|

**Strategy:** Find all possible subset sums up to S/2, then find S1 closest to S/2.

## Recursion Tree (arr=[1,2,3], S=6)

```
                    partition(2, 0)
                    /              \
            Take arr[2]=3      Don't take
                /                    \
        partition(1,3)          partition(1,0)
           /        \              /        \
      Take 2    Don't         Take 2    Don't
        /           \            /           \
partition(0,5) partition(0,3) partition(0,2) partition(0,0)

Possible S1: {0,1,2,3,4,5,6}
Best S1 = 3, S2 = 3, diff = 0
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int minimumDifference(int[] arr) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    return minDiff(arr, arr.length - 1, 0, sum);
}

private int minDiff(int[] arr, int i, int s1, int totalSum) {
    if (i < 0) {
        int s2 = totalSum - s1;
        return Math.abs(s1 - s2);
    }
    
    int take = minDiff(arr, i - 1, s1 + arr[i], totalSum);
    int notTake = minDiff(arr, i - 1, s1, totalSum);
    
    return Math.min(take, notTake);
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Using Subset Sum DP (Optimal)
```java
public int minimumDifference(int[] arr) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) sum += num;
    
    // Find all possible subset sums
    boolean[][] dp = new boolean[n][sum + 1];
    
    // Base case
    for (int i = 0; i < n; i++)
        dp[i][0] = true;
    
    if (arr[0] <= sum)
        dp[0][arr[0]] = true;
    
    // Fill DP table
    for (int i = 1; i < n; i++) {
        for (int target = 1; target <= sum; target++) {
            boolean notTake = dp[i-1][target];
            boolean take = false;
            if (arr[i] <= target)
                take = dp[i-1][target - arr[i]];
            
            dp[i][target] = take || notTake;
        }
    }
    
    // Find minimum difference
    int minDiff = Integer.MAX_VALUE;
    for (int s1 = 0; s1 <= sum / 2; s1++) {
        if (dp[n-1][s1]) {
            int s2 = sum - s1;
            minDiff = Math.min(minDiff, Math.abs(s1 - s2));
        }
    }
    
    return minDiff;
}
```
**Time:** O(n×sum) | **Space:** O(n×sum)

---

### 3️⃣ Space Optimized
```java
public int minimumDifference(int[] arr) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) sum += num;
    
    boolean[] prev = new boolean[sum + 1];
    prev[0] = true;
    
    if (arr[0] <= sum)
        prev[arr[0]] = true;
    
    for (int i = 1; i < n; i++) {
        boolean[] curr = new boolean[sum + 1];
        curr[0] = true;
        
        for (int target = 1; target <= sum; target++) {
            boolean notTake = prev[target];
            boolean take = false;
            if (arr[i] <= target)
                take = prev[target - arr[i]];
            
            curr[target] = take || notTake;
        }
        prev = curr;
    }
    
    int minDiff = Integer.MAX_VALUE;
    for (int s1 = 0; s1 <= sum / 2; s1++) {
        if (prev[s1]) {
            int s2 = sum - s1;
            minDiff = Math.min(minDiff, s2 - s1);
        }
    }
    
    return minDiff;
}
```
**Time:** O(n×sum) | **Space:** O(sum)

---

## Visualization (arr=[1,6,11,5], sum=23)

```
Possible subset sums (S1): {0,1,5,6,7,11,12,16,17,18,22,23}

For each S1, calculate diff:
S1=0  → S2=23 → diff=23
S1=1  → S2=22 → diff=21
S1=5  → S2=18 → diff=13
S1=6  → S2=17 → diff=11
S1=11 → S2=12 → diff=1  ✅ (minimum)
S1=12 → S2=11 → diff=1  ✅

Answer: 1
```

## Key Steps
```
1. Find all possible subset sums using Subset Sum DP
2. For each possible S1, calculate S2 = totalSum - S1
3. Find minimum |S1 - S2|
4. Optimization: Only check S1 up to totalSum/2
```

## Related Problems
- Subset Sum Equal K
- Partition Equal Subset Sum
- Target Sum

![img.png](img.png)