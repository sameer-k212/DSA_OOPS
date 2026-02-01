# Longest Subarray with Equal 0s and 1s

**Problem**: Find length of longest subarray with equal number of 0s and 1s.

**Core Concept**:
- Convert 0 → -1, keep 1 as 1
- Problem becomes: find longest subarray with sum = 0
- Use prefix sum + HashMap to track first occurrence

**Example**:
```
arr = [0,1,0,1,1,0]
Convert: [-1,1,-1,1,1,-1]
Output: 6 (entire array)
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashMap storage

**Code**:
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, -1);
int sum = 0, maxLen = 0;
for (int i = 0; i < n; i++) {
    sum += (arr[i] == 0) ? -1 : 1;
    if (map.containsKey(sum)) {
        maxLen = Math.max(maxLen, i - map.get(sum));
    } else map.put(sum, i);
}
```
