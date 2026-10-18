import java.util.*;
public class Priorityqueue {
    ArrayList<Integer> list = new ArrayList<>();
    public void add(int val) {
        list.add(val);
        upHeapify(list.size()-1);
    }
    public void upHeapify(int ci){
        int pi = (ci-1)/2;
        if(list.get(pi)>list.get(ci)){
            swap(ci,pi);
        }
    }
    public  void swap(int ci, int pi){
        int i = list.get(ci);
        int j = list.get(pi);
        list.set(ci,j);
        list.set(pi,i);
    }
    private int size(){
        return list.size();
    }
    private int getMin(){
        return list.get(0);
    }
    private int remove(){
        swap(0,list.size()-1);
        int rv= list.remove(list.size()-1);
        downHeapify(0);
        return rv;
    }
    public void downHeapify(int pi){
        int c1 = pi*2+1;
        int c2 = pi*2+2;

        // if(al.get(c1)<al.get(pi) && al.get(c2) >al.get(pi && c1<al.size())){
        //     swap(c1, pi);
        //     downHeapify(c1);
        // }
        // if(al.get(c1)>al.get(pi) && al.get(c2) <al.get(pi) && c2<al.size()){
        //     swap(c2, pi);
        //     downHeapify(c2);
        // }

        // Alternate
        int mini =pi;
        if(c1<list.size() &&list.get(mini)>list.get(c1)){
            mini=c1;
        }
        if(c2<list.size() && list.get(mini)>list.get(c2)){
            mini=c2;
        }
        if(mini!=pi){
            swap(mini, pi);
            downHeapify(mini);
        }
    }


    public static void main(String[] args) {
        Priorityqueue pq = new Priorityqueue();
        pq.add(10);
        pq.add(20);
        pq.add(3);
        pq.add(12);
        pq.add(9);
        pq.add(2);
        pq.add(-1);
        System.out.println(pq.getMin());
        System.out.println(pq.remove());

    }
}
