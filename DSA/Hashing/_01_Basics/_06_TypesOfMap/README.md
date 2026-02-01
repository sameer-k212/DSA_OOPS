# Types of Map in Java

**Problem**: Understand different Map implementations and their use cases.

**Core Concept**:
- **HashMap**: Unordered, O(1) operations
- **LinkedHashMap**: Maintains insertion order, O(1) operations
- **TreeMap**: Sorted by keys, O(log n) operations

**Example**:
```
Input: put(4,"A"), put(2,"B"), put(9,"C")

HashMap: {2=B, 4=A, 9=C} (random order)
LinkedHashMap: {4=A, 2=B, 9=C} (insertion order)
TreeMap: {2=B, 4=A, 9=C} (sorted order)
```

**Complexity**:
| Operation | HashMap | LinkedHashMap | TreeMap |
|-----------|---------|---------------|---------|
| put/get   | O(1)    | O(1)          | O(log n)|
| Space     | O(n)    | O(n)          | O(n)    |

**Code**:
```java
HashMap<Integer, String> map = new HashMap<>();
LinkedHashMap<Integer, String> lmap = new LinkedHashMap<>();
TreeMap<Integer, String> tmap = new TreeMap<>();
```
