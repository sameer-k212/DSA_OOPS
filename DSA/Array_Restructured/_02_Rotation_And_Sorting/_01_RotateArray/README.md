# Rotate Array

## 📝 Problem
Rotate array right by k positions

## 💡 Core Concept
- Reverse entire array
- Reverse first k elements
- Reverse remaining elements

## 🔄 Example
```
[1,2,3,4,5], k=2
Step 1: [5,4,3,2,1]
Step 2: [4,5,3,2,1]
Step 3: [4,5,1,2,3]
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static void rotateRight(int[] arr, int k) {
    k = k % arr.length;
    reverse(arr, 0, arr.length - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, arr.length - 1);
}
```
