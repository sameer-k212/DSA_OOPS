# Merge K Sorted Lists

## Problem Statement
Merge k sorted linked lists into one sorted list.

## Example
```
Input: [[1,4,5], [1,3,4], [2,6]]
Output: 1->1->2->3->4->4->5->6
```

## Approach
**Min Heap (Priority Queue)**:
1. Add first node of each list to min heap
2. Extract minimum node, add to result
3. Add next node from same list to heap
4. Repeat until heap is empty

## Complexity
- **Time**: O(N log k) where N = total nodes, k = number of lists
- **Space**: O(k) - heap size

## Key Points
- Heap maintains k nodes at most
- Always extract minimum efficiently
- Better than merging lists one by one
