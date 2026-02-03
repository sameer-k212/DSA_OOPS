# Merge Two Sorted Lists

## Problem Statement
Merge two sorted linked lists into one sorted list.

## Example
```
Input: l1 = 1->2->4, l2 = 1->3->4
Output: 1->1->2->3->4->4
```

## Approach
Use dummy node and two pointers:
1. Compare values from both lists
2. Attach smaller node to result
3. Move pointer of chosen list
4. Attach remaining nodes

## Complexity
- **Time**: O(n + m) - traverse both lists
- **Space**: O(1) - only pointers

## Key Points
- Use dummy node to simplify edge cases
- Attach remaining list at end
- Both lists already sorted
