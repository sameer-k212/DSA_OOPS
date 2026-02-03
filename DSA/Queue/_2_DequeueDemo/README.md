# Deque (Double-Ended Queue)

## Concept
Queue that allows insertion/deletion from both ends.

## Operations
- **addFirst(x)**: Add to front - O(1)
- **addLast(x)**: Add to rear - O(1)
- **removeFirst()**: Remove from front - O(1)
- **removeLast()**: Remove from rear - O(1)
- **peekFirst()**: View front - O(1)
- **peekLast()**: View rear - O(1)

## Use Cases
- Sliding Window Maximum
- Palindrome checking
- Undo/Redo operations
- Browser history

## Implementation
Java: `Deque<Integer> deque = new ArrayDeque<>();`

## Key Problems
- Sliding Window Maximum
- Max of all subarrays of size k
