# Matrix Chain Multiplication

## Problem Statement
Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is to determine the minimum number of scalar multiplications needed.

## Example
```
Input: arr[] = {1, 2, 3, 4, 3}
Matrices: A1(1x2), A2(2x3), A3(3x4), A4(4x3)
Output: 30
```

## Approach
**Partition DP Pattern**: Try all possible positions to split the chain and find minimum operations.

For matrices from i to j:
- Try every partition point k between i and j
- Cost = cost(i,k) + cost(k+1,j) + arr[i-1] × arr[k] × arr[j]

## Solutions
1. **Recursion**: O(2^n) time, O(n) space
2. **Memoization**: O(n³) time, O(n²) space

## Complexity
- **Time**: O(n³) with memoization
- **Space**: O(n²) for DP table

## Key Points
- Base case: Single matrix (i == j) requires 0 operations
- arr[i-1] × arr[i] represents dimensions of matrix i
