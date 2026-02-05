package DSA.Graph._02_BFS_DFS_Problems._02_NumberOfProvinces;
import java.util.*;

public class NoOfProvinces { // basically we need to find no of components of graph
    // as per question i am using +1 based indexing...
    public static int findCircleNum(int[][] isConnected) {
        int v = isConnected.length;
        // If you not comfortable with adj matrix like me then create graph
        // with the help of adj list/map

        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i = 1 ; i <= v; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                if(i != j && isConnected[i][j] == 1){
                    graph.get(i+1).add(j+1);
                    graph.get(j+1).add(i+1);
                }
            }
        }

        // one thing that you know Graph is disconnected(Some of them are connected)
        // to go on each starting node you have to create an array of visited array
        int[] visited = new int[isConnected.length+1];

        // after that i will try to find all possible diconnected component via
        // using visited array...
        int count = 0;
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == 0){
                count++;
                dfs(graph,visited,i);
            }
        }
        return count;
    }
    public static void dfs(Map<Integer,List<Integer>> graph, int []visited,int src){
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        visited[src] = 1;
        while(!stack.isEmpty()){

            int v = stack.pop();

            for(int nbr : graph.get(v)){
                if(visited[nbr] != 1){
                    visited[nbr] = 1;
                    stack.push(nbr);
                }
            }
        }
    }
    public static void main(String args[]){
        int [][]isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(findCircleNum(isConnected));
    }
}
