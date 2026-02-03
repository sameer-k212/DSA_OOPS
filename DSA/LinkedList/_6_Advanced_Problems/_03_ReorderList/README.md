# Reorder List

## Problem Statement
Reorder list: L0 → L1 → L2 → ... → Ln-1 → Ln to L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → ...

## Example
```
Input: 1->2->3->4->5
Output: 1->5->2->4->3
```

## Approach
**Three Steps**:
1. Find middle using slow-fast pointer
2. Reverse second half
3. Merge two halves alternately

## Complexity
- **Time**: O(n) - three passes
- **Space**: O(1) - in-place

## Key Points
- Combines: find middle + reverse + merge
- Very tricky interview problem
- Must handle odd/even length lists
