package DSA.Graph._04_Topological_Sort._02_KahnsAlgorithm;
import java.util.*;

public class TopologicalSortBFS {
    public int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // First Calculate InDegree Of All Nodes.
        int[]  in_degree= new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                in_degree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        int[] ts = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            ts[i++] = node;
            // node is in your topological sort
            // so please remove it from the in_degree

            for (int it : adj.get(node)) {
                in_degree[it]--;
                if (in_degree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return ts;
    }

}
