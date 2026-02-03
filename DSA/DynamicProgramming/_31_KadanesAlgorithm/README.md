# Kadane's Algorithm

## Problem Statement
Find the contiguous subarray within an array which has the largest sum.

## Example
```
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6
```

## Approach
**Kadane's Algorithm**: Track current subarray sum and maximum sum seen so far.

Algorithm:
1. Initialize sum = 0, maxi = nums[0]
2. For each element:
   - Add to current sum
   - Update maxi if current sum is greater
   - Reset sum to 0 if it becomes negative

## Complexity
- **Time**: O(n) - single pass through array
- **Space**: O(1) - constant extra space

## Key Points
- Reset sum when it goes negative (start fresh subarray)
- Always track maximum sum encountered
- Works for arrays with all negative numbers
