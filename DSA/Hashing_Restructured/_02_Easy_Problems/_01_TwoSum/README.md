# Two Sum

**Problem**: Find two indices where arr[i] + arr[j] = target.

**Core Concept**:
- Use HashMap to store {value → index}
- For each element, check if (target - element) exists
- Return indices when found

**Example**:
```
arr = [2, 7, 11, 15], target = 9
Output: [0, 1] (2 + 7 = 9)
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashMap storage

**Code**:
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int i = 0; i < n; i++) {
    int complement = target - arr[i];
    if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
    }
    map.put(arr[i], i);
}
```
