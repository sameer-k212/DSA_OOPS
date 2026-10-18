import java.util.*;
public class HackerRank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque d = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            d.addFirst(num);
            if(d.size() == m){
                Set<Integer> set = new HashSet<>(d);
                max = Math.max(max,set.size());
                d.removeLast();
            }
        }
        System.out.println(max);

    }
}
