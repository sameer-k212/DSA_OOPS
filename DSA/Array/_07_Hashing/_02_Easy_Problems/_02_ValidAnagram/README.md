# Valid Anagram

**Problem**: Check if two strings are anagrams (same characters, different order).

**Core Concept**:
- Count frequency of each character
- Compare frequency arrays
- If lengths differ → not anagram

**Example**:
```
s = "anagram", t = "nagaram" → true
s = "rat", t = "car" → false
```

**Complexity**:
- Time: O(n) - two passes through strings
- Space: O(26) = O(1) - fixed size array

**Code**:
```java
if (s.length() != t.length()) return false;
int[] freq = new int[26];
for (char ch : s.toCharArray()) freq[ch - 'a']++;
for (char ch : t.toCharArray()) freq[ch - 'a']--;
for (int count : freq) if (count != 0) return false;
return true;
```
