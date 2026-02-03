# Next Greater Element

## Problem Statement
Find the next greater element for each element in array.

## Example
```
Input: [4, 5, 2, 10, 8]
Output: [5, 10, 10, -1, -1]
```

## Approach
**Monotonic Stack (Decreasing)**:
- Traverse from right to left
- Pop elements ≤ current
- Top of stack is next greater
- Push current element

## Complexity
- **Time**: O(n) - each element pushed/popped once
- **Space**: O(n) - stack

## Key Points
- Classic monotonic stack problem
- Traverse right to left for next greater
- Maintain decreasing stack
