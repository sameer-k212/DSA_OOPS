# XOR Queries of Subarray

## Problem
Answer multiple XOR queries on subarray [L, R].

## Example
```
Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3]]
Output: [2,7,14]
```

## Approach
**Prefix XOR**: Similar to prefix sum

```
prefix[i] = arr[0] ^ arr[1] ^ ... ^ arr[i-1]
XOR(L, R) = prefix[R+1] ^ prefix[L]
```

Why? `prefix[R+1] ^ prefix[L]` cancels elements before L.

## Complexity
- **Time**: O(n + q)
- **Space**: O(n)

## Key Points
- Prefix XOR for range queries
- XOR cancellation property
- Common CP technique
