# Generate All Subsets Using Bits

## Problem
Generate all subsets of an array using bit manipulation.

## Example
```
Input: [1,2,3]
Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
```

## Approach
**Bitmask**: Each subset represented by n-bit number

```
For [1,2,3]:
000 = []
001 = [1]
010 = [2]
011 = [1,2]
100 = [3]
101 = [1,3]
110 = [2,3]
111 = [1,2,3]
```

Total subsets = 2^n

## Complexity
- **Time**: O(n * 2^n)
- **Space**: O(2^n)

## Key Points
- Iterate from 0 to 2^n - 1
- Check each bit to include element
- Very useful in CP for subset problems
