# Subarray with Zero Sum

**Problem**: Check if array has a subarray with sum = 0.

**Core Concept**:
- Use prefix sum + HashSet
- If prefix sum repeats → subarray between has sum 0
- If prefix sum = 0 → subarray from start has sum 0

**Example**:
```
arr = [4,2,-3,1,6]
Prefix: [4,6,3,4,10]
4 repeats at index 0 and 3 → subarray [2,-3,1] has sum 0
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashSet storage

**Code**:
```java
HashSet<Integer> set = new HashSet<>();
int sum = 0;
for (int num : arr) {
    sum += num;
    if (sum == 0 || set.contains(sum)) return true;
    set.add(sum);
}
return false;
```
