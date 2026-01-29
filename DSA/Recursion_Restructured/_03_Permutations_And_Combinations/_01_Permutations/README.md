# Permutations

## 📝 Problem
All arrangements: [1,2,3] → [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]

## 💡 Core Concept
- **Base Case**: current.length = n → add result
- **Recursive**: Try each unused element
- **Backtracking**: Choose → Explore → Unchoose
- **Pattern**: State tracking with boolean array

## 🔄 Recursion Tree
```
                    perm("", [F,F,F])
            /           |           \
         Choose 1    Choose 2    Choose 3
           /             |             \
    perm("1",[T,F,F]) perm("2",[F,T,F]) perm("3",[F,F,T])
      /        \         /        \         /        \
   Choose 2  Choose 3  Choose 1  Choose 3  Choose 1  Choose 2
     /          \        /          \        /          \
perm("12",   perm("13", perm("21", perm("23", perm("31", perm("32",
[T,T,F])     [T,F,T])   [T,T,F])   [F,T,T])  [T,F,T])  [F,T,T])
   |            |          |          |          |          |
 "123"        "132"      "213"      "231"      "312"      "321"
```

## ⚡ Complexity
- **Time**: O(n! × n) - n! permutations, O(n) to build each
- **Space**: O(n) - recursion depth + boolean array

## 🎯 Key Points
- Track used elements with boolean array
- Backtrack: mark used → recurse → mark unused
- Total permutations = n!
- Order matters (unlike combinations)

## 💻 Implementation

### Array Permutations
```java
public static void permutationsArray(int[] arr, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == arr.length) {
        result.add(new ArrayList<>(current));
        return;
    }

    for (int i = 0; i < arr.length; i++) {
        if (current.contains(arr[i])) {
            continue;
        }
        
        current.add(arr[i]);
        permutationsArray(arr, current, result);
        current.remove(current.size() - 1);
    }
}
```

### String Permutations
```java
private static void permutedString(String s, List<String> ans, String curr) {
    if (curr.length() == s.length()) {
        ans.add(curr);
        return;
    }

    for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);

        if (curr.contains(String.valueOf(ch))) continue;

        permutedString(s, ans, curr + ch);
    }
}
```