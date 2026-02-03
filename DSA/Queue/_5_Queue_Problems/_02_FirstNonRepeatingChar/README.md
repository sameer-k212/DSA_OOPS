# First Non-Repeating Character in Stream

## Problem Statement
Find first non-repeating character at each point in a stream.

## Example
```
Input: "aabc"
Output: "a#bb"
Explanation: 
a -> a
aa -> #
aab -> b
aabc -> b
```

## Approach
**Queue + Frequency Array**:
- Maintain queue of characters in order
- Track frequency of each character
- Remove repeating chars from queue front
- First in queue is answer

## Complexity
- **Time**: O(n) - each char processed once
- **Space**: O(26) - constant

## Key Points
- Queue maintains order
- Remove duplicates from front
- Classic queue application
