# Breadth First Search (BFS)

## 📝 Problem
Traverse graph level by level using queue

## 💡 Core Concept
- Use queue for level-order traversal
- Mark visited to avoid cycles
- Process all neighbors before moving to next level

## 🔄 Example
```
Graph: 0-1-3
       |
       2-4

BFS from 0: [0, 1, 2, 3, 4]
```

## ⚡ Complexity
- **Time**: O(V + E)
- **Space**: O(V)

## 💻 Code
```java
public static List<Integer> bfs(List<List<Integer>> adj, int start) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[adj.size()];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int node = queue.poll();
        result.add(node);
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
    return result;
}
```
