# Spiral Matrix

## Problem Statement
Given an `m x n` matrix, return all elements of the matrix in spiral order.

## Example
```
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

```
1 → 2 → 3
        ↓
4 → 5   6
↑       ↓
7 ← 8 ← 9
```

## Approach
Use four pointers (top, bottom, left, right) to traverse the matrix layer by layer:
1. Traverse right along the top row
2. Traverse down along the right column
3. Traverse left along the bottom row (if exists)
4. Traverse up along the left column (if exists)
5. Move boundaries inward and repeat

## Complexity
- **Time Complexity**: O(m × n) - visit each element once
- **Space Complexity**: O(1) - excluding output array

## Key Points
- Handle edge cases: empty matrix, single row/column
- Check boundaries before traversing bottom and left to avoid duplicates
- Update pointers after each direction traversal
