# Find First and Last Position

## Problem
Find starting and ending position of target in sorted array.

## Example
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

## Approach
Two binary searches:
1. **First occurrence**: Move right = mid - 1 when found
2. **Last occurrence**: Move left = mid + 1 when found

## Complexity
- **Time**: O(log n)
- **Space**: O(1)

## Key Points
- Lower bound: continue searching left
- Upper bound: continue searching right
- Store result and keep searching
