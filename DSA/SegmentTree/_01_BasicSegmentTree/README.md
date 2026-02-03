# Segment Tree - Basic Implementation

## Concept
Tree data structure for range queries and point updates.

## Structure
```
Array: [1, 3, 5, 7, 9, 11]
Tree:
        36
       /  \
      9    27
     / \   / \
    4   5 16 11
   / \ 
  1   3
```

## Operations

### 1. Build
```java
build(arr, node, start, end)
if (start == end) tree[node] = arr[start]
else:
    mid = (start + end) / 2
    build left and right
    tree[node] = tree[left] + tree[right]
```
**Time**: O(n)

### 2. Query (Range Sum)
```java
query(node, start, end, l, r)
if (no overlap) return 0
if (complete overlap) return tree[node]
else return query(left) + query(right)
```
**Time**: O(log n)

### 3. Update (Point Update)
```java
update(node, start, end, idx, val)
if (start == end) tree[node] = val
else update child and recalculate
```
**Time**: O(log n)

## Complexity
- **Build**: O(n)
- **Query**: O(log n)
- **Update**: O(log n)
- **Space**: O(4n)

## Key Points
- Tree size: 4 * n (safe allocation)
- Node indexing: left = 2*i+1, right = 2*i+2
- Three cases: no overlap, complete overlap, partial overlap

## Use Cases
- Range sum queries
- Range min/max queries
- Frequency queries
