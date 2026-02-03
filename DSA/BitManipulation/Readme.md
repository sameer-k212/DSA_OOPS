# Bit Manipulation - Complete Guide for CP

## 📚 Folder Structure

### _01_Basics
- **_01_BitwiseOperators** - AND, OR, XOR, NOT, Shifts
- **_02_BitOperations** - Get, Set, Clear, Toggle, Update bits

### _02_Basic_Problems
- **_01_CheckPowerOfTwo** - `n & (n-1) == 0`
- **_02_CountSetBits** - Brian Kernighan's algorithm
- **_03_SingleNumber** - XOR to find unique element

### _03_Intermediate_Problems
- **_01_XORQueries** - Prefix XOR for range queries
- **_02_SubsetGeneration** - Generate all subsets using bitmask

### _04_Advanced_Problems
- **_01_MaximumXOR** - Maximum XOR of two numbers
- **_02_MinimumXOR** - Minimize XOR with constraints

---

## 🔑 Key Concepts for CP

### XOR Properties (Most Important!)
```
a ^ a = 0        // Same values cancel
a ^ 0 = a        // Identity
a ^ b ^ a = b    // Commutative
```

### Common Bit Tricks
```java
// Check even/odd
if ((n & 1) == 0) // even

// Multiply/Divide by 2
n << 1  // multiply by 2
n >> 1  // divide by 2

// Check if power of 2
(n & (n-1)) == 0

// Get rightmost set bit
n & -n

// Clear rightmost set bit
n & (n-1)

// Set ith bit
n | (1 << i)

// Clear ith bit
n & ~(1 << i)

// Toggle ith bit
n ^ (1 << i)

// Check if ith bit is set
(n & (1 << i)) != 0
```

---

## 🎯 CP Problem Patterns

### Pattern 1: XOR Cancellation
**Problems**: Single Number, Missing Number
```java
int result = 0;
for (int num : nums) result ^= num;
```

### Pattern 2: Bitmask for Subsets
**Problems**: Subset Generation, Subset Sum
```java
for (int mask = 0; mask < (1 << n); mask++) {
    for (int i = 0; i < n; i++) {
        if ((mask & (1 << i)) != 0) {
            // include nums[i]
        }
    }
}
```

### Pattern 3: Prefix XOR
**Problems**: XOR Queries, Subarray XOR
```java
prefix[i+1] = prefix[i] ^ arr[i];
xor(L, R) = prefix[R+1] ^ prefix[L];
```

### Pattern 4: Greedy Bit Building
**Problems**: Maximum XOR, Minimize XOR
```java
for (int i = 31; i >= 0; i--) {
    // Try to set bit i
}
```

---

## 💡 Interview Tips

### Easy Problems
1. Check Power of Two
2. Count Set Bits
3. Single Number
4. Reverse Bits

### Medium Problems
1. Single Number II (two unique)
2. XOR Queries
3. Subset Generation
4. Divide Two Integers (using bits)

### Hard Problems
1. Maximum XOR of Two Numbers
2. Maximum XOR with Element from Array
3. Minimize XOR
4. Count Triplets with XOR

---

## ⚡ Time Complexity Cheat Sheet

| Operation | Complexity |
|-----------|------------|
| Get/Set/Clear bit | O(1) |
| Count set bits | O(k) where k = set bits |
| Check power of 2 | O(1) |
| XOR all elements | O(n) |
| Generate subsets | O(n * 2^n) |
| Maximum XOR | O(32 * n) = O(n) |

---

## 🚀 Practice Strategy

### Week 1: Basics
- Master all bitwise operators
- Practice get/set/clear/toggle operations
- Solve 10 easy problems

### Week 2: XOR Patterns
- Single Number variations
- XOR queries and prefix XOR
- Missing number problems

### Week 3: Bitmask DP
- Subset generation
- Traveling Salesman (small n)
- Assignment problems

### Week 4: Advanced
- Maximum/Minimum XOR problems
- Trie-based bit problems
- Contest problems

---

## 📝 Common Mistakes

1. **Forgetting parentheses**: `(n & 1) == 0` not `n & 1 == 0`
2. **Negative numbers**: Check `n > 0` for power of 2
3. **Integer overflow**: Use `long` for large shifts
4. **Bit position**: Remember 0-indexed from right
5. **Signed vs unsigned**: Use `>>>` for unsigned right shift

---

## 🏆 Contest Tips

1. **XOR is your friend**: Most bit problems use XOR
2. **Think in binary**: Visualize numbers in binary
3. **Greedy from MSB**: For max/min XOR problems
4. **Bitmask for small n**: When n ≤ 20, consider bitmask
5. **Prefix XOR**: For range XOR queries

---

## 📚 Resources

- **Practice**: LeetCode Bit Manipulation tag
- **Contests**: Codeforces, AtCoder
- **Theory**: CLRS Chapter on Bit Operations

---

**Master these patterns and you'll ace any bit manipulation problem in CP!** 🎯
