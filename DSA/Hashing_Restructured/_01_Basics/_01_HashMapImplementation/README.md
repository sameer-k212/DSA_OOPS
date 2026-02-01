# HashMap Implementation (Custom)

**Problem**: Implement HashMap from scratch using array of linked lists (chaining).

**Core Concept**:
- Array of buckets (linked lists) for collision handling
- Hash function: `key.hashCode() % bucketSize`
- Operations: put(), get(), containsKey()

**Example**:
```
put("key1", 10) → bucket[hash("key1")] → Node("key1", 10)
get("key1") → 10
```

**Complexity**:
- Time: O(1) average, O(n) worst case (all collisions)
- Space: O(n) - n key-value pairs

**Code**:
```java
void put(String key, Integer value) {
    int bn = hashFunc(key);
    Node temp = bucket[bn];
    // Check if key exists, update value
    // Otherwise create new node at bucket head
}
```
