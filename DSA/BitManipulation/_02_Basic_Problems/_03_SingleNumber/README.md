# Single Number

## Problem
Find element that appears once when all others appear twice.

## Example
```
Input: [4,1,2,1,2]
Output: 4
```

## Approach
**XOR Property**: `a ^ a = 0`, `a ^ 0 = a`

All pairs cancel out, leaving single number.

## Variations

### Single Number II (Two unique numbers)
1. XOR all numbers to get `xor = num1 ^ num2`
2. Find rightmost set bit in xor
3. Partition array based on this bit
4. XOR each partition separately

## Complexity
- **Time**: O(n)
- **Space**: O(1)

## Key Points
- Classic XOR application
- No extra space needed
- Very common in CP
