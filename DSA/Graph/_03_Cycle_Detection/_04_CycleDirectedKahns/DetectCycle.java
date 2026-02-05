package DSA.Graph._03_Cycle_Detection._04_CycleDirectedKahns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public static int[] topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // First Calculate InDegree Of All Nodes.
        int[]  in_degree= new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                in_degree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        int[] ts = new int[V];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            ts[i++] = node;

            // node is in your topological sort
            // so please remove it from the in_degree

            for (int it : adj.get(node)) {
                in_degree[it]--;
                if (in_degree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return ts;
    }
    public static void main(String[] args){
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topologicalSort(V, adj);
        if(ans.length < adj.size()){
            System.out.println("Yes Cycle");
        }else{
            System.out.println("Not Cycle");
        }
    }
}
