# First Unique Character in String

**Problem**: Find index of first non-repeating character in string.

**Core Concept**:
- Count frequency of all characters
- Iterate string again, return first char with freq = 1
- Two-pass solution

**Example**:
```
s = "leetcode" → 0 (l appears once)
s = "loveleetcode" → 2 (v appears once)
s = "aabb" → -1 (no unique char)
```

**Complexity**:
- Time: O(n) - two passes through string
- Space: O(26) = O(1) - at most 26 lowercase letters

**Code**:
```java
HashMap<Character, Integer> freq = new HashMap<>();
for (char ch : s.toCharArray()) {
    freq.put(ch, freq.getOrDefault(ch, 0) + 1);
}
for (int i = 0; i < s.length(); i++) {
    if (freq.get(s.charAt(i)) == 1) return i;
}
return -1;
```
