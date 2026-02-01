# Longest Consecutive Sequence

**Problem**: Find length of longest consecutive elements sequence in unsorted array.

**Core Concept**:
- Add all elements to HashSet
- For each element, check if it's start of sequence (num-1 not in set)
- Count consecutive elements from start

**Example**:
```
nums = [100,4,200,1,3,2]
Sequences: [1,2,3,4], [100], [200]
Longest: 4
```

**Complexity**:
- Time: O(n) - each element visited at most twice
- Space: O(n) - HashSet storage

**Code**:
```java
HashSet<Integer> set = new HashSet<>();
for (int num : nums) set.add(num);

int maxLen = 0;
for (int num : set) {
    if (!set.contains(num - 1)) { // Start of sequence
        int curr = num, len = 1;
        while (set.contains(curr + 1)) {
            curr++;
            len++;
        }
        maxLen = Math.max(maxLen, len);
    }
}
```
