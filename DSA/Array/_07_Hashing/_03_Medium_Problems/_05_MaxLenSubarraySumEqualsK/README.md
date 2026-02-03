# Subarray Sum Equals K

**Problem**: Count number of continuous subarrays whose sum equals k.

**Core Concept**:
- Use prefix sum + HashMap
- If (currSum - k) exists in map → found subarray
- Store frequency of each prefix sum

**Example**:
```
nums = [1,1,1], k = 2
Prefix: [1,2,3]
Subarrays: [1,1], [1,1] → count = 2
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashMap storage

**Code**:
```java
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);
int sum = 0, count = 0;
for (int num : nums) {
    sum += num;
    if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
    }
    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
```
