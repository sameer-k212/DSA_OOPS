# Array - Complete Guide

## 📚 All Problems Covered (16 Problems)

---

## 1️⃣ Basic Operations (5 Problems) - Easy

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Reverse Array](./_01_Basic_Operations/_01_ReverseArray) | O(n) | O(1) | Two Pointer |
| 02 | [Missing Number](./_01_Basic_Operations/_02_MissingNumber) | O(n) | O(1) | Math Formula |
| 03 | [Remove Duplicates](./_01_Basic_Operations/_03_RemoveDuplicates) | O(n) | O(1) | Two Pointer |
| 04 | [Palindrome Array](./_01_Basic_Operations/_04_PalindromeArray) | O(n) | O(1) | Two Pointer |
| 05 | [Frequency Count](./_01_Basic_Operations/_05_FrequencyCount) | O(n) | O(n) | HashMap |

**Time**: 30 min

---

## 2️⃣ Rotation & Sorting (3 Problems) - Easy-Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Rotate Array](./_02_Rotation_And_Sorting/_01_RotateArray) | O(n) | O(1) | Reversal |
| 02 | [Check Sorted Rotated](./_02_Rotation_And_Sorting/_02_CheckSortedRotated) | O(n) | O(1) | Count Breaks |
| 03 | [Min Swaps to Sort](./_02_Rotation_And_Sorting/_03_MinSwapsToSort) | O(n log n) | O(n) | HashMap |

**Time**: 30 min

---

## 3️⃣ Two Pointer (3 Problems) - Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Two Sum](./_03_Two_Pointer/_01_TwoSum) | O(n) | O(n) | HashMap |
| 02 | [Three Sum](./_03_Two_Pointer/_02_ThreeSum) | O(n²) | O(1) | Sort + Two Pointer |
| 03 | [Trapping Rain Water](./_03_Two_Pointer/_03_TrappingRainWater) | O(n) | O(1) | Two Pointer + Max |

**Time**: 45 min

---

## 4️⃣ Array Manipulation (2 Problems) - Medium-Hard

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Next Permutation](./_04_Array_Manipulation/_01_NextPermutation) | O(n) | O(1) | Lexicographic |
| 02 | [Product Except Self](./_04_Array_Manipulation/_02_ProductExceptSelf) | O(n) | O(1) | Prefix/Suffix |

**Time**: 30 min

---

## 5️⃣ Intersection & Merging (3 Problems) - Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Array Intersection](./_05_Intersection_And_Merging/_01_ArrayIntersection) | O(n+m) | O(n) | HashSet |
| 02 | [Merge Sorted Arrays](./_05_Intersection_And_Merging/_02_MergeArrays) | O(n+m) | O(n+m) | Two Pointer |
| 03 | [Merge Alternately](./_05_Intersection_And_Merging/_03_MergeAlternately) | O(n+m) | O(n+m) | Two Pointer |

**Time**: 30 min

---

## 6️⃣ Matrix Operations (1 Problem) - Easy

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | [Transpose Matrix](./_06_Matrix_Operations/_01_TransposeMatrix) | O(m×n) | O(m×n) | Row↔Column |

**Time**: 15 min

---

## 🎯 Quick Revision (3 Hours Total)

### Day 1: Basics (1 hour)
1. Read Basic + Rotation READMEs (30 min)
2. Code 4 problems (30 min)

### Day 2: Two Pointer (1 hour)
1. Read Two Pointer READMEs (15 min)
2. Code all 3 problems (45 min)

### Day 3: Advanced (1 hour)
1. Read remaining READMEs (30 min)
2. Code 3 problems (30 min)

---

## 📊 Pattern Recognition

| Pattern | When to Use | Problems |
|---------|-------------|----------|
| **Two Pointer** | Sorted array, pairs | Reverse, Two Sum, Three Sum |
| **HashMap** | Frequency, complement | Two Sum, Frequency, Intersection |
| **Math Formula** | Sum, product patterns | Missing Number, Product Except Self |
| **Reversal** | Rotation problems | Rotate Array |

---

## ⚡ Complexity Cheat Sheet

| Time | Operations |
|------|------------|
| O(1) | Array access, swap |
| O(n) | Single pass, two pointer |
| O(n²) | Nested loops, 3Sum |
| O(n+m) | Merge, intersection |
| O(m×n) | Matrix operations |

---

## 🚀 Interview Tips

### Always Ask:
- Array sorted?
- Duplicates allowed?
- In-place modification?
- Empty array handling?

### Common Patterns:
- Two pointer for sorted arrays
- HashMap for O(1) lookup
- Prefix/suffix for products
- Reversal for rotation

### Edge Cases:
- Empty array []
- Single element [1]
- All same [5,5,5]
- Negative numbers

---

## 📝 Problem Solving Template

```java
public static returnType solve(int[] arr) {
    // 1. Edge cases
    if (arr == null || arr.length == 0) return default;
    
    // 2. Initialize
    int left = 0, right = arr.length - 1;
    
    // 3. Process
    while (left < right) {
        // logic
    }
    
    // 4. Return
    return result;
}
```

---

**Total Problems**: 16  
**Total Time**: ~3 hours  
**All Original Problems Covered**: ✅
