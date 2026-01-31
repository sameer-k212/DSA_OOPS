# Two Sum

## 📝 Problem
Find two numbers that add up to target

## 💡 Core Concept
- Use HashMap to store complement
- For each element, check if complement exists

## 🔄 Example
```
[2,7,11,15], target=9
2: complement=7, not found, store 2
7: complement=2, found! → [0,1]
```

## ⚡ Complexity
- **Time**: O(n)
- **Space**: O(n)

## 💻 Code
```java
public static int[] twoSum(int[] arr, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
        int complement = target - arr[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(arr[i], i);
    }
    return new int[]{};
}
```
