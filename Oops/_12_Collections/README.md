# Collections Framework

## Concept
Framework providing architecture to store and manipulate groups of objects.

## Hierarchy
```
Collection
├── List (Ordered, allows duplicates)
│   ├── ArrayList
│   ├── LinkedList
│   └── Vector
├── Set (Unordered, no duplicates)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
└── Queue (FIFO)
    ├── PriorityQueue
    └── ArrayDeque

Map (Key-Value pairs)
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable
```

## Folders
- `CollectionsAndCollection/` - Collections vs Collection

## Files
- `Arraylist.java` - ArrayList operations
- `Hashset.java` - HashSet operations
- `Hashmap.java` - HashMap operations
- `Treemap.java`, `Treeset.java` - Sorted collections
- `Linkedhashmap.java`, `Linkedhashset.java` - Insertion order
- `Priorityqueue.java` - Priority queue
- `Arraydeque.java` - Double-ended queue
- `iterator.java` - Iterator usage
- `Demo.java`, `ListDemo.java`, `map.java` - Various examples

## Example
```java
// ArrayList
List<String> list = new ArrayList<>();
list.add("Java");
list.add("Python");

// HashMap
Map<Integer, String> map = new HashMap<>();
map.put(1, "One");
map.put(2, "Two");

// HashSet
Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
```
