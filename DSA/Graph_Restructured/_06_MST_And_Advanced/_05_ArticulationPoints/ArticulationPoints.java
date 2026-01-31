package DSA.Graph_Restructured._06_MST_And_Advanced._05_ArticulationPoints;

import java.util.*;

public class ArticulationPoints {
    private int time = 0;

    public List<Integer> findArticulationPoints(int n, List<List<Integer>> edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        
        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }
        
        int[] disc = new int[n];
        int[] low = new int[n];
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] ap = new boolean[n];
        Arrays.fill(parent, -1);
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, disc, low, parent, visited, ap);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ap[i]) result.add(i);
        }
        return result;
    }
    
    private void dfs(int u, List<List<Integer>> graph, int[] disc, int[] low, 
                     int[] parent, boolean[] visited, boolean[] ap) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = time++;
        
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v, graph, disc, low, parent, visited, ap);
                
                low[u] = Math.min(low[u], low[v]);
                
                if (parent[u] == -1 && children > 1) ap[u] = true;
                if (parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        ArticulationPoints obj = new ArticulationPoints();
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(0,1), Arrays.asList(1,2), 
            Arrays.asList(2,0), Arrays.asList(1,3)
        );
        System.out.println(obj.findArticulationPoints(4, edges)); // [1]
    }
}
