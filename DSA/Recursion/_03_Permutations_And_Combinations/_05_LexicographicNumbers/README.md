# Lexicographic Numbers

## Problem Statement
Given an integer n, return all numbers from 1 to n in lexicographical (dictionary) order.

## Example
```
Input: n = 13
Output: [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]

Input: n = 25
Output: [1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 2, 20, 21, 22, 23, 24, 25, 3, 4, 5, 6, 7, 8, 9]
```

## Approach
**DFS Tree Traversal**: Think of numbers as a tree where each node can have children 0-9.

```
        1           2       3  ...  9
       /|\         /|\      |
     10 11 12    20 21 22  30
     |
   100 101...
```

Start from 1-9, then recursively append digits 0-9 to form next numbers.

## Algorithm
1. Start DFS from 1 to 9
2. For each current number, try appending 0-9
3. Add to result if ≤ n
4. Recursively continue

## Complexity
- **Time**: O(n) - visit each number once
- **Space**: O(log n) - recursion depth

## Key Points
- Natural DFS order gives lexicographic order
- Stop when curr * 10 + i > n
- Start from 1, not 0
