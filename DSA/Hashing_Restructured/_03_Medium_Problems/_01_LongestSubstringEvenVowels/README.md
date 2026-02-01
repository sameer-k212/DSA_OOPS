# Longest Substring with Even Vowels

**Problem**: Find longest substring where all vowels (a,e,i,o,u) appear even number of times.

**Core Concept**:
- Use bitmask to track odd/even state of each vowel
- XOR toggles bit: even→odd, odd→even
- If same state seen before → substring between has even vowels

**Example**:
```
s = "eleetminicoworoep"
Output: 13 ("leetminicowor")
```

**Complexity**:
- Time: O(n) - single pass
- Space: O(32) = O(1) - max 32 states (2^5)

**Code**:
```java
HashMap<Integer, Integer> stateMap = new HashMap<>();
stateMap.put(0, -1);
int state = 0, maxLen = 0;
for (int i = 0; i < s.length(); i++) {
    if (vowel) state ^= (1 << vowelIndex);
    if (stateMap.containsKey(state)) {
        maxLen = Math.max(maxLen, i - stateMap.get(state));
    } else stateMap.put(state, i);
}
```
