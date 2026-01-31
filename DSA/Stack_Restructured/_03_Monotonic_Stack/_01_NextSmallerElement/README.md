# Next Smaller Element

## 📝 Problem
Find next smaller element to the right for each element

## 💡 Core Concept
- Monotonic increasing stack
- Traverse right to left
- Pop elements ≥ current

## 🔄 Example
```
[4,5,2,10,8] → [2,2,-1,8,-1]

i=4: arr[4]=8, stack=[], result[4]=-1, push 8
i=3: arr[3]=10, pop 8, stack=[], result[3]=-1, push 10
i=2: arr[2]=2, stack=[10], result[2]=-1, push 2
i=1: arr[1]=5, pop 10,2, stack=[], result[1]=2, push 5
i=0: arr[0]=4, stack=[5,2], result[0]=2
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static int[] nextSmaller(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() >= arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(arr[i]);
    }
    return result;
}
```
