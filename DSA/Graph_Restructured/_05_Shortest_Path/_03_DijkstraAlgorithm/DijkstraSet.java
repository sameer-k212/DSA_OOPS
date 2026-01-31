package DSA.Graph_Restructured._05_Shortest_Path._03_DijkstraAlgorithm;

import java.util.*;

class Pair {
    int node, dist;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}

public class DjkstraAlgoSet {
    public static int[] dijkstra(int V, List<List<int[]>> adj, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist == b.dist)
                return a.node - b.node;
            return a.dist - b.dist;
        });

        set.add(new Pair(0, S));

        while (!set.isEmpty()) {
            Pair top = set.pollFirst(); // get and remove the smallest
            int u = top.node;
            int d = top.dist;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (d + weight < dist[v]) {
                    // If already present, remove the old pair
                    set.remove(new Pair(dist[v], v));
                    dist[v] = d + weight;
                    set.add(new Pair(dist[v], v));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Example Graph: (u, v, w)
        adj.get(0).add(new int[]{1, 2});
        adj.get(0).add(new int[]{2, 4});
        adj.get(1).add(new int[]{2, 1});
        adj.get(1).add(new int[]{3, 7});
        adj.get(2).add(new int[]{4, 3});
        adj.get(3).add(new int[]{4, 1});

        int[] result = dijkstra(V, adj, 0);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + " -> " + result[i]);
        }
    }
}
