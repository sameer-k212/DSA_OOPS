# Check Power of Two

## Problem
Check if a number is a power of 2.

## Example
```
Input: 16
Output: true (2^4)

Input: 18
Output: false
```

## Approach
**Bit Trick**: `n & (n-1) == 0`

Power of 2 has only one set bit:
```
16 = 10000
15 = 01111
16 & 15 = 00000 = 0
```

## Complexity
- **Time**: O(1)
- **Space**: O(1)

## Key Points
- Power of 2: only one bit set
- `n & (n-1)` clears rightmost set bit
- Check n > 0 to handle negative numbers
