# Palindrome Array

## 📝 Problem
Check if array is palindrome

## 💡 Core Concept
- Compare elements from both ends
- If any mismatch → not palindrome

## 🔄 Example
```
[1,2,3,2,1] → true
[1,2,3,4,5] → false
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(1)

## 💻 Code
```java
public static boolean isPalindrome(int[] arr) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
        if (arr[left] != arr[right]) return false;
        left++;
        right--;
    }
    return true;
}
```
