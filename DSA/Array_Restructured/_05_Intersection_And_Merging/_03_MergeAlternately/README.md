# Merge Strings Alternately

## 📝 Problem
Merge two strings by alternating characters

## 💡 Core Concept
- Two pointers for both strings
- Alternate between strings
- Append remaining characters

## 🔄 Example
```
"abc", "pqr" → "apbqcr"
"ab", "pqrs" → "apbqrs"
```

## ⚡ Complexity
- **Time**: O(n+m)
- **Space**: O(n+m)

## 💻 Code
```java
public static String merge(String s1, String s2) {
    StringBuilder result = new StringBuilder();
    int i = 0, j = 0;
    
    while (i < s1.length() && j < s2.length()) {
        result.append(s1.charAt(i++));
        result.append(s2.charAt(j++));
    }
    
    while (i < s1.length()) result.append(s1.charAt(i++));
    while (j < s2.length()) result.append(s2.charAt(j++));
    
    return result.toString();
}
```
