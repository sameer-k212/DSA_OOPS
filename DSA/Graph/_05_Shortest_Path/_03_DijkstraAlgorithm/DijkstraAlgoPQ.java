package DSA.Graph._05_Shortest_Path._03_DijkstraAlgorithm;
import java.util.*;
// solved using priority queue
class Pair{
    int weight;
    int node;
    Pair(int weight, int node){
        this.weight = weight;
        this.node = node;
    }
}

public class DijkstraAlgoPQ {

    public int[] dijkstra(int v, int[][] edges, int src) {
        // Bhai edges diye huye hain pahle graph toh bana lo
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < v; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            int w = edge[2];
            graph.get(v1).add(new Pair(w, v2));
            graph.get(v2).add(new Pair(w, v1));
        }


        // Infinite distance se initialize kar lo sare distances ko from src
        int[] distance = new int[v];
        Arrays.fill(distance, (int) (1e9));

        // create min heap;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.weight - y.weight);

        distance[src] = 0;
        pq.add(new Pair(0, src));

        while(!pq.isEmpty()){
            Pair P = pq.remove();
            int node = P.node;
            int weight = P.weight;

            for(Pair nbr : graph.get(node)){
                int nbrNode = nbr.node;
                int edgeWeight = nbr.weight;

                if(weight + edgeWeight < distance[nbrNode]){
                    distance[nbrNode] = weight + edgeWeight;
                    pq.add(new Pair(distance[nbrNode], nbrNode));
//                    Not required, because the distance[] check already ensures correctness.
//                    Using visited[] is just an optimization to reduce processing time — not correctness.
                }
            }
        }
        return distance;
    }
}
