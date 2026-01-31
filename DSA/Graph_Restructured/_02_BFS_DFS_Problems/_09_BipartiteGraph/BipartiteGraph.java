package DSA.Graph_Restructured._02_BFS_DFS_Problems._09_BipartiteGraph;

import java.util.*;

public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, graph, color)) return false;
            }
        }
        return true;
    }
    
    private boolean bfsCheck(int start, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BipartiteGraph obj = new BipartiteGraph();
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(obj.isBipartite(graph)); // true
    }
}
