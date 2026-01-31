# Valid Parentheses

## 📝 Problem
Check if parentheses are valid: (), {}, []

## 💡 Core Concept
- Push opening brackets
- Pop and match closing brackets
- Stack must be empty at end

## 🔄 Example
```
"{[()]}" → Valid
"([)]" → Invalid (wrong order)
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == '}' && top != '{') ||
                (c == ']' && top != '[')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```
