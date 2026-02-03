# Dynamic Programming - Quick Reference Cheat Sheet

## 🎯 Pattern Recognition

| Pattern | Identify By | State | Example |
|---------|-------------|-------|---------|
| **Linear 1D** | Single array, choices at each step | `dp[i]` | Climbing Stairs |
| **Grid 2D** | Matrix, start to end path | `dp[i][j]` | Unique Paths |
| **Knapsack 0/1** | Include/exclude, capacity limit | `dp[i][w]` | Subset Sum |
| **Unbounded** | Unlimited items, capacity limit | `dp[i][w]` | Coin Change |
| **String DP** | Two strings, matching/transform | `dp[i][j]` | LCS, Edit Distance |

---

## 📝 Code Templates

### 1D DP Template
```java
int[] dp = new int[n + 1];
dp[0] = base_case;
for (int i = 1; i <= n; i++) {
    dp[i] = Math.max/min(dp[i-1] + ..., dp[i-2] + ...);
}
return dp[n];
```

### 2D DP Template
```java
int[][] dp = new int[m + 1][n + 1];
// Base cases
for (int i = 1; i <= m; i++) {
    for (int j = 1; j <= n; j++) {
        if (condition)
            dp[i][j] = dp[i-1][j-1] + ...;
        else
            dp[i][j] = Math.max/min(dp[i-1][j], dp[i][j-1]);
    }
}
return dp[m][n];
```

### Memoization Template
```java
int[][] memo = new int[m][n];
for (int[] row : memo) Arrays.fill(row, -1);

int solve(int i, int j) {
    if (base_case) return value;
    if (memo[i][j] != -1) return memo[i][j];
    // Recursive logic
    return memo[i][j] = result;
}
```

### Space Optimization Template
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

## 🔑 Key Formulas

### Climbing Stairs
```
dp[i] = dp[i-1] + dp[i-2]
```

### Frog Jump
```
dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
```

### House Robber
```
dp[i] = max(dp[i-1], arr[i] + dp[i-2])
```

### Unique Paths
```
dp[i][j] = dp[i-1][j] + dp[i][j-1]
```

### Min Path Sum
```
dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])
```

### 0/1 Knapsack
```
if (wt[i] <= w)
    dp[i][w] = max(val[i] + dp[i-1][w-wt[i]], dp[i-1][w])
else
    dp[i][w] = dp[i-1][w]
```

### Unbounded Knapsack
```
if (wt[i] <= w)
    dp[i][w] = max(val[i] + dp[i][w-wt[i]], dp[i-1][w])
                              ↑ Same row (unlimited)
```

### Subset Sum
```
if (arr[i] <= target)
    dp[i][target] = dp[i-1][target] || dp[i-1][target-arr[i]]
else
    dp[i][target] = dp[i-1][target]
```

### LCS
```
if (s1[i] == s2[j])
    dp[i][j] = 1 + dp[i-1][j-1]
else
    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
```

### Edit Distance
```
if (s1[i] == s2[j])
    dp[i][j] = dp[i-1][j-1]
else
    dp[i][j] = 1 + min(dp[i-1][j],      // delete
                       dp[i][j-1],        // insert
                       dp[i-1][j-1])      // replace
```

### Longest Palindromic Subsequence
```
LPS(s) = LCS(s, reverse(s))
```

### Min Insertion for Palindrome
```
Min Insertions = n - LPS(s)
```

### Shortest Supersequence
```
Length = m + n - LCS(s1, s2)
```

---

## ⚡ Complexity Quick Reference

| Problem | Recursion | Memoization | Tabulation | Space Opt |
|---------|-----------|-------------|------------|-----------|
| Climbing Stairs | O(2^n) | O(n) | O(n) | O(1) |
| Frog Jump | O(2^n) | O(n) | O(n) | O(1) |
| House Robber | O(2^n) | O(n) | O(n) | O(1) |
| Unique Paths | O(2^(m+n)) | O(m×n) | O(m×n) | O(n) |
| 0/1 Knapsack | O(2^n) | O(n×W) | O(n×W) | O(W) |
| Unbounded KS | O(W^n) | O(n×W) | O(n×W) | O(W) |
| LCS | O(2^(m+n)) | O(m×n) | O(m×n) | O(n) |
| Edit Distance | O(3^(m+n)) | O(m×n) | O(m×n) | O(n) |

---

## 🎨 Common Patterns

### Pattern 1: Max/Min at Each Step
```java
for (int i = 1; i <= n; i++) {
    dp[i] = Math.max(choice1, choice2);
}
```
**Examples:** House Robber, Frog Jump

### Pattern 2: Count Ways
```java
for (int i = 1; i <= n; i++) {
    dp[i] = dp[i-1] + dp[i-2];
}
```
**Examples:** Climbing Stairs, Coin Change Ways

### Pattern 3: Include/Exclude
```java
int include = val[i] + dp[i-1][remaining];
int exclude = dp[i-1][current];
dp[i][current] = Math.max(include, exclude);
```
**Examples:** Knapsack, Subset Sum

### Pattern 4: String Matching
```java
if (s1[i] == s2[j])
    dp[i][j] = 1 + dp[i-1][j-1];
else
    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
```
**Examples:** LCS, LPS

---

## 🚨 Common Mistakes

### 1. Index Out of Bounds
❌ `dp[i-1]` when `i = 0`  
✅ Check base case: `if (i == 0) return base_value;`

### 2. Wrong Base Case
❌ `dp[0] = 0` for all problems  
✅ Think about what `dp[0]` means in context

### 3. 0/1 vs Unbounded Confusion
❌ Using `dp[i-1][w-wt[i]]` for unbounded  
✅ Use `dp[i][w-wt[i]]` for unbounded (same row)

### 4. String Indexing
❌ Using 0-based indexing without handling negatives  
✅ Use 1-based indexing in tabulation: `s.charAt(i-1)`

### 5. Space Optimization Direction
❌ Iterating left to right when should go right to left  
✅ For 0/1 knapsack space opt: iterate weight from W to 0

---

## 💡 Problem-Solving Steps

### Step 1: Identify Pattern
- Single array? → Linear DP
- Grid/Matrix? → Grid DP
- Include/exclude? → Knapsack
- Two strings? → String DP

### Step 2: Define State
- What does `dp[i]` or `dp[i][j]` represent?
- What are the dimensions?

### Step 3: Find Recurrence
- What choices do we have?
- How do subproblems relate?

### Step 4: Base Cases
- What are the smallest subproblems?
- What are their answers?

### Step 5: Implement
1. Recursion (to understand)
2. Memoization (add caching)
3. Tabulation (bottom-up)
4. Space Optimization (if needed)

---

## 🎯 Interview Tips

### Time Management
- 5 min: Understand problem
- 5 min: Identify pattern
- 10 min: Write recursion
- 10 min: Convert to DP
- 5 min: Test & optimize

### Communication
1. State the pattern you recognize
2. Define your DP state clearly
3. Explain the recurrence relation
4. Mention time/space complexity
5. Discuss optimization possibilities

### Common Questions
- "Can you optimize space?" → Use 1D array
- "What if constraints are larger?" → Discuss trade-offs
- "Can you print the solution?" → Backtrack through DP table

---

## 📚 Problem Difficulty

### Easy (Start Here)
1. Climbing Stairs
2. Frog Jump
3. House Robber
4. Unique Paths
5. Min Path Sum

### Medium (Build Skills)
1. 0/1 Knapsack
2. Coin Change
3. LCS
4. Edit Distance
5. Triangle

### Hard (Master Level)
1. Cherry Pickup 2
2. Wildcard Matching
3. Interleaving String
4. Distinct Subsequences
5. Palindrome Partitioning

---

## 🔗 Quick Navigation

| Pattern | Key Problem | README Link |
|---------|-------------|-------------|
| Linear 1D | Climbing Stairs | [Link](_1_ClimbingStairs/Readme.md) |
| Grid 2D | Unique Paths | [Link](_5_UniquePaths/readme.md) |
| Knapsack 0/1 | 0/1 Knapsack | [Link](_15_01Knapsack/readme.md) |
| Unbounded | Coin Change | [Link](_16_MinimumCoin/README.md) |
| String DP | LCS | [Link](_21_LongestCommonSubsequence/README.md) |

---

## 🎓 Practice Schedule

### Week 1: Foundation
- Day 1-2: Climbing Stairs, Frog Jump
- Day 3-4: House Robber variants
- Day 5-7: Practice & variations

### Week 2: Grid Problems
- Day 1-2: Unique Paths variants
- Day 3-4: Min Path Sum, Triangle
- Day 5-7: Falling Path, Cherry Pickup

### Week 3: Knapsack
- Day 1-2: Subset Sum, Partition
- Day 3-4: 0/1 Knapsack, Target Sum
- Day 5-7: Unbounded variants

### Week 4: Strings
- Day 1-2: LCS, Print LCS
- Day 3-4: Edit Distance
- Day 5-7: Advanced string problems

---

## ✅ Checklist

Before Interview:
- [ ] Can identify DP pattern in 2 minutes
- [ ] Can write recursion for any problem
- [ ] Can convert recursion to memoization
- [ ] Can write tabulation solution
- [ ] Can optimize space when needed
- [ ] Can explain time/space complexity
- [ ] Have solved 20+ DP problems

---

**Print this cheat sheet for quick revision! 📄**

*Last Updated: [Current Date]*
