# Add Two Numbers

## Problem Statement
Add two numbers represented as linked lists (digits stored in reverse order).

## Example
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807
```

## Approach
**Elementary Math with Carry**:
1. Traverse both lists simultaneously
2. Add corresponding digits + carry
3. Create new node with sum % 10
4. Update carry = sum / 10
5. Continue until both lists exhausted and carry = 0

## Complexity
- **Time**: O(max(m, n)) - traverse longer list
- **Space**: O(max(m, n)) - result list

## Key Points
- Handle different lengths
- Don't forget final carry
- Digits in reverse order
- Common interview problem

## Variation
Add Two Numbers II: digits in normal order (use stack or reverse)
