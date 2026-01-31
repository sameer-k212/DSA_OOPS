package DSA.Graph_Restructured._01_Graph_Basics._03_DFS;
import java.util.*;
public class DFS {
    public static List<Integer> DFS(List<List<Integer>> list,int v){
        List<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[v];
        Stack<Integer> st = new Stack<>();
        st.add(1);
        visited[1] = true;
        while(!st.isEmpty()){
            int vertex = st.pop();


            ans.add(vertex);
            for(int nbrs : list.get(vertex)){
                if(!visited[nbrs]){
                    visited[nbrs] = true;
                    st.push(nbrs);
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
        System.out.println(DFS(list,8+1));
    }
}
