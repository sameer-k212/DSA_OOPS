# Middle of Linked List

## Problem Statement
Find the middle node of a linked list. If two middle nodes exist, return the second one.

## Example
```
Input: 1->2->3->4->5
Output: 3

Input: 1->2->3->4->5->6
Output: 4
```

## Approach
**Slow-Fast Pointer (Tortoise and Hare)**:
- Slow moves 1 step
- Fast moves 2 steps
- When fast reaches end, slow is at middle

## Complexity
- **Time**: O(n) - single pass
- **Space**: O(1) - two pointers

## Key Points
- Fast pointer moves twice as fast
- No need to count nodes first
- Classic two-pointer technique
