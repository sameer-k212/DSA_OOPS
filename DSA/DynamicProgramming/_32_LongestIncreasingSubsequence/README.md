# Longest Increasing Subsequence (LIS)

## Problem Statement
Find the length of the longest strictly increasing subsequence in an array.

## Example
```
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: [2,3,7,101] is the longest increasing subsequence
```

## Approach
**DP State**: `dp[i]` = length of LIS ending at index i

For each element, check all previous elements:
- If `nums[i] > nums[j]`, we can extend the subsequence ending at j
- `dp[i] = max(dp[i], dp[j] + 1)`

## Complexity
- **Time**: O(n²) - nested loops
- **Space**: O(n) - DP array

## Optimization
Binary search approach: O(n log n) time using patience sorting

## Key Points
- Initialize all `dp[i] = 1` (each element is a subsequence of length 1)
- Track maximum value across all dp[i]
