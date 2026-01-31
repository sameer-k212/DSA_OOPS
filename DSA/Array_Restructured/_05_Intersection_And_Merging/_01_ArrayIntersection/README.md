# Array Intersection

## 📝 Problem
Find common elements between two arrays

## 💡 Core Concept
- Store first array in HashSet
- Check second array elements in set
- Add to result if found

## 🔄 Example
```
[1,2,2,4,3], [3,3,6,1] → [1,3]
```

## ⚡ Complexity
- **Time**: O(n+m)
- **Space**: O(n)

## 💻 Code
```java
public static List<Integer> intersection(int[] arr1, int[] arr2) {
    Set<Integer> set1 = new HashSet<>();
    for (int num : arr1) set1.add(num);
    
    Set<Integer> result = new HashSet<>();
    for (int num : arr2) {
        if (set1.contains(num)) result.add(num);
    }
    return new ArrayList<>(result);
}
```
