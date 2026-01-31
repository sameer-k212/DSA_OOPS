# Bridges in Graph (Critical Connections)

**Problem**: Find all edges whose removal increases number of connected components.

**Core Concept**:
- Use Tarjan's algorithm with DFS
- Track discovery time and lowest reachable time
- Bridge: low[v] > disc[u] (no back edge)

**Example**:
```
0---1---3
 \ /
  2
```
Bridge: (1,3) - removing it disconnects 3

**Complexity**:
- Time: O(V + E) - single DFS
- Space: O(V) - recursion + arrays

**Code**:
```java
void dfs(int u, int parent) {
    disc[u] = low[u] = time++;
    for (int v : graph[u]) {
        if (v == parent) continue;
        if (!visited[v]) {
            dfs(v, u);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > disc[u]) bridges.add({u, v});
        } else {
            low[u] = Math.min(low[u], disc[v]);
        }
    }
}
```
