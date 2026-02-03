# Binary Search

## Algorithm
Divide and conquer search on sorted array.

## Approach
1. Find middle element
2. If target == mid, return
3. If target < mid, search left half
4. If target > mid, search right half

## Template
```java
int left = 0, right = n - 1;
while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
return -1;
```

## Complexity
- **Time**: O(log n)
- **Space**: O(1) iterative, O(log n) recursive

## Key Points
- Array must be sorted
- Use `left + (right - left) / 2` to avoid overflow
- Condition: `left <= right`

## Variations
- Lower bound (first occurrence)
- Upper bound (last occurrence)
- Search in rotated array
