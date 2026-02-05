package DSA.Graph._04_Topological_Sort._03_EventualSafeStates;
import java.util.*;

public class FindEventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];
        int path_visited[] = new int[n];
        int check[] = new int[n];
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            if(visited[i] == 0){
                DFS(graph, visited, path_visited, i, check);
            }
        }
        for(int i = 0 ; i < n; i++){
            if(check[i] == 1){
                list.add(i);
            }
        }
        Collections.sort(list);
        return list;
    }
    public boolean DFS(int graph[][], int visited[], int path_visited[], int start, int check[]){

        visited[start] = 1;
        path_visited[start] = 1;
        check[start] = 0;

        for(int nbr : graph[start]){
            if(visited[nbr] == 0){
                if(DFS(graph, visited, path_visited, nbr, check)){
                    return true;
                }

            }else if(visited[nbr] == 1 && path_visited[nbr] == 1){
                return true;
            }
        }
        check[start] = 1;
        path_visited[start] = 0;
        return false;

    }
}

