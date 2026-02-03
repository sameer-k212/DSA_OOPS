package DSA_OOPS.DSA.SegmentTree._04_RangeMinQuery;

public class RangeMinQuery {
    private int[] tree;
    private int n;
    
    public RangeMinQuery(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        build(arr, 0, 0, n - 1);
    }
    
    private void build(int[] arr, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(arr, 2 * node + 1, start, mid);
        build(arr, 2 * node + 2, mid + 1, end);
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
    
    public int queryMin(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }
    
    private int query(int node, int start, int end, int l, int r) {
        if (r < start || l > end) return Integer.MAX_VALUE;
        if (l <= start && end <= r) return tree[node];
        
        int mid = (start + end) / 2;
        return Math.min(query(2 * node + 1, start, mid, l, r),
                       query(2 * node + 2, mid + 1, end, l, r));
    }
    
    public void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }
    
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) update(2 * node + 1, start, mid, idx, val);
        else update(2 * node + 2, mid + 1, end, idx, val);
        tree[node] = Math.min(tree[2 * node + 1], tree[2 * node + 2]);
    }
    
    public static void main(String[] args) {
        int[] arr = {8, 2, 5, 1, 4, 5, 3, 9, 6, 10};
        RangeMinQuery rmq = new RangeMinQuery(arr);
        System.out.println("Min [3,8]: " + rmq.queryMin(3, 8));
        rmq.update(4, 0);
        System.out.println("Min [3,8] after update: " + rmq.queryMin(3, 8));
    }
}
