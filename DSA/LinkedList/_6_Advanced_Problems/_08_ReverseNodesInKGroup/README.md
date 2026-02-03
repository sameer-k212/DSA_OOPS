# Reverse Nodes in K-Group

## Problem Statement
Reverse nodes of a linked list k at a time. If remaining nodes < k, leave as is.

## Example
```
Input: 1->2->3->4->5, k = 2
Output: 2->1->4->3->5

Input: 1->2->3->4->5, k = 3
Output: 3->2->1->4->5
```

## Approach
**Recursive Reversal**:
1. Check if k nodes available
2. If yes, reverse k nodes
3. Recursively process remaining list
4. Connect reversed group to result

## Complexity
- **Time**: O(n) - visit each node once
- **Space**: O(n/k) - recursion stack

## Key Points
- Very hard interview problem
- Don't reverse if < k nodes remain
- Careful pointer manipulation
- Can also solve iteratively

## Interview Tip
This is a HARD problem - if asked, break it down step by step and explain your approach clearly before coding.
