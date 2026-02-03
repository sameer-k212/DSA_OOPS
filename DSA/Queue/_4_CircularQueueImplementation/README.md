# Circular Queue

## Concept
Array-based queue with wraparound to reuse space.

## Key Points
- Front and rear pointers wrap around
- `(rear + 1) % capacity` for circular increment
- Full when `(rear + 1) % capacity == front`
- Empty when `front == -1`

## Advantages
- Efficient space utilization
- No wasted space after dequeue
- Fixed size with reuse

## Operations
- **enqueue(x)**: O(1)
- **dequeue()**: O(1)
- **peek()**: O(1)

## Use Cases
- Buffering
- CPU scheduling
- Memory management
