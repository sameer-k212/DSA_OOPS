# Depth First Search (DFS)

## 📝 Problem
Traverse graph depth-wise using recursion/stack

## 💡 Core Concept
- Go deep before going wide
- Use recursion or stack
- Mark visited to avoid cycles

## 🔄 Example
```
Graph: 0-1-3
       |
       2-4

DFS from 0: [0, 1, 3, 2, 4]
```

## ⚡ Complexity
- **Time**: O(V + E)
- **Space**: O(V)

## 💻 Code
```java
public static void dfs(List<List<Integer>> adj, int node, boolean[] visited, List<Integer> result) {
    visited[node] = true;
    result.add(node);
    
    for (int neighbor : adj.get(node)) {
        if (!visited[neighbor]) {
            dfs(adj, neighbor, visited, result);
        }
    }
}
```
