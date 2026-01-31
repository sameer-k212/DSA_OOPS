package DSA.Graph_Restructured._06_MST_And_Advanced._03_DisjointSet;

public class DisjointSetRank {
    int rank[];
    int parent[];

    // assumed 1 based indexing.
    public DisjointSetRank(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // with this function we can find the ultimate parent to the given node.
    public int findUltimateParent(int u){
        if(u == parent[u]){
            return  u;
        }
        return parent[u] = findUltimateParent(parent[u]);
    }

    // throughout this method we can create disjoint set data structure by rank.
    public void unionByRank(int u, int v){
        int ult_par_u = findUltimateParent(u);
        int ult_par_v = findUltimateParent(v);

        if(ult_par_v == ult_par_u){
            return;
        }

        if(rank[ult_par_u] < rank[ult_par_v]){
            parent[ult_par_u] = ult_par_v;
        }
        else if(rank[ult_par_u] >  rank[ult_par_v]){
            parent[ult_par_v] = ult_par_u;
        }else{
            parent[ult_par_v] = ult_par_u;
            rank[ult_par_u]++;
        }
    }

    public static void main(String[] args) {
        DisjointSetRank disjointSet = new DisjointSetRank(7);
        disjointSet.unionByRank(1,2);
        disjointSet.unionByRank(2,3);
        disjointSet.unionByRank(4,5);
        disjointSet.unionByRank(6,7);
        disjointSet.unionByRank(5,6);

        // now i want to find that 3 and 7 has same parent or not.
        if(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)){
            System.out.println("Same");
        }else {
            System.out.println("not Same");
        }

        disjointSet.unionByRank(3,7);

        if(disjointSet.findUltimateParent(3) == disjointSet.findUltimateParent(7)){
            System.out.println("Same");
        }else {
            System.out.println("not Same");
        }
    }
}
