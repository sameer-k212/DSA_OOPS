# Flatten Multilevel Doubly Linked List

## Problem Statement
Flatten a multilevel doubly linked list where nodes can have child pointers.

## Example
```
Input: 1---2---3
           |
           7---8

Output: 1---2---7---8---3
```

## Approach
**DFS Traversal**:
1. When child found, insert child list between curr and next
2. Recursively flatten child
3. Connect flattened child to curr
4. Move to end of child list
5. Connect to original next

## Complexity
- **Time**: O(n) - visit each node once
- **Space**: O(d) - recursion depth

## Key Points
- Handle prev/next/child pointers carefully
- Set child to null after flattening
- Tricky pointer manipulation
