# Min Stack

## Problem Statement
Design a stack that supports push, pop, top, and retrieving minimum element in O(1).

## Approach
Use two stacks:
- Main stack: stores all elements
- Min stack: stores minimum values

## Operations
- **push(x)**: Push to both if x ≤ current min
- **pop()**: Pop from both if top == min
- **getMin()**: Return minStack.peek()

## Complexity
All operations: O(1) time, O(n) space

## Key Points
- Classic interview problem
- Trade space for time
- Keep min stack synchronized
