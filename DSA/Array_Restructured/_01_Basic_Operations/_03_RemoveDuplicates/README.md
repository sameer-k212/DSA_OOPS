# Remove Duplicates

## 📝 Problem
Remove duplicates from sorted array in-place

## 💡 Core Concept
- Two pointers: i (unique position), j (scanner)
- Move i only when arr[j] != arr[i]

## 🔄 Example
```
[1,1,2,2,3] → [1,2,3,_,_]
Length = 3
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static int removeDuplicates(int[] arr) {
    if (arr.length == 0) return 0;
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
        if (arr[j] != arr[i]) {
            i++;
            arr[i] = arr[j];
        }
    }
    return i + 1;
}
```
