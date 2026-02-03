# Count Partition Subset With Given Difference

## Problem Statement
Count number of ways to partition array into two subsets such that difference of their sums equals given difference D.

**Example:**
- Input: arr = [5,2,6,4], D = 3
- Output: 1 (Partition: [5,2] sum=7 and [6,4] sum=10, diff=3)

## Intuition
**Mathematical Derivation:**
- S1 - S2 = D ... (given)
- S1 + S2 = Sum ... (total sum)
- Adding both: 2×S1 = D + Sum
- Therefore: S1 = (D + Sum) / 2

**Problem reduces to:** Count subsets with sum = (D + Sum) / 2

## Recursion Tree (arr=[1,1,2], D=0, target=2)

```
                    count(2, 2)
                    /          \
            Take arr[2]=2  Don't take
                /                \
        count(1, 0)          count(1, 2)
           /    \               /    \
      Take 1  Don't        Take 1  Don't
        /        \            /        \
count(0,-1) count(0,0) count(0,1) count(0,2)
    0          1          0          0

Total ways = 2
```

## Approaches

### 1️⃣ Recursion (Top-Down)
```java
public int countPartitions(int[] arr, int d) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if ((sum + d) % 2 != 0 || sum < d) return 0;
    
    int target = (sum + d) / 2;
    return countSubsets(arr, arr.length - 1, target);
}

private int countSubsets(int[] arr, int i, int target) {
    if (i == 0) {
        if (target == 0 && arr[0] == 0) return 2;
        if (target == 0 || arr[0] == target) return 1;
        return 0;
    }
    
    int notTake = countSubsets(arr, i - 1, target);
    int take = 0;
    if (arr[i] <= target)
        take = countSubsets(arr, i - 1, target - arr[i]);
    
    return take + notTake;
}
```
**Time:** O(2^n) | **Space:** O(n)

---

### 2️⃣ Memoization (Top-Down DP)
```java
public int countPartitions(int[] arr, int d) {
    int sum = 0;
    for (int num : arr) sum += num;
    
    if ((sum + d) % 2 != 0 || sum < d) return 0;
    
    int target = (sum + d) / 2;
    int[][] dp = new int[arr.length][target + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    
    return countSubsets(arr, arr.length - 1, target, dp);
}

private int countSubsets(int[] arr, int i, int target, int[][] dp) {
    if (i == 0) {
        if (target == 0 && arr[0] == 0) return 2;
        if (target == 0 || arr[0] == target) return 1;
        return 0;
    }
    
    if (dp[i][target] != -1) return dp[i][target];
    
    int notTake = countSubsets(arr, i - 1, target, dp);
    int take = 0;
    if (arr[i] <= target)
        take = countSubsets(arr, i - 1, target - arr[i], dp);
    
    return dp[i][target] = take + notTake;
}
```
**Time:** O(n×target) | **Space:** O(n×target)

---

### 3️⃣ Tabulation (Bottom-Up DP)
```java
public int countPartitions(int[] arr, int d) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) sum += num;
    
    if ((sum + d) % 2 != 0 || sum < d) return 0;
    
    int target = (sum + d) / 2;
    int[][] dp = new int[n][target + 1];
    
    // Base case
    if (arr[0] == 0) dp[0][0] = 2;
    else dp[0][0] = 1;
    
    if (arr[0] != 0 && arr[0] <= target)
        dp[0][arr[0]] = 1;
    
    for (int i = 1; i < n; i++) {
        for (int t = 0; t <= target; t++) {
            int notTake = dp[i-1][t];
            int take = 0;
            if (arr[i] <= t)
                take = dp[i-1][t - arr[i]];
            
            dp[i][t] = take + notTake;
        }
    }
    
    return dp[n-1][target];
}
```
**Time:** O(n×target) | **Space:** O(n×target)

---

### 4️⃣ Space Optimized
```java
public int countPartitions(int[] arr, int d) {
    int n = arr.length;
    int sum = 0;
    for (int num : arr) sum += num;
    
    if ((sum + d) % 2 != 0 || sum < d) return 0;
    
    int target = (sum + d) / 2;
    int[] prev = new int[target + 1];
    
    if (arr[0] == 0) prev[0] = 2;
    else prev[0] = 1;
    
    if (arr[0] != 0 && arr[0] <= target)
        prev[arr[0]] = 1;
    
    for (int i = 1; i < n; i++) {
        int[] curr = new int[target + 1];
        for (int t = 0; t <= target; t++) {
            int notTake = prev[t];
            int take = 0;
            if (arr[i] <= t)
                take = prev[t - arr[i]];
            
            curr[t] = take + notTake;
        }
        prev = curr;
    }
    
    return prev[target];
}
```
**Time:** O(n×target) | **Space:** O(target)

---

## Visualization (arr=[5,2,6,4], D=3, Sum=17)

```
S1 = (D + Sum) / 2 = (3 + 17) / 2 = 10

Find count of subsets with sum = 10:

DP Table:
       0   1   2   3   4   5   6   7   8   9  10
    ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
  5 │ 1 │ 0 │ 0 │ 0 │ 0 │ 1 │ 0 │ 0 │ 0 │ 0 │ 0 │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  2 │ 1 │ 0 │ 1 │ 0 │ 0 │ 1 │ 0 │ 1 │ 0 │ 0 │ 0 │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  6 │ 1 │ 0 │ 1 │ 0 │ 0 │ 1 │ 1 │ 1 │ 1 │ 0 │ 0 │
    ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  4 │ 1 │ 0 │ 1 │ 0 │ 1 │ 1 │ 1 │ 1 │ 1 │ 0 │ 1 │
    └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘

Answer: 1 way to partition with difference 3
```

## Key Formula
```
S1 - S2 = D
S1 + S2 = Sum
⇒ S1 = (D + Sum) / 2

Count partitions = Count subsets with sum S1
```

## Edge Cases
```
1. If (D + Sum) is odd → return 0
2. If D > Sum → return 0
3. Handle zeros in array carefully
```

## Related Problems
- Count Subset Sum Equal K
- Target Sum
- Partition Equal Subset Sum

![img.png](img.png)