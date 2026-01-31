# Frequency Count

## 📝 Problem
Count frequency of each element in array

## 💡 Core Concept
- Use HashMap to store element → count
- Iterate and update frequency

## 🔄 Example
```
[1,1,1,2,2,3] → {1:3, 2:2, 3:1}
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static Map<Integer, Integer> countFrequency(int[] arr) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : arr) {
        freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    return freq;
}
```
