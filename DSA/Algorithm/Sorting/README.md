# Sorting Algorithms

## Common Sorting Algorithms

### 1. Bubble Sort
- **Time**: O(n²)
- **Space**: O(1)
- Stable, simple

### 2. Selection Sort
- **Time**: O(n²)
- **Space**: O(1)
- Not stable

### 3. Insertion Sort
- **Time**: O(n²), O(n) best
- **Space**: O(1)
- Stable, good for small/nearly sorted

### 4. Merge Sort
- **Time**: O(n log n)
- **Space**: O(n)
- Stable, divide and conquer

### 5. Quick Sort
- **Time**: O(n log n) avg, O(n²) worst
- **Space**: O(log n)
- Not stable, in-place

### 6. Heap Sort
- **Time**: O(n log n)
- **Space**: O(1)
- Not stable, in-place

### 7. Counting Sort
- **Time**: O(n + k)
- **Space**: O(k)
- For integers in range

## When to Use
- **Small data**: Insertion Sort
- **Nearly sorted**: Insertion Sort
- **Stable needed**: Merge Sort
- **In-place needed**: Quick Sort, Heap Sort
- **Guaranteed O(n log n)**: Merge Sort, Heap Sort
