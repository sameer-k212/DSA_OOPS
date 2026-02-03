# Evaluate Reverse Polish Notation (Postfix)

## Problem Statement
Evaluate arithmetic expression in Reverse Polish Notation.

## Example
```
Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

## Approach
**Stack-based Evaluation**:
- If operand: push to stack
- If operator: pop two operands, apply operator, push result
- Final stack top is answer

## Complexity
- **Time**: O(n) - single pass
- **Space**: O(n) - stack

## Key Points
- Postfix notation: no parentheses needed
- Pop order matters: second pop is first operand
- Classic stack application
