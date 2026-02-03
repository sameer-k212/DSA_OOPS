# Range Minimum Query (RMQ)

## Problem
Find minimum element in range [l, r] with updates.

## Example
```
Array: [8, 2, 5, 1, 4, 5, 3, 9, 6, 10]
queryMin(3, 8) -> 1
update(4, 0)
queryMin(3, 8) -> 0
```

## Approach
Segment Tree with min operation instead of sum.

## Key Difference from Sum
```java
// Build
tree[node] = Math.min(tree[left], tree[right])

// Query (no overlap)
return Integer.MAX_VALUE

// Update
tree[node] = Math.min(tree[left], tree[right])
```

## Complexity
- **Build**: O(n)
- **Query**: O(log n)
- **Update**: O(log n)

## Variations
- **Range Max Query**: Use Math.max
- **Range GCD Query**: Use gcd function
- **Range OR/AND Query**: Use bitwise operations

## Alternative: Sparse Table
- O(n log n) preprocessing
- O(1) query
- No updates allowed

## Key Points
- Same structure as sum segment tree
- Change merge operation
- Return appropriate identity value
