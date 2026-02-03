# Implement Stack using Queues

## Problem Statement
Implement LIFO stack using only FIFO queues.

## Approach
**Two Queues Method**:
- push(x): Add to q2, transfer all from q1 to q2, swap queues
- pop(): Remove from q1
- top(): Peek q1

## Complexity
- **push**: O(n) - transfer elements
- **pop/top**: O(1)

## Alternative
Single queue: rotate n-1 elements after each push

## Key Points
- Reverse queue order on push
- Makes push expensive, pop cheap
