# Merge Sorted Arrays

## 📝 Problem
Merge two sorted arrays into one sorted array

## 💡 Core Concept
- Two pointers for both arrays
- Compare and add smaller element
- Copy remaining elements

## 🔄 Example
```
[1,3,5], [2,4,6] → [1,2,3,4,5,6]
```

## ⚡ Complexity
- **Time**: O(n+m)
- **Space**: O(n+m)

## 💻 Code
```java
public static int[] merge(int[] arr1, int[] arr2) {
    int[] result = new int[arr1.length + arr2.length];
    int i = 0, j = 0, k = 0;
    
    while (i < arr1.length && j < arr2.length) {
        if (arr1[i] <= arr2[j]) result[k++] = arr1[i++];
        else result[k++] = arr2[j++];
    }
    
    while (i < arr1.length) result[k++] = arr1[i++];
    while (j < arr2.length) result[k++] = arr2[j++];
    
    return result;
}
```
