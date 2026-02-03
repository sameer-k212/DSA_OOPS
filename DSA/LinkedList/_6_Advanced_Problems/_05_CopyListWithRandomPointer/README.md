# Copy List with Random Pointer

## Problem Statement
Deep copy a linked list where each node has a next and random pointer.

## Example
```
Input: [[7,null],[13,0],[11,4]]
Output: Deep copy with same structure
```

## Approach
**Interweaving Method (O(1) space)**:
1. Create copy nodes: A->A'->B->B'->C->C'
2. Assign random pointers: A'.random = A.random.next
3. Separate lists: restore original and extract copy

## Complexity
- **Time**: O(n) - three passes
- **Space**: O(1) - no extra space (excluding output)

## Alternative
HashMap approach: O(n) space

## Key Points
- Very tricky interview problem
- Tests deep copy understanding
- Interweaving is elegant O(1) solution
