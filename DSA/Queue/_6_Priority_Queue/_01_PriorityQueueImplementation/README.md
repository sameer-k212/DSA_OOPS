# Priority Queue Implementation (Min Heap)

## Implementation
Priority queue using binary min heap.

## Operations
- **insert(x)**: Add element, bubble up - O(log n)
- **extractMin()**: Remove min, heapify down - O(log n)
- **peek()**: View min - O(1)

## Heap Properties
- Parent at (i-1)/2
- Left child at 2*i+1
- Right child at 2*i+2
- Min heap: parent ≤ children

## Complexity
- **Insert**: O(log n)
- **Extract**: O(log n)
- **Space**: O(n)

## Key Points
- Array-based implementation
- Complete binary tree
- Used in Dijkstra, Prim's algorithms
