# Sliding Window - Maximum Sum Subarray

## Problem
Find maximum sum of subarray of size k.

## Example
```
Input: arr = [1,4,2,10,23,3,1,0,20], k = 4
Output: 39 (10+23+3+3)
```

## Approach
**Fixed Size Sliding Window**:
1. Calculate sum of first k elements
2. Slide window: add next, remove first
3. Track maximum

## Template
```java
int sum = 0;
for (int i = 0; i < k; i++) sum += arr[i];
int max = sum;
for (int i = k; i < n; i++) {
    sum += arr[i] - arr[i-k];
    max = Math.max(max, sum);
}
```

## Complexity
- **Time**: O(n)
- **Space**: O(1)

## Key Points
- Avoid recalculating sum
- Add new, remove old
- Fixed vs variable window
