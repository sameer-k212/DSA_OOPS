# Hashing - Complete Guide

## 📚 Folder Structure

### 01. Basics (6 problems)
- HashMap Implementation (Custom)
- HashSet Implementation
- Frequency Map
- Character Hashing
- Integer Hashing
- Types of Map (HashMap, LinkedHashMap, TreeMap)

### 02. Easy Problems (6 problems)
- Two Sum
- Valid Anagram
- Unique Occurrences
- Intersection of Two Arrays
- Contains Duplicate
- First Unique Character

### 03. Medium Problems (7 problems)
- Longest Substring with Even Vowels
- Subarray with Equal 0s and 1s
- Array of Doubled Pairs
- Group Anagrams
- Subarray Sum Equals K
- Longest Consecutive Sequence
- Four Sum (4Sum)

### 04. Hard Problems (3 problems)
- Same Difference (Codeforces)
- Subarray with Zero Sum
- Longest Subarray with Sum K

---

## 🎯 Key Concepts

**HashMap**: O(1) average time, unordered
**LinkedHashMap**: O(1) time, maintains insertion order
**TreeMap**: O(log n) time, sorted by keys
**HashSet**: Stores unique elements only

---

## ⚡ Common Patterns

1. **Frequency Counting**: Use `map.getOrDefault(key, 0) + 1`
2. **Two Sum Pattern**: Store complement in map
3. **Prefix Sum + HashMap**: For subarray problems
4. **Bitmask + HashMap**: For state tracking
5. **Sorted Key**: Group anagrams by sorted string
6. **HashSet for Sequences**: Find consecutive elements

---

## 📊 Time Complexities

| Operation | HashMap | TreeMap |
|-----------|---------|---------|
| put/get   | O(1)    | O(log n)|
| remove    | O(1)    | O(log n)|
| containsKey| O(1)   | O(log n)|

---

**Total Problems**: 22
**Difficulty**: Basics → Easy → Medium → Hard
