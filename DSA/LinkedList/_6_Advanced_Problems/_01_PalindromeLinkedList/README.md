# Palindrome Linked List

## Problem Statement
Check if a linked list is a palindrome.

## Example
```
Input: 1->2->2->1
Output: true

Input: 1->2
Output: false
```

## Approach
**Find Middle + Reverse + Compare**:
1. Find middle using slow-fast pointers
2. Reverse second half
3. Compare first half with reversed second half

## Complexity
- **Time**: O(n) - three passes (find middle, reverse, compare)
- **Space**: O(1) - in-place reversal

## Key Points
- Combines multiple techniques
- Can restore list after checking
- O(1) space solution
