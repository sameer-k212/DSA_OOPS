# Detect Cycle in Linked List

## Problem Statement
Detect if a linked list has a cycle and find where the cycle begins.

## Example
```
Input: 3->2->0->-4 (tail connects to node 2)
Output: true, cycle starts at node 2
```

## Approach
**Floyd's Cycle Detection (Tortoise and Hare)**:

### Part 1: Detect Cycle
- Slow moves 1 step, fast moves 2 steps
- If they meet, cycle exists

### Part 2: Find Cycle Start
- Reset slow to head
- Move both 1 step at a time
- Meeting point is cycle start

## Complexity
- **Time**: O(n) - at most 2 passes
- **Space**: O(1) - two pointers

## Key Points
- If fast reaches null, no cycle
- Mathematical proof: distance from head to cycle start = distance from meeting point to cycle start
