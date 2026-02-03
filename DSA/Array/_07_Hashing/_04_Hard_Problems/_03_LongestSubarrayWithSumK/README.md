# Longest Subarray with Sum K

**Problem**: Find length of longest subarray with sum equal to k.

**Core Concept**:
- Use prefix sum + HashMap
- Store first occurrence of each prefix sum
- If (currSum - k) exists → found subarray

**Example**:
```
arr = [10,5,2,7,1,9], k = 15
Prefix: [10,15,17,24,25,34]
currSum=24, need 24-15=9 → not found
currSum=25, need 25-15=10 → found at index 0
Length = 4 (elements: 5,2,7,1)
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
    sum += arr[i];
    if (map.containsKey(sum - k)) {
        maxLen = Math.max(maxLen, i - map.get(sum - k));
    }
    if (!map.containsKey(sum)) map.put(sum, i);
}
```
