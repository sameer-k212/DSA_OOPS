# Same Difference (Codeforces)

**Problem**: Count pairs (i,j) where i < j and arr[j] - arr[i] = j - i.

**Core Concept**:
- Rearrange: arr[j] - arr[i] = j - i
- Transform: arr[j] - j = arr[i] - i
- Store (arr[i] - i) in HashMap and count occurrences

**Example**:
```
arr = [3,1,2,5,4]
Transform: [3-0, 1-1, 2-2, 5-3, 4-4] = [3,0,0,2,0]
Pairs with same value: (1,2), (1,4), (2,4) → count = 3
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(n) - HashMap storage

**Code**:
```java
HashMap<Integer, Integer> map = new HashMap<>();
long count = 0;
for (int i = 0; i < n; i++) {
    int key = arr[i] - i;
    count += map.getOrDefault(key, 0);
    map.put(key, map.getOrDefault(key, 0) + 1);
}
```
