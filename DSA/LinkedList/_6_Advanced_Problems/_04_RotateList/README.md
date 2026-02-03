# Rotate List

## Problem Statement
Rotate list to the right by k places.

## Example
```
Input: 1->2->3->4->5, k = 2
Output: 4->5->1->2->3
```

## Approach
1. Find length and make circular
2. Calculate new head position: len - (k % len)
3. Break circle at new tail

## Complexity
- **Time**: O(n) - two passes
- **Space**: O(1)

## Key Points
- Handle k > length using modulo
- Make circular then break
- Edge cases: empty, k=0
