package DSA.Graph._01_Graph_Basics._01_GraphRepresentation;
import java.util.*;
public class AdjMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        int[][] graph = new int[vertex+1][edge+1];
        for(int i = 0; i < edge; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
            graph[v][u]  = 1;
        }
    }
}
