# Intersection of Two Arrays

**Problem**: Find common elements between two arrays (with duplicates).

**Core Concept**:
- Count frequency of arr1 elements in HashMap
- For each arr2 element, check if exists in map
- If exists and count > 0, add to result and decrement

**Example**:
```
arr1 = [1,2,2,1], arr2 = [2,2]
Output: [2,2]

arr1 = [4,9,5], arr2 = [9,4,9,8,4]
Output: [4,9]
```

**Complexity**:
- Time: O(m + n) - traverse both arrays
- Space: O(min(m,n)) - HashMap size

**Code**:
```java
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : arr1) map.put(num, map.getOrDefault(num, 0) + 1);

List<Integer> result = new ArrayList<>();
for (int num : arr2) {
    if (map.getOrDefault(num, 0) > 0) {
        result.add(num);
        map.put(num, map.get(num) - 1);
    }
}
```
