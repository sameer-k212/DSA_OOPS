package DSA.Graph_Restructured._03_Cycle_Detection._01_CycleUndirectedBFS;

import java.util.ArrayList;

public class CycleDetection {

    // Function to detect cycle in an undirected graph.
    public boolean dfsUndirected(int s, int p, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[s] = true;
        // Call dfs on connections of s
        for (int i : adj.get(s)) {
            if (!vis[i]) { // If connection is unvisited, go dfs
                if (dfsUndirected(i, s, vis, adj))
                    return true;
            } else if (i != p) { // If vertex is visited and not parent then cycle detected
                return true; // Cycle detected
            }
        }
        return false;
    }

    public boolean isCycleUndirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfsUndirected(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    // Function to detect cycle in a directed graph.
    public boolean dfsDirected(int x, boolean[] vis, boolean[] dfsv, ArrayList<ArrayList<Integer>> adj) {
        vis[x] = true;
        dfsv[x] = true;

        // Call dfs on unvisited connections
        for (int i : adj.get(x)) {
            // Unvisited
            if (!vis[i]) {
                if (dfsDirected(i, vis, dfsv, adj))
                    return true;
            }
            // If visited and in the current dfs path (i.e., part of the cycle)
            else if (dfsv[i]) {
                return true;
            }
        }
        dfsv[x] = false;
        return false;
    }

    public boolean isCyclicDirected(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] dfsv = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfsDirected(i, vis, dfsv, adj))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CycleDetection cycleDetection = new CycleDetection();

        // Create an undirected graph with 2 nodes and 1 edge
        ArrayList<ArrayList<Integer>> adjUndirected = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            adjUndirected.add(new ArrayList<>());
        }
        // Add an edge between node 0 and node 1



        System.out.println("Cycle detected in undirected graph: " + cycleDetection.isCycleUndirected(1, adjUndirected));

        // Create a directed graph with 2 nodes and 1 edge
        ArrayList<ArrayList<Integer>> adjDirected = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            adjDirected.add(new ArrayList<>());
        }
        // Add an edge from node 0 to node 1 (directed)
        adjDirected.get(0).add(1);

        System.out.println("Cycle detected in directed graph: " + cycleDetection.isCyclicDirected(2, adjDirected));
    }
}
