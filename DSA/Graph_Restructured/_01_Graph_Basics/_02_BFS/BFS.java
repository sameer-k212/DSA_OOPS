package DSA.Graph_Restructured._01_Graph_Basics._02_BFS;
import java.util.*;
public class BFS {
    public static List<Integer> bfs(List<List<Integer>> list,int v){
        List<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int vertex = q.poll();

            ans.add(vertex);
            for(int nbr : list.get(vertex)){
                if(!visited[nbr]){
                    visited[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer >> list = new ArrayList<>();
        list.add(new ArrayList<>()); // 0th list (empty)
        list.add(new ArrayList<>(Arrays.asList(2, 6))); // 1st list
        list.add(new ArrayList<>(Arrays.asList(1, 3, 4))); // 2nd list
        list.add(new ArrayList<>(Arrays.asList(2))); // 2nd list
        list.add(new ArrayList<>(Arrays.asList(2, 5))); // 3rd list
        list.add(new ArrayList<>(Arrays.asList(4, 7))); // 4th list
        list.add(new ArrayList<>(Arrays.asList(1, 7, 8))); // 5th list
        list.add(new ArrayList<>(Arrays.asList(5, 6))); // 6th list
        list.add(new ArrayList<>(Arrays.asList(6))); // 7th list
        System.out.println(bfs(list,8+1));
    }
 }
