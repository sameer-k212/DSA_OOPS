# Longest Substring with K Distinct Characters

## Problem
Find longest substring with at most k distinct characters.

## Example
```
Input: s = "eceba", k = 2
Output: 3 ("ece")
```

## Approach
**Variable Size Sliding Window**:
1. Expand window (right++)
2. Track character frequency
3. Shrink when distinct > k (left++)
4. Update max length

## Template
```java
Map<Character, Integer> map = new HashMap<>();
int left = 0, maxLen = 0;
for (int right = 0; right < n; right++) {
    // Add to window
    while (condition_violated) {
        // Shrink from left
    }
    maxLen = Math.max(maxLen, right - left + 1);
}
```

## Complexity
- **Time**: O(n)
- **Space**: O(k)

## Key Points
- HashMap for frequency
- Expand right, shrink left
- Variable window size
