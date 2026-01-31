# Check Sorted and Rotated

## 📝 Problem
Check if array is sorted and rotated

## 💡 Core Concept
- Count breaks where arr[i-1] > arr[i]
- Check if last > first (circular break)
- Valid if breaks ≤ 1

## 🔄 Example
```
[3,4,5,1,2] → true (1 break at 5→1)
[2,1,3,4] → false (2 breaks)
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static boolean check(int[] arr) {
    int count = 0;
    for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] > arr[i]) count++;
    }
    if (arr[arr.length - 1] > arr[0]) count++;
    return count <= 1;
}
```
