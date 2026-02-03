# Intersection of Two Linked Lists

## Problem Statement
Find the node where two linked lists intersect.

## Example
```
A:     4->1
            \
             8->4->5
            /
B: 5->6->1

Output: Node with value 8
```

## Approach
**Two Pointer Switch**:
1. Traverse both lists with two pointers
2. When pointer reaches end, switch to other list's head
3. They will meet at intersection (or null)

**Why it works**: Both pointers travel same distance (lenA + lenB)

## Complexity
- **Time**: O(m + n) - traverse both lists
- **Space**: O(1) - two pointers

## Key Points
- Elegant solution without calculating lengths
- Handles different length lists
- Returns null if no intersection
