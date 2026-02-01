# Group Anagrams

**Problem**: Group strings that are anagrams of each other.

**Core Concept**:
- Sort each string to create a key
- Anagrams will have same sorted key
- Use HashMap<sortedKey, List<originalStrings>>

**Example**:
```
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

"eat" sorted → "aet"
"tea" sorted → "aet" (same key)
```

**Complexity**:
- Time: O(n * k log k) - n strings, k = max length
- Space: O(n * k) - store all strings

**Code**:
```java
HashMap<String, List<String>> map = new HashMap<>();
for (String str : strs) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    String key = new String(chars);
    map.putIfAbsent(key, new ArrayList<>());
    map.get(key).add(str);
}
return new ArrayList<>(map.values());
```
