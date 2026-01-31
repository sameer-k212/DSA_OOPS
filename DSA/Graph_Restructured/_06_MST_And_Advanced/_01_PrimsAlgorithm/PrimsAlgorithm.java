package DSA.Graph_Restructured._06_MST_And_Advanced._01_PrimsAlgorithm;
import java.util.*;
// Solved Using Priority Queue.
class Pair {
    int vertex;
    int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

public class PrimsAlgo {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        int ans = 0;
        boolean[] visited = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair node = pq.remove();
            int vertex = node.vertex;
            int weight = node.weight;

            if (visited[vertex]) {
                continue;
            }

            ans += weight;
            visited[vertex] = true; // yahi hona chahiye.

            List<int[]> nbrs = adj.get(vertex);
            for (int[] nbr : nbrs) {
                int nbrV = nbr[0];
                int nbrW = nbr[1];

                if (!visited[nbrV]) {
                    pq.add(new Pair(nbrV, nbrW));
                    // don't mark as visited here!
                    // kyun ki bhai hame same node revisite karna to find smallest weight.
                }
            }
        }

        return ans;
    }
}
