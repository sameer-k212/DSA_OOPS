# Floyd-Warshall Algorithm

**Problem**: Find shortest paths between all pairs of vertices.

**Core Concept**:
- Dynamic Programming approach
- Try all vertices as intermediate points
- dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
- Works with negative edges (but not negative cycles)

**Example**:
```
Graph:  0 --5--> 1
        |        |
       10        3
        |        |
        v        v
        3 <--1-- 2
```

**Complexity**:
- Time: O(V³) - three nested loops
- Space: O(V²) - distance matrix

**Code**:
```java
void floydWarshall(int[][] graph) {
    int[][] dist = graph.clone();
    for (int k = 0; k < V; k++)
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = Math.min(dist[i][j], 
                                     dist[i][k] + dist[k][j]);
}
```
