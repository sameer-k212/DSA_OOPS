# Shortest Path in Binary Matrix

**Problem**: Find shortest path from top-left to bottom-right in binary matrix (0=open, 1=blocked). Can move in 8 directions.

**Core Concept**:
- BFS for shortest path in unweighted grid
- 8-directional movement (including diagonals)
- Track distance while traversing

**Example**:
```
0 1 0       Path length: 4
0 0 0       (0,0)→(1,0)→(1,1)→(1,2)→(2,2)
0 0 0
```

**Complexity**:
- Time: O(n²) - visit each cell once
- Space: O(n²) - queue size

**Code**:
```java
int shortestPath(int[][] grid) {
    if (grid[0][0] == 1) return -1;
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{0, 0, 1});
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    while (!q.isEmpty()) {
        int[] curr = q.poll();
        if (curr[0] == n-1 && curr[1] == n-1) return curr[2];
        // explore 8 directions
    }
}
```
