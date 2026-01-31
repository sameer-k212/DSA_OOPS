# Bipartite Graph Check

**Problem**: Check if graph can be colored with 2 colors such that no adjacent nodes have same color.

**Core Concept**:
- Use BFS/DFS to color nodes alternately (0 and 1)
- If neighbor has same color → not bipartite
- Works for disconnected graphs (check all components)

**Example**:
```
0---1       Bipartite ✓
|   |       Colors: 0-1-0-1
3---2
```

**Complexity**:
- Time: O(V + E) - visit all vertices and edges
- Space: O(V) - color array

**Code**:
```java
boolean isBipartite(int[][] graph) {
    int[] color = new int[n];
    Arrays.fill(color, -1);
    for (int i = 0; i < n; i++) {
        if (color[i] == -1 && !bfs(i, graph, color))
            return false;
    }
    return true;
}
```
