# Range Sum Query - Mutable

## Problem (LeetCode 307)
Implement class with:
- `update(index, val)`: Update element at index
- `sumRange(left, right)`: Return sum of [left, right]

## Example
```
Input: [1, 3, 5]
sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
```

## Approach
Use Segment Tree for efficient range queries and updates.

## Complexity
- **Constructor**: O(n)
- **update**: O(log n)
- **sumRange**: O(log n)

## Alternative Approaches
1. **Brute Force**: O(1) update, O(n) query
2. **Prefix Sum**: O(n) update, O(1) query
3. **Segment Tree**: O(log n) both ✓

## Key Points
- Balanced solution for both operations
- Common interview problem
- Tests segment tree understanding
