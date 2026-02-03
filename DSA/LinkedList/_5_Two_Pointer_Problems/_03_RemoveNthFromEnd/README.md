# Remove Nth Node From End

## Problem Statement
Remove the nth node from the end of a linked list in one pass.

## Example
```
Input: 1->2->3->4->5, n = 2
Output: 1->2->3->5
```

## Approach
**Two Pointer with Gap**:
1. Move fast pointer n+1 steps ahead
2. Move both pointers until fast reaches end
3. Slow will be at node before target
4. Remove target node

## Complexity
- **Time**: O(n) - single pass
- **Space**: O(1) - two pointers

## Key Points
- Use dummy node to handle edge case (removing head)
- Maintain gap of n+1 between pointers
- One pass solution
