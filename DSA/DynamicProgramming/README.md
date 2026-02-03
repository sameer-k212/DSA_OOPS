# Dynamic Programming - Complete Guide

## 📚 Table of Contents
1. [Introduction](#introduction)
2. [DP Patterns](#dp-patterns)
3. [Problem Categories](#problem-categories)
4. [Learning Path](#learning-path)
5. [Quick Reference](#quick-reference)

---

## Introduction

Dynamic Programming (DP) is an optimization technique that solves complex problems by breaking them down into simpler subproblems and storing their solutions to avoid redundant calculations.

### Key Characteristics
- **Optimal Substructure:** Solution can be constructed from optimal solutions of subproblems
- **Overlapping Subproblems:** Same subproblems are solved multiple times

### DP Approaches
1. **Recursion:** Top-down, intuitive but exponential time
2. **Memoization:** Top-down DP, cache results
3. **Tabulation:** Bottom-up DP, iterative approach
4. **Space Optimization:** Reduce space complexity

---

## DP Patterns

### 1️⃣ Linear DP (1D)
Problems where state depends on previous states in a linear fashion.

**Pattern:** `dp[i] = f(dp[i-1], dp[i-2], ...)`

**Problems:**
- [Climbing Stairs](_1_ClimbingStairs/) - Basic Fibonacci pattern
- [Frog Jump](_2_FrogJump/) - Minimum cost with choices
- [Maximum Sum Non-Adjacent](_3_MaximumSumOfNonAdjacentElement/) - House Robber pattern
- [House Robber 2](_4_HouseRobber2/) - Circular array variant

---

### 2️⃣ Grid DP (2D)
Problems on 2D grids where you move from start to end.

**Pattern:** `dp[i][j] = f(dp[i-1][j], dp[i][j-1], ...)`

**Problems:**
- [Unique Paths](_5_UniquePaths/) - Count paths in grid
- [Unique Paths 2](_6_UniqPaths2/) - With obstacles
- [Min Path Sum](_7_MinPathSumInGrid/) - Minimum cost path
- [Triangle](_8_Triangle/) - Top to bottom path
- [Minimum Falling Path](_9_MinimumFallingPath/) - Matrix falling path
- [Cherry Pickup 2](_10_CherryPickup2/) - Two robots problem

---

### 3️⃣ Knapsack Pattern (0/1)
Problems where you choose to include/exclude items with constraints.

**Pattern:** `dp[i][w] = max(include, exclude)`

**Problems:**
- [Subset Sum Equal K](_11_SubsetSumEqualK/) - Basic subset sum
- [Partition Equal Subset Sum](_12_PartitionEqualSubsetSum/) - Split into equal parts
- [Partition with Min Difference](_12_PartitionArrayIntoEqualSizeWithMinSumDiff/) - Minimize difference
- [Count Subset Sum](_13_CountSubsetSumEqualK/) - Count ways
- [Count Partition with Difference](_14_CountPartitionSubsetWithGivenDifference/) - Count partitions
- [0/1 Knapsack](_15_01Knapsack/) - Classic knapsack
- [Target Sum](_17_WaysToTargetSum/) - Assign +/- to reach target

---

### 4️⃣ Unbounded Knapsack
Items can be used unlimited times.

**Pattern:** `dp[i][w] = max(dp[i][w-wt[i]] + val[i], dp[i-1][w])`

**Problems:**
- [Minimum Coins](_16_MinimumCoin/) - Coin change minimum
- [Coin Change Ways](_18_WaysToGetTargetUsingCoins/) - Count ways
- [Unbounded Knapsack](_19_UnboundedKnapsack/) - Unlimited items
- [Rod Cutting](_20_MaximumCostToCutTheRodOfGivenLen/) - Cut rod for max profit

---

### 5️⃣ LCS Pattern (String DP)
Problems involving two strings/sequences.

**Pattern:** `dp[i][j] = f(s1[i], s2[j], dp[i-1][j-1], dp[i-1][j], dp[i][j-1])`

**Problems:**
- [Longest Common Subsequence](_21_LongestCommonSubsequence/) - LCS foundation
- [Print LCS](_22_PrintLCS/) - Print actual LCS
- [Longest Common Substring](_23_LCSubstring/) - Contiguous match
- [Longest Palindromic Subsequence](_24_LongestPalindromicSubsequence/) - LCS variant
- [Min Insertion for Palindrome](_25_MinimumInsertionToMakeStringPalindrome/) - Make palindrome
- [Shortest Supersequence](_26_ShortestSupersequence/) - Merge strings
- [Distinct Subsequences](_27_CountDistinctSubsequences/) - Count matches
- [Edit Distance](_28_EditDistance/) - Transform string
- [Wildcard Matching](_29_WildcardMatching/) - Pattern matching
- [Interleaving String](_21_InterleavingString/) - Merge check

---

## Problem Categories

### 🟢 Easy (Beginner)
Start here to build foundation:
1. Climbing Stairs
2. Frog Jump
3. Maximum Sum Non-Adjacent
4. Unique Paths
5. Subset Sum Equal K

### 🟡 Medium (Intermediate)
Build pattern recognition:
1. House Robber 2
2. Min Path Sum
3. 0/1 Knapsack
4. Coin Change
5. LCS
6. Edit Distance

### 🔴 Hard (Advanced)
Master complex patterns:
1. Cherry Pickup 2
2. Wildcard Matching
3. Interleaving String
4. Distinct Subsequences
5. Rod Cutting with variations

---

## Learning Path

### Week 1: Linear DP
```
Day 1-2: Climbing Stairs, Frog Jump
Day 3-4: House Robber, House Robber 2
Day 5-7: Practice variations
```

### Week 2: Grid DP
```
Day 1-2: Unique Paths, Unique Paths 2
Day 3-4: Min Path Sum, Triangle
Day 5-7: Falling Path, Cherry Pickup
```

### Week 3: Knapsack
```
Day 1-2: Subset Sum, Partition Equal
Day 3-4: 0/1 Knapsack, Target Sum
Day 5-7: Unbounded variants
```

### Week 4: String DP
```
Day 1-3: LCS, Print LCS, LC Substring
Day 4-5: Edit Distance, Wildcard
Day 6-7: Advanced string problems
```

---

## Quick Reference

### Common DP Templates

#### 1D DP Template
```java
int[] dp = new int[n + 1];
dp[0] = base_case;
for (int i = 1; i <= n; i++) {
    dp[i] = f(dp[i-1], dp[i-2], ...);
}
return dp[n];
```

#### 2D DP Template
```java
int[][] dp = new int[m + 1][n + 1];
// Initialize base cases
for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
        dp[i][j] = f(dp[i-1][j], dp[i][j-1], ...);
    }
}
return dp[m][n];
```

#### Memoization Template
```java
int[][] memo = new int[m][n];
for (int[] row : memo) Arrays.fill(row, -1);

int solve(int i, int j) {
    if (base_case) return value;
    if (memo[i][j] != -1) return memo[i][j];
    return memo[i][j] = f(solve(i-1, j), solve(i, j-1));
}
```

#### Space Optimization Template
```java
int[] prev = new int[n + 1];
for (int i = 1; i <= m; i++) {
    int[] curr = new int[n + 1];
    for (int j = 1; j <= n; j++) {
        curr[j] = f(prev[j], curr[j-1], prev[j-1]);
    }
    prev = curr;
}
return prev[n];
```

---

### Time Complexity Cheat Sheet

| Pattern | Recursion | Memoization | Tabulation | Space Opt |
|---------|-----------|-------------|------------|-----------|
| Linear 1D | O(2^n) | O(n) | O(n) | O(1) |
| Grid 2D | O(2^(m+n)) | O(m×n) | O(m×n) | O(n) |
| Knapsack | O(2^n) | O(n×W) | O(n×W) | O(W) |
| LCS | O(2^(m+n)) | O(m×n) | O(m×n) | O(n) |

---

### Pattern Recognition Guide

**Use Linear DP when:**
- Single sequence/array
- Decision at each step affects future
- Examples: stairs, houses, stocks

**Use Grid DP when:**
- 2D matrix/grid
- Moving from start to end
- Examples: paths, falling paths

**Use Knapsack when:**
- Include/exclude decisions
- Weight/capacity constraint
- Examples: subset sum, partition

**Use String DP when:**
- Two strings involved
- Matching/transformation needed
- Examples: LCS, edit distance

---

## Tips & Tricks

### 1. Identify DP Problem
✅ Optimal substructure exists  
✅ Overlapping subproblems  
✅ Asks for optimal/count/possible  
✅ Choices at each step  

### 2. Solve Step-by-Step
1. Write recursive solution
2. Add memoization
3. Convert to tabulation
4. Optimize space

### 3. Common Mistakes
❌ Wrong base cases  
❌ Index out of bounds  
❌ Not handling edge cases  
❌ Incorrect state transition  

### 4. Debugging Tips
- Print recursion tree for small inputs
- Verify base cases
- Check state transitions
- Test with edge cases

---

## Resources

### Practice Platforms
- LeetCode DP Tag
- Codeforces DP Problems
- AtCoder DP Contest
- GeeksforGeeks DP

### Additional Reading
- Introduction to Algorithms (CLRS)
- Dynamic Programming for Coding Interviews
- Competitive Programming Handbook

---

## Progress Tracker

Track your progress:
- [ ] Linear DP (4 problems)
- [ ] Grid DP (6 problems)
- [ ] Knapsack 0/1 (7 problems)
- [ ] Unbounded Knapsack (4 problems)
- [ ] String DP (10 problems)

**Total: 31 Problems**

---

## Contributing
Feel free to add more problems and improve explanations!

**Happy Coding! 🚀**
