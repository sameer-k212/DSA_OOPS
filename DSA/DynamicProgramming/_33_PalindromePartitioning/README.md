# Palindrome Partitioning

## Problem Statement
Given a string, partition it such that every substring is a palindrome. Find the minimum cuts needed.

## Example
```
Input: s = "aab"
Output: 1
Explanation: "aa" | "b" (1 cut)
```

## Approach
**Two-step DP:**
1. Build `isPalin[i][j]` table to check if substring is palindrome
2. `dp[i]` = minimum cuts needed for s[0...i]

For each position i:
- If s[0...i] is palindrome, dp[i] = 0
- Else try all partitions: `dp[i] = min(dp[j-1] + 1)` where s[j...i] is palindrome

## Complexity
- **Time**: O(n²) - build palindrome table + DP
- **Space**: O(n²) - palindrome table

## Key Points
- Precompute palindrome table for O(1) lookup
- A string is palindrome if ends match and middle is palindrome
