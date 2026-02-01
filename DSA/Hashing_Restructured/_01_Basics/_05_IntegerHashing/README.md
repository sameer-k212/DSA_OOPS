# Integer Hashing

**Problem**: Count frequency of integers using array (for small range).

**Core Concept**:
- Use array where index = element value
- Pre-compute frequencies in O(n)
- Answer queries in O(1)

**Example**:
```
arr = [1, 2, 2, 3, 1]
hash[1] = 2, hash[2] = 2, hash[3] = 1
```

**Complexity**:
- Time: O(n) pre-computation, O(1) per query
- Space: O(max_value) - array size

**Code**:
```java
int[] hash = new int[1000];
for (int num : arr) {
    hash[num]++;
}
// Query: hash[num]
```

**Note**: Use HashMap for large values or negative numbers.
