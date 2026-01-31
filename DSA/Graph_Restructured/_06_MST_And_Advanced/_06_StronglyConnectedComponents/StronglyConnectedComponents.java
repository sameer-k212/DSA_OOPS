package DSA.Graph_Restructured._06_MST_And_Advanced._06_StronglyConnectedComponents;

import java.util.*;

public class StronglyConnectedComponents {
    public List<List<Integer>> kosaraju(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        
        // Step 1: Fill stack with finish times
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }
        
        // Step 2: Create transpose graph
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                transpose.get(v).add(u);
            }
        }
        
        // Step 3: DFS on transpose in stack order
        Arrays.fill(visited, false);
        List<List<Integer>> sccs = new ArrayList<>();
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                List<Integer> scc = new ArrayList<>();
                dfs2(node, transpose, visited, scc);
                sccs.add(scc);
            }
        }
        return sccs;
    }
    
    private void dfs1(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, adj, visited, stack);
            }
        }
        stack.push(node);
    }
    
    private void dfs2(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> scc) {
        visited[node] = true;
        scc.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, adj, visited, scc);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) adj.add(new ArrayList<>());
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);
        adj.get(3).add(4);
        
        StronglyConnectedComponents obj = new StronglyConnectedComponents();
        System.out.println(obj.kosaraju(5, adj)); // [[0,2,1], [3], [4]]
    }
}
