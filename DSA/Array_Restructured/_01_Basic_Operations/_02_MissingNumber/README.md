# Missing Number

## 📝 Problem
Find missing number in array [0, n]

## 💡 Core Concept
- Formula: Sum(0 to n) = n×(n+1)/2
- Missing = Expected - Actual

## 🔄 Example
```
[3,0,1] → Missing = 2
Expected = 3×4/2 = 6
Actual = 3+0+1 = 4
Missing = 6-4 = 2
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static int findMissing(int[] arr) {
    int n = arr.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : arr) actualSum += num;
    return expectedSum - actualSum;
}
```
