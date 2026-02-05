package DSA.Graph._04_Topological_Sort._01_TopologicalSortDFS;
import java.util.*;
public class TopologicalSort {
    public static ArrayList<Integer> topoSort(int v, int[][] edges) {
        // code here
        int[] visited = new int[v];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < v; i++){
            if(visited[i] == 0){
                DFS(graph, visited, i, st);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!st.isEmpty()){
            list.add(st.pop());
        }
        return list;
    }
    public static void DFS(List<List<Integer>> graph, int[] visited, int src, Stack<Integer> st){
        visited[src] = 1;

        for(int nbr : graph.get(src)){
            if(visited[nbr] == 0){
                DFS(graph, visited, nbr, st);
            }
        }

        st.push(src);
    }
    public static void main(String[] args) {
        int v = 4;
        int[][] edges = { {1, 0}, {2, 0}, {3, 1}, {3,2} };
        System.out.println(topoSort(v, edges));
    }
}
