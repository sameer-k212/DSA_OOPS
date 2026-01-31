# Articulation Points (Cut Vertices)

**Problem**: Find all vertices whose removal increases number of connected components.

**Core Concept**:
- Use Tarjan's algorithm with DFS
- Root is AP if it has >1 child in DFS tree
- Non-root is AP if low[v] >= disc[u]

**Example**:
```
0---1---3
 \ /
  2
```
Articulation Point: 1 - removing it disconnects 3

**Complexity**:
- Time: O(V + E) - single DFS
- Space: O(V) - recursion + arrays

**Code**:
```java
void dfs(int u) {
    disc[u] = low[u] = time++;
    int children = 0;
    for (int v : graph[u]) {
        if (!visited[v]) {
            children++;
            dfs(v);
            low[u] = Math.min(low[u], low[v]);
            if (parent[u] == -1 && children > 1) ap[u] = true;
            if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
        } else if (v != parent[u]) {
            low[u] = Math.min(low[u], disc[v]);
        }
    }
}
```
