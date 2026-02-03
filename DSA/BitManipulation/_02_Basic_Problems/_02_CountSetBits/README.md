# Count Set Bits (Hamming Weight)

## Problem
Count number of 1's in binary representation.

## Example
```
Input: 13 (1101)
Output: 3

Input: 15 (1111)
Output: 4
```

## Approach
**Brian Kernighan's Algorithm**: `n & (n-1)` removes rightmost set bit

```
13 = 1101
12 = 1100
13 & 12 = 1100 (count = 1)

12 = 1100
11 = 1011
12 & 11 = 1000 (count = 2)

8 = 1000
7 = 0111
8 & 7 = 0000 (count = 3)
```

## Complexity
- **Time**: O(k) where k = number of set bits
- **Space**: O(1)

## Key Points
- Each iteration removes one set bit
- Faster than checking each bit
- Built-in: `Integer.bitCount(n)`
