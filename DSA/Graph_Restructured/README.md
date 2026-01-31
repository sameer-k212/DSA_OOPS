# Graph - Complete Guide

## 📚 All Problems Covered (14 Problems)

---

## 1️⃣ Graph Basics (3 Problems) - Easy

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Graph Representation | O(V+E) | O(V+E) | Adjacency List/Matrix |
| 02 | [BFS](./_01_Graph_Basics/_02_BFS) | O(V+E) | O(V) | Queue Traversal |
| 03 | [DFS](./_01_Graph_Basics/_03_DFS) | O(V+E) | O(V) | Recursive/Stack |

**Time**: 30 min

---

## 2️⃣ BFS/DFS Problems (3 Problems) - Easy-Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Number of Islands | O(m×n) | O(m×n) | DFS/BFS on Grid |
| 02 | Flood Fill | O(m×n) | O(m×n) | DFS/BFS |
| 03 | Number of Provinces | O(V²) | O(V) | Connected Components |

**Time**: 45 min

---

## 3️⃣ Cycle Detection (2 Problems) - Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Cycle in Undirected Graph | O(V+E) | O(V) | DFS/BFS |
| 02 | Cycle in Directed Graph | O(V+E) | O(V) | DFS with Recursion Stack |

**Time**: 30 min

---

## 4️⃣ Topological Sort (2 Problems) - Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Topological Sort DFS | O(V+E) | O(V) | DFS + Stack |
| 02 | Kahn's Algorithm (BFS) | O(V+E) | O(V) | Indegree + Queue |

**Time**: 30 min

---

## 5️⃣ Shortest Path (2 Problems) - Medium

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Shortest Path BFS | O(V+E) | O(V) | BFS for Unweighted |
| 02 | Dijkstra's Algorithm | O(E log V) | O(V) | Priority Queue |

**Time**: 45 min

---

## 6️⃣ MST & Advanced (2 Problems) - Hard

| # | Problem | Time | Space | Concept |
|---|---------|------|-------|---------|
| 01 | Prim's Algorithm | O(E log V) | O(V) | MST using PQ |
| 02 | Disjoint Set (Union-Find) | O(α(n)) | O(V) | Path Compression |

**Time**: 45 min

---

## 🎯 Quick Revision (3.5 Hours Total)

### Day 1: Basics + BFS/DFS (1.5 hours)
1. Learn graph representation (15 min)
2. Master BFS and DFS (30 min)
3. Solve 3 BFS/DFS problems (45 min)

### Day 2: Cycle + Topo Sort (1 hour)
1. Cycle detection techniques (30 min)
2. Topological sort methods (30 min)

### Day 3: Shortest Path + MST (1 hour)
1. BFS shortest path (20 min)
2. Dijkstra's algorithm (40 min)

---

## 📊 Pattern Recognition

| Pattern | When to Use | Problems |
|---------|-------------|----------|
| **BFS** | Shortest path, level-order | BFS, Islands, Shortest Path |
| **DFS** | Explore all paths, cycles | DFS, Cycle Detection, Topo Sort |
| **Topological Sort** | DAG ordering | Course Schedule, Build Order |
| **Dijkstra** | Weighted shortest path | Shortest Path in Weighted Graph |
| **Union-Find** | Connected components | Disjoint Set, Kruskal's |

---

## ⚡ Complexity Cheat Sheet

| Algorithm | Time | Space |
|-----------|------|-------|
| BFS/DFS | O(V+E) | O(V) |
| Cycle Detection | O(V+E) | O(V) |
| Topological Sort | O(V+E) | O(V) |
| Dijkstra | O(E log V) | O(V) |
| Prim's/Kruskal's | O(E log V) | O(V) |

---

## 🚀 Interview Tips

### Graph Representation:
- **Adjacency List**: Space O(V+E), better for sparse graphs
- **Adjacency Matrix**: Space O(V²), better for dense graphs

### Common Patterns:
- BFS for shortest path (unweighted)
- DFS for cycle detection
- Topological sort for DAG
- Dijkstra for weighted shortest path

### Edge Cases:
- Disconnected graphs
- Self-loops
- Multiple edges
- Negative weights (use Bellman-Ford)

---

**Total Problems**: 14  
**Total Time**: ~3.5 hours  
**All Original Problems Covered**: ✅
