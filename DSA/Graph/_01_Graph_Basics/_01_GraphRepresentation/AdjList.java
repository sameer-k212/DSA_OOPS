package DSA.Graph._01_Graph_Basics._01_GraphRepresentation;
import java.util.*;

public class AdjList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("vertex :");
        int vertex = sc.nextInt();
        System.out.println("edge :");
        int edge = sc.nextInt();
        // Graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < vertex; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < edge; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        System.out.println(graph);
    }
}
