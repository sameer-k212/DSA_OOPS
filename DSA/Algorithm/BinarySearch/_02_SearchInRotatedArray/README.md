# Search in Rotated Sorted Array

## Problem
Search in sorted array rotated at unknown pivot.

## Example
```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

## Approach
Modified binary search:
1. Find which half is sorted
2. Check if target in sorted half
3. Search accordingly

## Key Logic
```java
if (nums[left] <= nums[mid]) {
    // Left half sorted
    if (nums[left] <= target && target < nums[mid])
        search left
    else
        search right
} else {
    // Right half sorted
}
```

## Complexity
- **Time**: O(log n)
- **Space**: O(1)

## Key Points
- One half always sorted
- Check which half contains target
- Very common interview problem
