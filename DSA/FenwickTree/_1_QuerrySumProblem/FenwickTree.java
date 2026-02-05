package DSA.FenwickTree._1_QuerrySumProblem;

import java.util.Arrays;

public class FenwickTree {
    static class Fenwick{
        int bit[];
        int n;
        public Fenwick(int n){
            this.n = n;
            bit = new int[n + 1];
        }

        public long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & (-idx);
            }
            return sum;
        }
        public void update(int idx, long delta) {
            while (idx <= n) {
                bit[idx] += delta;
                idx += idx & (-idx);
            }

//            System.out.println("Fenwick Tree created : " + Arrays.toString(bit));
        }

        public void buildFenwickTree(int arr[]){
            for(int i = 1; i <= n; i++){
                bit[i] += arr[i-1];

                int j = i + (i & -i);
                if(j <= n){
                    bit[j] += bit[i];
                }
            }

//            System.out.println("Fenwick Tree created : " + Arrays.toString(bit));
        }

    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 1, 2, 4, 5, 6, 2};

        int n = arr.length;
        Fenwick ft = new Fenwick(n);

//        // option 1 to create fenwick tree O(n*log n)
//        for(int i = 0; i < n; i++){
//            ft.update(i + 1, arr[i]);
//        }

        // option 2 to create fenwick tree O(n)
        ft.buildFenwickTree(arr);

        // finding range sum
        int l = 1;
        int r = 3;
        System.out.println("Range sum : " + (ft.query(r) - ft.query(l - 1)));

        // update value and then range sum;
        int idx = 2;
        int o = 3;
        int left = 2;
        int right = 5;
        ft.update(idx, o);
        System.out.println("range sum" + (ft.query(right) - ft.query(left - 1)));

    }
}
