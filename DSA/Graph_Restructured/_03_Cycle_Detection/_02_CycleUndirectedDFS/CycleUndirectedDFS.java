package DSA.Graph_Restructured._03_Cycle_Detection._02_CycleUndirectedDFS;
import java.util.*;
public class DetectCycleUDGDFS {
    static class Pair{
        int node, parent;
        Pair(int node, int parent){
            this.node = node;
            this.parent = parent;
        }

    }
    public static void cycleDetect(int[][] grid, int v){
        int[] visited = new int[v];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j : grid[i]) {
                graph.get(i).add(j);
                graph.get(j).add(i); // undirected
            }
        }

        if(DFS(graph,visited)){
            System.out.println("Yes Cycle");
        }else{
            System.out.println("No Cycle");
        }
    }
    public static boolean DFS(List<List<Integer>> graph,int[] visited){
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                if (dfsCycle(graph, visited, i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfsCycle(List<List<Integer>> graph,int[] visited, int start){
        Stack<Pair> st = new Stack<>();
        visited[start] = 1;

        st.push(new Pair(start,-1));
        while(!st.isEmpty()){
            Pair p = st.pop();
            int node = p.node;
            int parent = p.parent;


            for(int nbr : graph.get(node)){
                if(nbr != parent){
                    if(visited[nbr] != 1){
                        visited[nbr] = 1;
                        st.push(new Pair(nbr,node));
                    }else{
                        return true;
                    }
                }
            }


        }
        return false;
    }


    public static void main(String[] args) {
//        int[][] grid1 = {{1}, {0, 2, 4}, {1, 3}, {2, 4}, {1, 3}};
        int[][] grid1 =  {{}, {2}, {1,3}, {2}};
        cycleDetect(grid1, 5);
    }
}
