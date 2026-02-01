# Contains Duplicate

**Problem**: Check if array contains any duplicate elements.

**Core Concept**:
- Use HashSet to track seen elements
- If element already in set → duplicate found
- HashSet.add() returns false if element exists

**Example**:
```
nums = [1,2,3,1] → true (1 appears twice)
nums = [1,2,3,4] → false (all unique)
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashSet storage

**Code**:
```java
HashSet<Integer> set = new HashSet<>();
for (int num : nums) {
    if (!set.add(num)) return true;
}
return false;
```
