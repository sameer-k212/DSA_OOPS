# Four Sum (4Sum)

**Problem**: Find all unique quadruplets that sum to target.

**Core Concept**:
- Sort array first
- Fix two elements with nested loops
- Use two pointers for remaining two elements
- Skip duplicates to avoid duplicate quadruplets

**Example**:
```
nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
```

**Complexity**:
- Time: O(n³) - two loops + two pointers
- Space: O(1) - excluding output

**Code**:
```java
Arrays.sort(nums);
for (int i = 0; i < n-3; i++) {
    if (i > 0 && nums[i] == nums[i-1]) continue;
    for (int j = i+1; j < n-2; j++) {
        if (j > i+1 && nums[j] == nums[j-1]) continue;
        int left = j+1, right = n-1;
        // Two pointer logic
    }
}
```
