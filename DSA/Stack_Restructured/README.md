# Stack - Complete Guide

## 📚 All Problems Covered (7 Problems)

---

## 1️⃣ Stack Basics (2 Problems) - Easy

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Stack Implementation](./_01_Stack_Basics/_01_StackImplementation) | O(1) | O(n) | Array-based |
| 02 | [Stack Using Queues](./_01_Stack_Basics/_02_StackUsingQueues) | O(n)/O(1) | O(n) | Queue Simulation |

**Time**: 20 min

---

## 2️⃣ Matching Problems (2 Problems) - Easy-Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Valid Parentheses](./_02_Matching_Problems/_01_ValidParentheses) | O(n) | O(n) | LIFO Matching |
| 02 | [Redundant Brackets](./_02_Matching_Problems/_02_RedundantBrackets) | O(n) | O(n) | Operator Check |

**Time**: 30 min

---

## 3️⃣ Monotonic Stack (3 Problems) - Medium-Hard

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Next Smaller Element](./_03_Monotonic_Stack/_01_NextSmallerElement) | O(n) | O(n) | Increasing Stack |
| 02 | [Stock Span](./_03_Monotonic_Stack/_02_StockSpan) | O(n) | O(n) | Previous Greater |
| 03 | [Celebrity Problem](./_03_Monotonic_Stack/_03_CelebrityProblem) | O(n) | O(n) | Elimination |

**Time**: 45 min

---

## 🎯 Quick Revision (1.5 Hours Total)

### Day 1: Basics + Matching (45 min)
1. Read Basics + Matching READMEs (20 min)
2. Code all 4 problems (25 min)

### Day 2: Monotonic Stack (45 min)
1. Read Monotonic Stack READMEs (20 min)
2. Code all 3 problems (25 min)

---

## 📊 Pattern Recognition

| Pattern | When to Use | Problems |
|---------|-------------|----------|
| **LIFO Matching** | Nested structures | Valid Parentheses, Redundant Brackets |
| **Monotonic Stack** | Next greater/smaller | Next Smaller, Stock Span |
| **Elimination** | Finding unique element | Celebrity Problem |
| **Queue Simulation** | Stack using queues | Stack Using Queues |

---

## ⚡ Stack Operations

```
push(x)   - O(1) - Add to top
pop()     - O(1) - Remove from top
peek()    - O(1) - View top
isEmpty() - O(1) - Check empty
```

---

## 💡 Monotonic Stack Types

### Increasing Stack (Next Smaller)
```
Pop elements ≥ current
Stack: [1, 3, 5] → valid
```

### Decreasing Stack (Next Greater)
```
Pop elements ≤ current
Stack: [5, 3, 1] → valid
```

---

## 🚀 Interview Tips

### When to Use Stack:
- Matching pairs (parentheses)
- Next greater/smaller element
- Undo operations
- Expression evaluation

### Common Mistakes:
- Not checking isEmpty() before pop
- Wrong traversal direction
- Forgetting to push after processing

### Edge Cases:
- Empty stack
- Single element
- All increasing/decreasing
- Duplicates

---

## 📝 Problem Solving Templates

### Matching Template
```java
public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (isOpening(c)) stack.push(c);
        else {
            if (stack.isEmpty() || !matches(stack.pop(), c)) 
                return false;
        }
    }
    return stack.isEmpty();
}
```

### Monotonic Stack Template
```java
public static int[] nextSmaller(int[] arr) {
    int[] result = new int[arr.length];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = arr.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && stack.peek() >= arr[i]) {
            stack.pop();
        }
        result[i] = stack.isEmpty() ? -1 : stack.peek();
        stack.push(arr[i]);
    }
    return result;
}
```

---

**Total Problems**: 7  
**Total Time**: ~1.5 hours  
**All Original Problems Covered**: ✅
