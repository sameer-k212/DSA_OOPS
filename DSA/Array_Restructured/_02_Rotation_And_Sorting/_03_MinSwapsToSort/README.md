# Minimum Swaps to Sort

## 📝 Problem
Find minimum swaps needed to sort array

## 💡 Core Concept
- Clone and sort array to get target
- Use HashMap to track positions
- Swap elements to correct positions

## 🔄 Example
```
[4,3,2,1] → 2 swaps
Swap 4↔1: [1,3,2,4]
Swap 3↔2: [1,2,3,4]
```

## ⚡ Complexity
- **Time**: O(n log n)
- **Space**: O(n)

## 💻 Code
```java
public static int minSwaps(int[] arr) {
    int n = arr.length;
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    
    Map<Integer, Integer> pos = new HashMap<>();
    for (int i = 0; i < n; i++) {
        pos.put(arr[i], i);
    }
    
    int swaps = 0;
    for (int i = 0; i < n; i++) {
        if (arr[i] != sorted[i]) {
            swaps++;
            int curPos = pos.get(sorted[i]);
            pos.put(arr[i], curPos);
            arr[curPos] = arr[i];
        }
    }
    return swaps;
}
```
