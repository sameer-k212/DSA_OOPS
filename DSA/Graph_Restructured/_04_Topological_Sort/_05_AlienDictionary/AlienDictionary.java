package DSA.Graph_Restructured._04_Topological_Sort._05_AlienDictionary;
import java.util.*;

public class AlienDictionary {
    private static String alienDictionary(int vertices, String[] str) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < vertices; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0 ; i < str.length-1; i++){
            String str1 = str[i];
            String str2 = str[i+1];

            int j = 0;
            int k = 0;
            while(j < str1.length() && k < str2.length()){
                char ch1 = str1.charAt(j);
                char ch2 = str2.charAt(k);
                if(ch1 != ch2){
                    graph.get(ch1 - 'a').add(ch2 - 'a');
                    break;
                }
                j++;
                k++;
            }
        }
        List<Integer> list = topologicalSort(graph, vertices);
        String ans = "";
        for (int it : list) {
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }
    public static List<Integer> topologicalSort(List<List<Integer>> graph, int vertices){
        int[] indegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int it : graph.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            list.add(node);
            // node is in your topological sort
            // so please remove it from the indegree

            for (int nbr : graph.get(node)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) q.add(nbr);
            }
        }

        return list;
    }
    public static void addEdge(int v1, int v2, List<List<Integer>> graph){
        graph.get(v1).add(v2);

    }

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        int vertices  = 4;
        System.out.println(alienDictionary(vertices,dict));
    }
}
