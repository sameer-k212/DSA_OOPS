# Reverse Linked List

## Problem Statement
Reverse a singly linked list.

## Example
```
Input: 1 -> 2 -> 3 -> 4 -> 5
Output: 5 -> 4 -> 3 -> 2 -> 1
```

## Approaches

### 1. Iterative (3 Pointers)
```java
prev = null, curr = head
while (curr != null):
    next = curr.next
    curr.next = prev
    prev = curr
    curr = next
return prev
```
**Complexity**: O(n) time, O(1) space

### 2. Recursive
```java
if (head == null || head.next == null) return head
newHead = reverse(head.next)
head.next.next = head
head.next = null
return newHead
```
**Complexity**: O(n) time, O(n) space

## Key Points
- Track three pointers: prev, curr, next
- Reverse links one by one
- Return prev (new head)
