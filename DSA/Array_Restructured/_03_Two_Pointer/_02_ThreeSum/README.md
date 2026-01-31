# Three Sum

## 📝 Problem
Find all unique triplets that sum to target

## 💡 Core Concept
- Sort array first
- Fix one element, use two pointers for rest
- Skip duplicates

## 🔄 Example
```
[-1,0,1,2,-1,-4], target=0
Sorted: [-4,-1,-1,0,1,2]
Fix -1: find two numbers summing to 1
Result: [[-1,-1,2], [-1,0,1]]
```

## ⚡ Complexity
- **Time**: O(n²)
- **Space**: O(1)

## 💻 Code
```java
public static List<List<Integer>> threeSum(int[] arr, int target) {
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < arr.length - 2; i++) {
        if (i > 0 && arr[i] == arr[i - 1]) continue;
        int left = i + 1, right = arr.length - 1;
        while (left < right) {
            int sum = arr[i] + arr[left] + arr[right];
            if (sum == target) {
                result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                while (left < right && arr[left] == arr[left + 1]) left++;
                while (left < right && arr[right] == arr[right - 1]) right--;
                left++; right--;
            } else if (sum < target) left++;
            else right--;
        }
    }
    return result;
}
```
