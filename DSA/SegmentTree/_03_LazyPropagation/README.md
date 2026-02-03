# Lazy Propagation

## Concept
Optimize segment tree for range updates by delaying updates.

## Problem
Without lazy propagation:
- Range update: O(n log n) - update each element
- With lazy propagation: O(log n) - delay updates

## How It Works
1. Store pending updates in lazy array
2. Push updates down only when needed
3. Update range in O(log n)

## Push Operation
```java
push(node, start, end):
    if (lazy[node] != 0):
        tree[node] += (end - start + 1) * lazy[node]
        if (not leaf):
            lazy[left] += lazy[node]
            lazy[right] += lazy[node]
        lazy[node] = 0
```

## Range Update
```java
updateRange(l, r, val):
    if (complete overlap):
        lazy[node] += val
        push(node)
    else:
        update left and right
```

## Complexity
- **Range Update**: O(log n)
- **Query**: O(log n)
- **Space**: O(4n) for tree + O(4n) for lazy

## Key Points
- Essential for range updates
- Push lazy values before accessing node
- Common in competitive programming

## Use Cases
- Range increment/decrement
- Range set operations
- Multiple range updates
