package DSA.Graph._01_Graph_Basics._02_BFS;
import java.util.*;
public class BFS {

    public static List<Integer> bfs(List<List<Integer>> list, int v) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[v];
        java.util.Queue<Integer> q = new java.util.LinkedList<>();

        // start BFS from node 1
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int vertex = q.poll();
            ans.add(vertex);

            for (int nbr : list.get(vertex)) {
                if (!visited[nbr]) {
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        // 0th index (dummy, because graph is 1-based)
        list.add(new ArrayList<>());

        list.add(new ArrayList<>(Arrays.asList(2, 6)));      // 1
        list.add(new ArrayList<>(Arrays.asList(1, 3, 4)));   // 2
        list.add(new ArrayList<>(Arrays.asList(2)));         // 3
        list.add(new ArrayList<>(Arrays.asList(2, 5)));      // 4
        list.add(new ArrayList<>(Arrays.asList(4, 7)));      // 5
        list.add(new ArrayList<>(Arrays.asList(1, 7, 8)));   // 6
        list.add(new ArrayList<>(Arrays.asList(5, 6)));      // 7
        list.add(new ArrayList<>(Arrays.asList(6)));         // 8

        System.out.println(bfs(list, 9));
    }
}
