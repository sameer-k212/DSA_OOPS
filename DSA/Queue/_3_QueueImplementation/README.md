# Queue Implementations

## Overview
Queue follows FIFO (First In First Out) principle.

## Implementations

### 1. Queue Using Array
- Fixed size
- Front and rear pointers
- O(1) enqueue/dequeue

### 2. Queue Using ArrayList
- Dynamic size
- Automatic resizing
- O(1) amortized operations

### 3. Queue Using LinkedList
- Dynamic size
- No size limit
- O(1) operations

### 4. Queue Using Stacks
- Two stacks approach
- Amortized O(1) operations

### 5. Circular Queue
- Fixed size with wraparound
- Efficient space utilization
- Front and rear pointers

## Operations
- **enqueue(x)**: Add element to rear
- **dequeue()**: Remove element from front
- **peek()**: View front element
- **isEmpty()**: Check if empty
- **isFull()**: Check if full (array-based)

## Complexity
All basic operations: O(1) time
