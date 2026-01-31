# Next Permutation

## 📝 Problem
Find next lexicographically greater permutation

## 💡 Core Concept
1. Find pivot (first decreasing from right)
2. Find smallest element > pivot from right
3. Swap and reverse suffix

## 🔄 Example
```
[1,2,3] → [1,3,2]
[2,1,5,4,3,0,0] → [2,3,0,0,1,4,5]
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static void nextPermutation(int[] arr) {
    int pivot = -1;
    for (int i = arr.length - 2; i >= 0; i--) {
        if (arr[i] < arr[i + 1]) {
            pivot = i;
            break;
        }
    }
    if (pivot == -1) {
        reverse(arr, 0, arr.length - 1);
        return;
    }
    for (int i = arr.length - 1; i > pivot; i--) {
        if (arr[i] > arr[pivot]) {
            swap(arr, i, pivot);
            break;
        }
    }
    reverse(arr, pivot + 1, arr.length - 1);
}
```
