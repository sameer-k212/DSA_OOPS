package DSA.Graph._02_BFS_DFS_Problems._03_ConnectedComponents;
import java.util.*;

public class ConnectedComponent {

    public static int countCompleteComponents(int n, int[][] edges) {
        int[] visited = new int[n];

        // Build graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int count = 0;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                List<Integer> component = new ArrayList<>();
                dfs(graph, i, visited, component);

                if (isCompleteComponent(component, graph)) {
                    count++;
                }
            }
        }

        return count;
    }

    // DFS to find all nodes in a component
    private static void dfs(Map<Integer, List<Integer>> graph, int src, int[] visited,
                            List<Integer> component) {
        visited[src] = 1;
        component.add(src);

        for (int nbr : graph.get(src)) {
            if (visited[nbr] == 0) {
                dfs(graph, nbr, visited, component);
            }
        }
    }

    // Check if the component is a complete graph
    private static boolean isCompleteComponent(List<Integer> component, Map<Integer, List<Integer>> graph) {
        int size = component.size();
        int expectedEdges = size * (size - 1) / 2;

        Set<Integer> set = new HashSet<>(component);
        int actualEdges = 0;

        for (int node : component) {
            for (int neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    actualEdges++;
                }
            }
        }

        actualEdges /= 2; // because every edge is counted twice
        return actualEdges == expectedEdges;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(countCompleteComponents(n, edges)); // Output: 3
    }
}
