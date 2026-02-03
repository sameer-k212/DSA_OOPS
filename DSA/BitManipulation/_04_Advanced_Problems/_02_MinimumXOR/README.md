# Minimize XOR

## Problem
Find x with same number of set bits as num2 that minimizes x XOR num1.

## Example
```
Input: num1 = 3, num2 = 5
Output: 3
Explanation: 3 has 2 set bits (same as 5), 3 XOR 3 = 0 (minimum)
```

## Approach
1. Count set bits in num2
2. Set bits in result matching num1's set bits (from MSB)
3. If more bits needed, set from LSB

## Complexity
- **Time**: O(32) = O(1)
- **Space**: O(1)

## Key Points
- Greedy: match MSB first for minimum XOR
- Fill remaining from LSB
- Medium difficulty CP problem
