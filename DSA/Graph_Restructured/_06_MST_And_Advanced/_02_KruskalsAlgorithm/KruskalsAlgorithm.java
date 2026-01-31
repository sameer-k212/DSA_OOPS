package DSA.Graph_Restructured._06_MST_And_Advanced._02_KruskalsAlgorithm;

import java.util.*;

public class KruskalsAlgorithm {
    class Pair {
        int e1;
        int e2;
        int cost;
        Pair(int e1, int e2, int cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
        @Override
        public String toString() {
            return "Edge: (" + e1 + ", " + e2 + ") Cost: " + cost;
        }
    }
    HashMap<Integer, HashMap<Integer, Integer>> map;
    public KruskalsAlgorithm(int v) {
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int e1, int e2, int cost) {
        map.get(e1).put(e2, cost);
        map.get(e2).put(e1, cost);
    }

    public List<Pair> getAllEdges() {
        List<Pair> l = new ArrayList<>();
        for (int e1 : map.keySet()) {
            for (int e2 : map.get(e1).keySet()) {
                int cost = map.get(e1).get(e2);
                l.add(new Pair(e1, e2, cost));
            }
        }
        return l;
    }

    int ans = 0;
    public void kruskalAlgo() {
        List<Pair> edges = getAllEdges();
        Collections.sort(edges, (a, b) -> a.cost - b.cost);

        DisjointSet ds = new DisjointSet();
        for (int node : map.keySet()) {
            ds.createSet(node);
        }

        for (Pair edge : edges) {
            int root1 = ds.find(edge.e1);
            int root2 = ds.find(edge.e2);

            if (root1 != root2) {
                ds.union(edge.e1, edge.e2);
                ans += edge.cost;
                System.out.println(edge);
            }
        }
        System.out.println("Total Minimum Cost: " + ans);
    }

    public static void main(String[] args) {
        KruskalsAlgorithm k = new KruskalsAlgorithm(7);
        k.addEdge(1, 2, 1);
        k.addEdge(1, 4, 2);
        k.addEdge(2, 3, 4);
        k.addEdge(3, 4, 9);
        k.addEdge(4, 5, 6);
        k.addEdge(5, 7, 2);
        k.addEdge(5, 6, 5);
        k.addEdge(6, 7, 3);
        k.kruskalAlgo();
    }
}

class DisjointSet {
    class Node {
        int val;
        int rank;
        Node parent;
    }

    HashMap<Integer, Node> map = new HashMap<>();

    public void createSet(int v) {
        Node node = new Node();
        node.val = v;
        node.rank = 0;
        node.parent = node;
        map.put(v, node);
    }

    public int find(int v) {
        return find(map.get(v)).val;
    }

    private Node find(Node node) {
        if (node.parent == node) {
            return node;
        }
        node.parent = find(node.parent);  // Path compression
        return node.parent;
    }

    public void union(int e1, int e2) {
        Node root1 = find(map.get(e1));
        Node root2 = find(map.get(e2));

        if (root1 == root2) return;

        if (root1.rank < root2.rank) {
            root1.parent = root2;
        } else if (root1.rank > root2.rank) {
            root2.parent = root1;
        } else {
            root2.parent = root1;
            root1.rank++;
        }
    }
}
