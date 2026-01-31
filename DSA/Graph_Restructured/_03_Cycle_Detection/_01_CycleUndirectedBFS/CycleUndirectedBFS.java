package DSA.Graph_Restructured._03_Cycle_Detection._01_CycleUndirectedBFS;
import java.util.*;

public class DetectCycleUDGBFS {
    static class Pair {
        int parent;
        int node;
        Pair(int parent, int node) {
            this.parent = parent;
            this.node = node;
        }
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Initialize adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the undirected graph
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // Visited array
        int[] visited = new int[n];

        // For all components (disconnected graphs)
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (hasCycle(graph, i, visited)) {
                    return "Yes";
                }
            }
        }

        return "No";
    }

    public static boolean hasCycle(List<List<Integer>> graph, int start, int[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(-1, start));
        visited[start] = 1;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int parent = p.parent;
            int node = p.node;

            for (int nbr : graph.get(node)) {
                if (nbr != parent) {
                    if (visited[nbr] == 0) {
                        visited[nbr] = 1;
                        q.add(new Pair(node, nbr));
                    } else {
                        return true; // Cycle found
                    }
                }
            }
        }

        return false;
    }

    // Example usage
    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 0}}; // Has cycle
        System.out.println(cycleDetection(edges1, 3, 3)); // Output: Yes

        int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}}; // No cycle
        System.out.println(cycleDetection(edges2, 4, 3)); // Output: No
    }

}