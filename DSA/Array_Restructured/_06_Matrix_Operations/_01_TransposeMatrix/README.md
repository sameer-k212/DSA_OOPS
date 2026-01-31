# Transpose Matrix

## 📝 Problem
Convert rows to columns and columns to rows

## 💡 Core Concept
- Create new matrix with swapped dimensions
- result[j][i] = matrix[i][j]

## 🔄 Example
```
[[1,2,3],     [[1,4],
 [4,5,6]]  →   [2,5],
               [3,6]]
```

## ⚡ Complexity
- **Time**: O(m×n)
- **Space**: O(m×n)

## 💻 Code
```java
public static int[][] transpose(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] result = new int[cols][rows];
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
        }
    }
    return result;
}
```
