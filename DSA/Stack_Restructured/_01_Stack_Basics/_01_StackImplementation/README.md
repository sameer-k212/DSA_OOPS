# Stack Implementation

## 📝 Problem
Implement stack using array

## 💡 Core Concept
- LIFO: Last In First Out
- Track top pointer
- Operations: push, pop, peek, isEmpty

## 🔄 Example
```
push(1) → [1]
push(2) → [1,2]
push(3) → [1,2,3]
pop() → 3, stack=[1,2]
peek() → 2
```

## ⚡ Complexity
- **Time**: O(1) all operations
- **Space**: O(n)

## 💻 Code
```java
class Stack {
    private int[] arr;
    private int top;
    
    public void push(int x) {
        arr[++top] = x;
    }
    
    public int pop() {
        return arr[top--];
    }
    
    public int peek() {
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
}
```
