# Largest Rectangle in Histogram

## Problem Statement
Find the largest rectangle area in a histogram.

## Example
```
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: Rectangle with height 5 and width 2
```

## Approach
**Monotonic Stack**:
- Maintain increasing stack of indices
- When smaller height found, calculate area for popped heights
- Width = current index - stack.peek() - 1
- Add sentinel 0 at end to clear stack

## Complexity
- **Time**: O(n) - each bar pushed/popped once
- **Space**: O(n) - stack

## Key Points
- Very tricky interview problem
- Use indices in stack, not heights
- Calculate width carefully
- HARD problem on LeetCode
