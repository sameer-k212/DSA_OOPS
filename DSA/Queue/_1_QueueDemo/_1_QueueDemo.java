
import java.util.LinkedList;
import java.util.Queue;

public class _1_QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(7);
        q.add(2);
        System.out.println(q);
    }
}
