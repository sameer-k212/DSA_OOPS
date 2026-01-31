package DSA.Graph_Restructured._06_MST_And_Advanced._01_PrimsAlgorithm;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Prims {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    Prims(int vertex){
        map= new HashMap<>();
        for(int i=1;i<=vertex;i++){
            map.put(i,new HashMap<Integer,Integer>());
        }
    }
    public void add(int e1,int e2,int cost){
        map.get(e1).put(e2,cost);
        map.get(e2).put(e1, cost);
    }


    public class Pair {
        int e1;
        int e2;
        int cost;
        Pair(int e1,int e2,int cost){
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
        public String toString(){
            return e1+"->"+e2+"@"+cost;
        }
    }
    public void PrimsAlgo(int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->{
            return o1.cost-o2.cost;
        });
        HashSet<Integer> visited= new HashSet<>();
        pq.add(new Pair(src, src, 0));
        int ans=0;
        while (!pq.isEmpty()) {
            Pair rv= pq.poll();
            if(visited.contains(rv.e1)){
                continue;
            }
            visited.add(rv.e1);
            ans+=rv.cost;
            System.out.println(rv);
            for(int nbrs: map.get(rv.e1).keySet()){
                if(!visited.contains(nbrs)){
                    pq.add(new Pair(nbrs, src, map.get(rv.e1).get(nbrs)));
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        Prims k= new Prims(7);
        k.add(1, 2, 1);
        k.add(1, 4, 2);
        k.add(2, 3, 4);
        k.add(3, 4, 9);
        k.add(4, 5, 6);
        k.add(5, 6, 5);
        k.add(5, 7, 2);
        k.add(6, 7, 3);
        k.PrimsAlgo(7);
    }
}