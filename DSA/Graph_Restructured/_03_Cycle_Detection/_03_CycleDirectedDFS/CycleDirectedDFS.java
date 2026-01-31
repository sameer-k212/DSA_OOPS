package DSA.Graph_Restructured._03_Cycle_Detection._03_CycleDirectedDFS;
import java.util.*;
// iterative will become more difficult because of backtracking.
// so that we use recursive approach to backtrack.

public class CycleInDirectedGraphDFS {

    public boolean isCyclic(ArrayList<ArrayList<Integer>> graph) {
        int n = graph.size();
        int[] visited = new int[n];
        int[] path_visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (DFS(graph, i, visited, path_visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean DFS(ArrayList<ArrayList<Integer>> graph, int node, int[] visited, int[] path_visited) {

        visited[node] = 1;
        path_visited[node] = 1;

        for (int nbr : graph.get(node)) {
            if (visited[nbr] == 0) {
                if(DFS(graph, nbr,visited, path_visited)){
                    return true;
                }
            } else if (path_visited[nbr] == 1) {
                return true;
            }
        }

        path_visited[node] = 0; // Backtrack
        return false;
    }

    public static void main(String[] args) {
        // Number of nodes
        int n = 4;

        // Create the graph as an adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges (Directed graph)
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1); // Cycle from 3 -> 1

        CycleInDirectedGraphDFS dfsCycleDetector = new CycleInDirectedGraphDFS();
        if (dfsCycleDetector.isCyclic(graph)) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }
    }
}



