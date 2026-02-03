package DSA_OOPS.DSA.SegmentTree._03_LazyPropagation;

public class LazyPropagation {
    private int[] tree, lazy;
    private int n;
    
    public LazyPropagation(int[] arr) {
        n = arr.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];
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
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    private void push(int node, int start, int end) {
        if (lazy[node] != 0) {
            tree[node] += (end - start + 1) * lazy[node];
            if (start != end) {
                lazy[2 * node + 1] += lazy[node];
                lazy[2 * node + 2] += lazy[node];
            }
            lazy[node] = 0;
        }
    }
    
    public void updateRange(int l, int r, int val) {
        updateRange(0, 0, n - 1, l, r, val);
    }
    
    private void updateRange(int node, int start, int end, int l, int r, int val) {
        push(node, start, end);
        if (r < start || l > end) return;
        
        if (l <= start && end <= r) {
            lazy[node] += val;
            push(node, start, end);
            return;
        }
        
        int mid = (start + end) / 2;
        updateRange(2 * node + 1, start, mid, l, r, val);
        updateRange(2 * node + 2, mid + 1, end, l, r, val);
        push(2 * node + 1, start, mid);
        push(2 * node + 2, mid + 1, end);
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    
    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }
    
    private int query(int node, int start, int end, int l, int r) {
        push(node, start, end);
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return tree[node];
        
        int mid = (start + end) / 2;
        return query(2 * node + 1, start, mid, l, r) + 
               query(2 * node + 2, mid + 1, end, l, r);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        LazyPropagation st = new LazyPropagation(arr);
        System.out.println("Sum [1,3]: " + st.query(1, 3));
        st.updateRange(1, 3, 10);
        System.out.println("Sum [1,3] after range update: " + st.query(1, 3));
    }
}
