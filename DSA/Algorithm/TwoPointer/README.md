# Two Pointer Technique

## Concept
Use two pointers to solve problems efficiently.

## Patterns

### 1. Opposite Direction
```java
int left = 0, right = n - 1;
while (left < right) {
    // Process
    if (condition) left++;
    else right--;
}
```
**Use**: Two Sum, Container With Most Water, Valid Palindrome

### 2. Same Direction (Fast-Slow)
```java
int slow = 0, fast = 0;
while (fast < n) {
    // Process
    fast++;
    if (condition) slow++;
}
```
**Use**: Remove Duplicates, Move Zeros

### 3. Sliding Window
```java
int left = 0;
for (int right = 0; right < n; right++) {
    // Expand window
    while (condition) {
        // Shrink window
        left++;
    }
}
```
**Use**: Longest Substring, Max Sum Subarray

## Complexity
- **Time**: O(n) - single pass
- **Space**: O(1) - no extra space

## Key Problems
- Two Sum (sorted)
- Three Sum
- Container With Most Water
- Trapping Rain Water
- Remove Duplicates
