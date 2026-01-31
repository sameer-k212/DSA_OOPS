# Celebrity Problem

## 📝 Problem
Find celebrity: everyone knows them, they know no one

## 💡 Core Concept
- Use stack to eliminate non-celebrities
- If A knows B → A not celebrity
- If A doesn't know B → B not celebrity
- Verify final candidate

## 🔄 Example
```
Matrix:
  0 1 2
0[0 1 0]
1[0 0 0]  → Person 1 is celebrity
2[0 1 0]

Row 1: all 0s (knows no one)
Col 1: all 1s except [1][1] (everyone knows them)
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static int findCelebrity(int[][] matrix) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < matrix.length; i++) stack.push(i);
    
    while (stack.size() > 1) {
        int a = stack.pop(), b = stack.pop();
        if (matrix[a][b] == 1) stack.push(b);
        else stack.push(a);
    }
    
    int candidate = stack.pop();
    for (int i = 0; i < matrix.length; i++) {
        if (i != candidate && (matrix[candidate][i] == 1 || matrix[i][candidate] == 0)) {
            return -1;
        }
    }
    return candidate;
}
```
