package DSA.Graph_Restructured._06_MST_And_Advanced._03_DisjointSet;

public class DisjointSetSize {
    int size[];
    int parent[];

    // Assumed 1-based indexing.
    public DisjointSetSize(int n){
        size = new int[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1; // initialize size as 1 for each node
        }
    }

    // Finds the ultimate parent (with path compression)
    public int findUltimateParent(int u){
        if(u == parent[u]){
            return u;
        }
        return parent[u] = findUltimateParent(parent[u]);
    }

    // Union by Size
    public void unionBySize(int u, int v){
        int ult_par_u = findUltimateParent(u);
        int ult_par_v = findUltimateParent(v);

        if(ult_par_u == ult_par_v) return;

        if(size[ult_par_u] < size[ult_par_v]){
            parent[ult_par_u] = ult_par_v;
            size[ult_par_v] += size[ult_par_u];
        }
        else {
            parent[ult_par_v] = ult_par_u;
            size[ult_par_u] += size[ult_par_v];
        }
    }

    public static void main(String[] args) {
        DisjointSetSize disjointSet = new DisjointSetSize(7);

        disjointSet.unionBySize(1,2);
        disjointSet.unionBySize(2,3);
        disjointSet.unionBySize(4,5);
        disjointSet.unionBySize(6,7);
        disjointSet.unionBySize(5,6);

        if(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)){
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        disjointSet.unionBySize(3,7);

        if(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)){
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
