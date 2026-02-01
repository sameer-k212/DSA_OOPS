# Array of Doubled Pairs

**Problem**: Check if array can be reordered such that arr[2*i+1] = 2 * arr[2*i].

**Core Concept**:
- Sort array to process smaller values first
- Use HashMap to track frequencies
- For each element, find its pair (x*2 or x/2)
- Handle negatives: pair is x/2 (not x*2)

**Example**:
```
arr = [4,-2,2,-4]
Sorted: [-4,-2,2,4]
Pairs: (-4,-2), (2,4) → true

arr = [1,2,4,16,8,4]
Pairs: (1,2), (4,8), (4,16) → false
```

**Complexity**:
- Time: O(n log n) - sorting
- Space: O(n) - HashMap

**Code**:
```java
Arrays.sort(arr);
HashMap<Integer, Integer> map = new HashMap<>();
for (int num : arr) map.put(num, map.getOrDefault(num, 0) + 1);

for (int num : arr) {
    if (map.get(num) == 0) continue;
    int pair = (num < 0) ? num/2 : num*2;
    if (!map.containsKey(pair) || map.get(pair) == 0) return false;
    map.put(num, map.get(num) - 1);
    map.put(pair, map.get(pair) - 1);
}
```
