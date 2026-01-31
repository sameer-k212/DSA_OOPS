# Product of Array Except Self

## 📝 Problem
Return array where result[i] = product of all elements except arr[i]

## 💡 Core Concept
- Build left products in result array
- Multiply with right products in second pass
- No division operator

## 🔄 Example
```
[1,2,3,4] → [24,12,8,6]
result[0] = 2×3×4 = 24
result[1] = 1×3×4 = 12
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1) excluding output

## 💻 Code
```java
public static int[] productExceptSelf(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    
    result[0] = 1;
    for (int i = 1; i < n; i++) {
        result[i] = result[i - 1] * arr[i - 1];
    }
    
    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= right;
        right *= arr[i];
    }
    return result;
}
```
