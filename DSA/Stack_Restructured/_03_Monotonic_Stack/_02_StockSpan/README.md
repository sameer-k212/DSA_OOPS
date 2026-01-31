# Stock Span Problem

## 📝 Problem
Find span of stock prices (consecutive days ≤ current price)

## 💡 Core Concept
- Monotonic stack stores indices
- Pop smaller/equal prices
- Span = current index - previous greater index

## 🔄 Example
```
Prices: [100,80,60,70,60,75,85]
Span:   [1,  1, 1, 2, 1, 4, 6]

Day 5 (75): prices ≤ 75 are [60,70,60,75] → span=4
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static int[] calculateSpan(int[] prices) {
    int n = prices.length;
    int[] span = new int[n];
    Stack<Integer> stack = new Stack<>();
    
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
            stack.pop();
        }
        span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
        stack.push(i);
    }
    return span;
}
```
