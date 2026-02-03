# QuickSort on Doubly Linked List

## Problem Statement
Implement QuickSort algorithm on a doubly linked list.

## Example
```
Input: 5 <-> 2 <-> 8 <-> 1 <-> 9
Output: 1 <-> 2 <-> 5 <-> 8 <-> 9
```

## Approach
**Partition-based QuickSort**:
1. Choose last node as pivot
2. Partition: elements ≤ pivot on left, > pivot on right
3. Recursively sort left and right partitions
4. Use prev pointers to traverse backwards

## Algorithm
```
partition(low, high):
    pivot = high.data
    i = low.prev
    for j from low to high-1:
        if j.data <= pivot:
            i = i.next
            swap(i.data, j.data)
    swap(i.next.data, high.data)
    return i.next

quickSort(low, high):
    if low < high:
        pivot = partition(low, high)
        quickSort(low, pivot.prev)
        quickSort(pivot.next, high)
```

## Complexity
- **Time**: O(n log n) average, O(n²) worst case
- **Space**: O(log n) recursion stack

## Key Points
- Use prev pointer to access previous nodes
- Partition similar to array QuickSort
- Handle edge cases: empty list, single node
- Swap data values, not node pointers

## Interview Tips
- Explain why doubly linked list (need prev pointer)
- Discuss pivot selection strategies
- Mention in-place sorting advantage
