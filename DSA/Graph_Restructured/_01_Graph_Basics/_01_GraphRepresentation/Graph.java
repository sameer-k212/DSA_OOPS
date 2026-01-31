package DSA.Graph_Restructured._01_Graph_Basics._01_GraphRepresentation;
import java.util.*;
public class Graph {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public Graph(int v) {
        map = new HashMap<>();

        for (int i = 1; i <= v; i++) {
            map.put(i, new HashMap<>());
        }
    }

    public void addEdge(int v1, int v2, int cost) {
        map.get(v1).put(v2, cost);
        map.get(v2).put(v1, cost);
    }

    public boolean containsEdge(int v1, int v2) {
        if(map.containsKey(v1)){
            return map.get(v1).containsKey(v2);
        }
        return false;
    }
    public boolean containsVertex(int v1) {
        return map.containsKey(v1);

    }
    public int noOfEdge() {
        int edge = 0;
        for (int key : map.keySet()) {
            edge += map.get(key).size();
        }
        return edge / 2;
    }
    public void removeEdge(int v1, int v2) {
        if (containsEdge(v1, v2)) {
            map.get(v1).remove(v2);
            map.get(v2).remove(v1);
        }
    }
    public void removeVertex(int v1) {
        if (containsVertex(v1)) {
            for (int nbrs : map.get(v1).keySet()) {
                map.get(nbrs).remove(v1);
            }
            map.remove(v1);
        }
        System.out.println("After removal of node "+v1+":"+map);
    }

    public void display() {

        for (int key : map.keySet()) {
            System.out.println(key + "->" + map.get(key));
        }
    }
    public  boolean hashPath(int src, int dest,HashSet<Integer> visited){
        if(src == dest){
            return true;
        }
        visited.add(src);
        for(int nbrs : map.get(src).keySet()){
            if(!visited.contains(nbrs)){
                boolean ans = hashPath(nbrs,dest,visited);
                if(ans == true){
                    return true;
                }
            }
        }
        visited.remove(src);
        return false;
    }
    public void printAllPath(int src, int dest, HashSet<Integer> visited, String ans) {
        if (src == dest) {
            System.out.println(ans + dest);
            return;
        }
        visited.add(src);
        for (int nbrs : map.get(src).keySet()) {
            if (!visited.contains(nbrs)) {
                printAllPath(nbrs, dest, visited, ans + src + "-");
            }
        }
        visited.remove(src);
    }

    public boolean BFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()){
            int rv = q.poll();
            if (visited.contains(rv)) {
                continue;
            }
            visited.add(rv);
            if (rv == dest) {
                return true;
            }
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    q.add(nbrs);
                }
            }
        }
        return false;
    }

    public boolean DFS(int src, int dest) {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        st.push(src);
        while (!st.isEmpty()) {
            int rv = st.pop();

            if (visited.contains(rv)) {
                continue;
            }
            visited.add(rv);
            if (rv == dest) {
                return true;
            }
            for (int nbrs : map.get(rv).keySet()) {
                if (!visited.contains(nbrs)) {
                    st.push(nbrs);
                }
            }
        }
        return false;
    }

    public void BFT() {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            q.add(src);
            while (!q.isEmpty()) {
                int rv = q.poll();
                if (visited.contains(rv)) {
                    continue;
                }
                System.out.print(rv + " ");
                visited.add(rv);
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        q.add(nbrs);
                    }
                }
            }
            System.out.println();
        }
    }

    public void DFT() {
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for (int src : map.keySet()) {
            if (visited.contains(src)) {
                continue;
            }
            st.push(src);
            while (!st.isEmpty()) {
                int rv = st.pop();
                if (visited.contains(rv)) {
                    continue;
                }
                System.out.print(rv + " ");
                visited.add(rv);
                for (int nbrs : map.get(rv).keySet()) {
                    if (!visited.contains(nbrs)) {
                        st.push(nbrs);
                    }
                }
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph gr = new Graph(7);
//        gr.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        gr.addEdge(1, 4, 2);
        gr.addEdge(2, 3, 4);
        gr.addEdge(3, 4, 10);
        gr.addEdge(4, 5, 5);
        gr.addEdge(5, 6, 9);
        gr.addEdge(5, 7, 12);
        gr.addEdge(6, 7, 6);

        gr.display();
        System.out.println(gr.containsEdge(7, 6));
        boolean bool = gr.hashPath(1, 6, new HashSet<>());
        int edges = gr.noOfEdge();
        System.out.println("Edges : "+edges);
        System.out.println("Path exists: " + bool);
        gr.printAllPath(1, 6, new HashSet<>(), "");
        System.out.println("BFS result: " + gr.BFS(1, 6));
        System.out.println("BFT result : ");
        gr.BFT();
        System.out.println("DFT:");
        gr.DFT();

        gr.removeVertex(1);
    }
}