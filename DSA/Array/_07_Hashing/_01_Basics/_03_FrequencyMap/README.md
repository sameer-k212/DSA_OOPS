# Frequency Map

**Problem**: Count frequency of each element in an array.

**Core Concept**:
- Use HashMap<Element, Count>
- getOrDefault(key, 0) for counting
- Iterate using entrySet()

**Example**:
```
arr = [1, 2, 2, 3, 1, 1]
Output: {1=3, 2=2, 3=1}
```

**Complexity**:
- Time: O(n) - single pass through array
- Space: O(k) - k unique elements

**Code**:
```java
HashMap<Integer, Integer> freq = new HashMap<>();
for (int num : arr) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
}
```
