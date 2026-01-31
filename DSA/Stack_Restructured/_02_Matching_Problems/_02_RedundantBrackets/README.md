# Redundant Brackets

## 📝 Problem
Check if expression has redundant (useless) brackets

## 💡 Core Concept
- Push operators and '('
- On ')', check if any operator between brackets
- If no operator → redundant

## 🔄 Example
```
"((a+b))" → Redundant (outer brackets useless)
"(a+(b*c))" → Not redundant
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static boolean hasRedundant(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || isOperator(c)) {
            stack.push(c);
        } else if (c == ')') {
            boolean hasOp = false;
            while (stack.peek() != '(') {
                if (isOperator(stack.pop())) hasOp = true;
            }
            if (!hasOp) return true;
            stack.pop();
        }
    }
    return false;
}
```
