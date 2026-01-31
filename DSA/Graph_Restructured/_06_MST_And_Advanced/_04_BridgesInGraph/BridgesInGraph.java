package DSA.Graph_Restructured._06_MST_And_Advanced._04_BridgesInGraph;

import java.util.*;

public class BridgesInGraph {
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (List<Integer> conn : connections) {
            graph.get(conn.get(0)).add(conn.get(1));
            graph.get(conn.get(1)).add(conn.get(0));
        }
        
        int[] disc = new int[n];
        int[] low = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        
        dfs(0, -1, graph, disc, low, visited, bridges);
        return bridges;
    }
    
    private void dfs(int u, int parent, List<List<Integer>> graph, int[] disc, 
                     int[] low, boolean[] visited, List<List<Integer>> bridges) {
        visited[u] = true;
        disc[u] = low[u] = time++;
        
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            
            if (!visited[v]) {
                dfs(v, u, graph, disc, low, visited, bridges);
                low[u] = Math.min(low[u], low[v]);
                
                if (low[v] > disc[u]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        BridgesInGraph obj = new BridgesInGraph();
        List<List<Integer>> connections = Arrays.asList(
            Arrays.asList(0,1), Arrays.asList(1,2), 
            Arrays.asList(2,0), Arrays.asList(1,3)
        );
        System.out.println(obj.criticalConnections(4, connections)); // [[1,3]]
    }
}
