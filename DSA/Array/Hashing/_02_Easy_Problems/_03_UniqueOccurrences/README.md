# Unique Occurrences

**Problem**: Check if all frequency counts are unique.

**Core Concept**:
- Count frequency of each element using HashMap
- Store frequencies in HashSet
- If duplicate frequency found → return false

**Example**:
```
arr = [1,2,2,1,1,3]
Frequencies: {1→3, 2→2, 3→1}
All unique → true

arr = [1,2]
Frequencies: {1→1, 2→1}
Duplicate frequency → false
```

**Complexity**:
- Time: O(n) - count + check frequencies
- Space: O(n) - HashMap + HashSet

**Code**:
```java
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : arr) freq.put(num, freq.getOrDefault(num, 0) + 1);

HashSet<Integer> set = new HashSet<>();
for (int count : freq.values()) {
    if (!set.add(count)) return false;
}
return true;
```
