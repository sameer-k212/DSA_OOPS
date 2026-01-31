# Strongly Connected Components (Kosaraju's Algorithm)

**Problem**: Find all maximal strongly connected subgraphs in directed graph.

**Core Concept**:
- 3 steps: DFS to fill stack, transpose graph, DFS on transpose
- Nodes in same SCC can reach each other
- Works only for directed graphs

**Example**:
```
0 → 1 → 2
↑   ↓   ↓
└───3   0
    ↓
    4
```
SCCs: {0,1,2}, {3}, {4}

**Complexity**:
- Time: O(V + E) - three DFS traversals
- Space: O(V) - stack + visited arrays

**Code**:
```java
List<List<Integer>> kosaraju(int V, List<List<Integer>> adj) {
    // Step 1: Fill stack with finish times
    Stack<Integer> stack = new Stack<>();
    dfs1(adj, stack);
    
    // Step 2: Transpose graph
    List<List<Integer>> transpose = getTranspose(adj);
    
    // Step 3: DFS on transpose
    return dfs2(transpose, stack);
}
```
