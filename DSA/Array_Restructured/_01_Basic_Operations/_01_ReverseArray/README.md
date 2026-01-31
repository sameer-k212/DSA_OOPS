# Reverse Array

## 📝 Problem
Reverse array in-place using two pointers

## 💡 Core Concept
- Two pointers: left=0, right=n-1
- Swap and move inward until left >= right

## 🔄 Example
```
[2, 4, 6, 8, 10] → [10, 8, 6, 4, 2]
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static void reverse(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}
```
