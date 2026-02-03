# Segment Tree - Complete Guide

## 📚 What is Segment Tree?

A tree data structure for storing intervals/segments. Allows querying which segments contain a given point efficiently.

## 🎯 When to Use?

Use Segment Tree when you need:
- **Range queries** (sum, min, max, gcd, etc.)
- **Point/Range updates**
- **Both operations in O(log n)**

## 📂 Folder Structure

### _01_BasicSegmentTree
- Point update, range query
- Foundation implementation
- Sum queries

### _02_RangeSumQuery
- LeetCode 307 solution
- Mutable range sum
- Interview problem

### _03_LazyPropagation
- Range updates in O(log n)
- Delayed propagation
- Advanced technique

### _04_RangeMinQuery
- Range minimum queries
- Can be adapted for max, gcd, etc.

---

## 🔑 Core Concepts

### Tree Structure
```
Array size: n
Tree size: 4 * n (safe allocation)
Node indexing:
- Left child: 2 * i + 1
- Right child: 2 * i + 2
- Parent: (i - 1) / 2
```

### Three Cases in Query
1. **No Overlap**: Return identity (0 for sum, INF for min)
2. **Complete Overlap**: Return tree[node]
3. **Partial Overlap**: Query both children

---

## 💡 Templates

### Basic Segment Tree (Sum)
```java
class SegmentTree {
    int[] tree;
    
    void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2*node+1, start, mid);
        build(arr, 2*node+2, mid+1, end);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    
    int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(2*node+1, start, mid, l, r) + 
               query(2*node+2, mid+1, end, l, r);
    }
    
    void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2*node+1, start, mid, idx, val);
        else update(2*node+2, mid+1, end, idx, val);
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
}
```

### Lazy Propagation Template
```java
void push(int node, int start, int end) {
    if (lazy[node] != 0) {
        tree[node] += (end - start + 1) * lazy[node];
        if (start != end) {
            lazy[2*node+1] += lazy[node];
            lazy[2*node+2] += lazy[node];
        }
        lazy[node] = 0;
    }
}

void updateRange(int node, int start, int end, int l, int r, int val) {
    push(node, start, end);
    if (r < start || l > end) return;
    if (l <= start && end <= r) {
        lazy[node] += val;
        push(node, start, end);
        return;
    }
    int mid = (start + end) / 2;
    updateRange(2*node+1, start, mid, l, r, val);
    updateRange(2*node+2, mid+1, end, l, r, val);
    push(2*node+1, start, mid);
    push(2*node+2, mid+1, end);
    tree[node] = tree[2*node+1] + tree[2*node+2];
}
```

---

## ⚡ Complexity Analysis

| Operation | Without Lazy | With Lazy |
|-----------|-------------|-----------|
| Build | O(n) | O(n) |
| Point Update | O(log n) | O(log n) |
| Range Update | O(n log n) | O(log n) |
| Query | O(log n) | O(log n) |
| Space | O(4n) | O(8n) |

---

## 🎯 Common Problems

### Easy
1. Range Sum Query - Mutable (LeetCode 307)
2. Range Minimum Query
3. Count of Range Sum

### Medium
1. Range Sum Query 2D - Mutable
2. My Calendar I, II, III
3. Falling Squares

### Hard
1. Count of Smaller Numbers After Self
2. Reverse Pairs
3. Range Module

---

## 🔄 Variations

### By Operation
- **Sum**: `tree[node] = left + right`
- **Min**: `tree[node] = min(left, right)`
- **Max**: `tree[node] = max(left, right)`
- **GCD**: `tree[node] = gcd(left, right)`
- **OR**: `tree[node] = left | right`
- **AND**: `tree[node] = left & right`

### By Update Type
- **Point Update**: Update single element
- **Range Update**: Update range of elements (needs lazy)
- **Set Update**: Set all elements in range to value
- **Add Update**: Add value to all elements in range

---

## 💭 Interview Tips

1. **Clarify operation**: Sum, min, max, or custom?
2. **Update type**: Point or range?
3. **Space constraint**: Can you use 4n space?
4. **Alternative**: Consider Fenwick Tree for sum queries

---

## 🚀 When NOT to Use

- **Only point queries**: Use array
- **Only range queries, no updates**: Use prefix sum
- **Only sum queries with updates**: Consider Fenwick Tree (simpler)
- **2D range queries**: Consider 2D Fenwick Tree or Sparse Table

---

## 📊 Comparison with Alternatives

| Data Structure | Build | Query | Update | Space |
|---------------|-------|-------|--------|-------|
| Array | O(1) | O(n) | O(1) | O(n) |
| Prefix Sum | O(n) | O(1) | O(n) | O(n) |
| Segment Tree | O(n) | O(log n) | O(log n) | O(4n) |
| Fenwick Tree | O(n) | O(log n) | O(log n) | O(n) |

---

## 🎓 Learning Path

1. **Week 1**: Basic segment tree (sum queries)
2. **Week 2**: Different operations (min, max, gcd)
3. **Week 3**: Lazy propagation
4. **Week 4**: Advanced problems and variations

---

## 🔗 Related Topics

- Fenwick Tree (Binary Indexed Tree)
- Sparse Table
- Square Root Decomposition
- Merge Sort Tree

---

**Master segment trees for efficient range query problems!** 🌲
