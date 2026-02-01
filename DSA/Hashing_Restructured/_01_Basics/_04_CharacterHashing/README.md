# Character Hashing

**Problem**: Count frequency of characters using array (for lowercase a-z).

**Core Concept**:
- Use array of size 26 for a-z
- Map character to index: `ch - 'a'`
- For uppercase: `ch - 'A'`

**Example**:
```
str = "abcdabcfghyb"
arr[0] = 3 (a appears 3 times)
arr[1] = 3 (b appears 3 times)
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(26) = O(1) - constant space

**Code**:
```java
int[] freq = new int[26];
for (char ch : str.toCharArray()) {
    freq[ch - 'a']++;
}
```
