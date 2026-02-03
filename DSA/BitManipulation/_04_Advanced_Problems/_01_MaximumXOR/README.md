# Maximum XOR of Two Numbers

## Problem
Find maximum XOR of any two numbers in array.

## Example
```
Input: [3,10,5,25,2,8]
Output: 28
Explanation: 5 ^ 25 = 28
```

## Approach
**Greedy Bit by Bit**:
1. Build result from MSB to LSB
2. For each bit, try to set it to 1
3. Use HashSet to check if valid pair exists
4. If `a ^ b = max`, then `a ^ max = b`

## Complexity
- **Time**: O(32 * n) = O(n)
- **Space**: O(n)

## Alternative
Trie-based approach for multiple queries

## Key Points
- HARD problem on LeetCode
- Greedy from MSB
- Important for CP contests
