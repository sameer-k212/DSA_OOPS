# HashSet Implementation

**Problem**: Implement HashSet to store unique elements.

**Core Concept**:
- Uses HashMap internally (value = dummy object)
- Only stores keys, no duplicates
- Operations: add(), contains(), remove()

**Example**:
```
add(1) → {1}
add(2) → {1, 2}
add(1) → {1, 2} (no duplicate)
```

**Complexity**:
- Time: O(1) average for add/contains/remove
- Space: O(n) - n unique elements

**Code**:
```java
HashSet<Integer> set = new HashSet<>();
set.add(1);
set.add(2);
set.contains(1); // true
```
